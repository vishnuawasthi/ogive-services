package com.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.app.dto.EmergencyContactRequest;
import com.app.dto.MembershipDetailsResponse;
import com.app.dto.PersonalTrainingDetailsResponse;
import com.app.dto.UpdateMemberDetailRequest;
import com.app.entities.EmergencyContactDetails;
import com.app.entities.MemberDetails;
import com.app.entities.MembershipDetails;
import com.app.entities.PersonalTrainingDetailView;
import com.app.entities.PortalUserDetails;
import com.app.exception.RecordNotFoundException;
import com.app.repositories.EmergencyContactDetailsRepository;
import com.app.repositories.MemberDetailsRepository;
import com.app.repositories.MembershipDetailsRepository;
import com.app.repositories.PersonalTrainingDetailViewRepository;
import com.app.repositories.PortalUserRepository;

@Service
public class MemberOperationServiceImpl implements MemberOperationService {

	private static final Logger log = LoggerFactory.getLogger(MemberOperationServiceImpl.class);
	
	@Autowired
	private PersonalTrainingDetailViewRepository personalTrainingDetailViewRepository;
	
	@Autowired
	private MembershipDetailsRepository membershipDetailsRepository;
	
	@Autowired
	private MemberDetailsRepository memberDetailsRepository;
	
	@Autowired
	private EmergencyContactDetailsRepository  emergencyContactDetailsRepository;
	
	@Autowired
	private PortalUserRepository portalUserRepository;

	@Override
	public List<PersonalTrainingDetailsResponse> getPersonalTrainingsByMemberId(Long memberId) {
		log.info("getPersonalTrainingsByMemberId() - start");

		List<PersonalTrainingDetailsResponse> personalTrainings = new ArrayList<PersonalTrainingDetailsResponse>();
		
		List<PersonalTrainingDetailView> dbContents = personalTrainingDetailViewRepository.findAllPersonalTrainingDetailViewByMemberIdOrderByStartDateDesc(memberId);

		dbContents.stream().forEach(personalTraining -> {
			PersonalTrainingDetailsResponse responseObject = new PersonalTrainingDetailsResponse();
			BeanUtils.copyProperties(personalTraining, responseObject);
			personalTrainings.add(responseObject);
			
		});

		log.info("getPersonalTrainingsByMemberId() - end");
		return personalTrainings;
	}
	
	
	@Override
	public List<MembershipDetailsResponse> loadMembershipDetailByMemberId(Long memberId) {
		log.info("loadMembershipDetailByMemberId() - start");
		List<MembershipDetailsResponse> membershipsList = new ArrayList<MembershipDetailsResponse>();
		List<MembershipDetails> dbContents = membershipDetailsRepository.loadMembershipDetailByMemberId(memberId);
		dbContents.stream().forEach(membership -> {
			MembershipDetailsResponse responseObject = new MembershipDetailsResponse();
			BeanUtils.copyProperties(membership, responseObject);
			membershipsList.add(responseObject);
		});
		log.info("loadMembershipDetailByMemberId() - start");
		return membershipsList;
	}


	@Override
	public MembershipDetailsResponse loadMembershipDetailByMemberIdAndMembershipNumber(Long memberId,
			Long membershipId) {
		log.info("loadMembershipDetailByMemberIdAndMembershipNumber() - start");
		MembershipDetails entity =membershipDetailsRepository.loadMembershipDetailByMemberIdAndMembershipNumber(memberId, membershipId);
		MembershipDetailsResponse responseObject = null;
		if(Objects.nonNull(entity)){
			responseObject =new MembershipDetailsResponse();
			BeanUtils.copyProperties(entity, responseObject);
		}
		
		log.info("loadMembershipDetailByMemberIdAndMembershipNumber() - start");
		return responseObject;
	}


	@Override
	public PersonalTrainingDetailsResponse getPersonalTrainingsByMemberIdAndId(Long memberId, Long trainingId) {
		log.info("getPersonalTrainingsByMemberIdAndId() - start");

		PersonalTrainingDetailView entity = personalTrainingDetailViewRepository
				.findPersonalTrainingDetailViewByMemberIdAndId(memberId, trainingId);
		PersonalTrainingDetailsResponse responseObject = null;

		if (Objects.nonNull(entity)) {
			responseObject = new PersonalTrainingDetailsResponse();
			BeanUtils.copyProperties(entity, responseObject);
		}

		log.info("getPersonalTrainingsByMemberIdAndId() - end");
		return responseObject;
	}


	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void updateMemberDetails(Long id, UpdateMemberDetailRequest request) {
		log.info("updateMemberDetails() - start");

		MemberDetails entity = memberDetailsRepository.findById(id).orElse(null);

		if (Objects.isNull(entity)) {
			throw new RecordNotFoundException("No MemberDetails record exist with given id " + id);
		}
		
		PortalUserDetails portalUserDetails = portalUserRepository.findByUsername(String.valueOf(id));
		
		if (Objects.isNull(portalUserDetails)) {
			throw new RecordNotFoundException("No PortalUserDetails record exist with given id " + id);
		}

		if (!StringUtils.isEmpty(request.getFirstName())) {
			entity.setFirstName(request.getFirstName());
			portalUserDetails.setFirstname(request.getFirstName());
		}

		if (!StringUtils.isEmpty(request.getMiddleName())) {
			entity.setMiddleName(request.getMiddleName());
			portalUserDetails.setMiddlename(request.getMiddleName());
		}

		if (!StringUtils.isEmpty(request.getLastName())) {
			entity.setLastName(request.getLastName());
			portalUserDetails.setLastname(request.getLastName());
		}

		if (!StringUtils.isEmpty(request.getDisplayName())) {
			entity.setDisplayName(request.getDisplayName());
		}

		if (!StringUtils.isEmpty(request.getMobileNumber())) {
			entity.setMobileNumber(request.getMobileNumber());
		}

		if (!StringUtils.isEmpty(request.getEmail())) {
			entity.setEmail(request.getEmail());
			portalUserDetails.setEmail(request.getEmail());
		}

		if (!StringUtils.isEmpty(request.getDateOfBirth())) {
			entity.setDateOfBirth(request.getDateOfBirth());
			portalUserDetails.setDateOfBirth(request.getDateOfBirth());
		}
		
		memberDetailsRepository.save(entity);
		
		portalUserRepository.save(portalUserDetails);
		
		if (Objects.nonNull(request.getEmergencyContactDetails())) {

			EmergencyContactRequest emergecyContactRequest = request.getEmergencyContactDetails();
			
			EmergencyContactDetails emergencyContactDetailsEntity = entity.getEmergencyContactDetails();

			if(Objects.isNull(emergencyContactDetailsEntity)) {
				emergencyContactDetailsEntity = new EmergencyContactDetails();
				emergencyContactDetailsEntity.setMemberDetails(entity);
			}
			
			if (!StringUtils.isEmpty(emergecyContactRequest.getAddress())) {
				emergencyContactDetailsEntity.setAddress(emergecyContactRequest.getAddress());
			}

			if (!StringUtils.isEmpty(emergecyContactRequest.getContactName())) {
				emergencyContactDetailsEntity.setContactName(emergecyContactRequest.getContactName());
			}

			if (!StringUtils.isEmpty(emergecyContactRequest.getContactNumber())) {
				emergencyContactDetailsEntity.setContactNumber(emergecyContactRequest.getContactNumber());
			}

			if (!StringUtils.isEmpty(emergecyContactRequest.getRelationship())) {
				emergencyContactDetailsEntity.setRelationship(emergecyContactRequest.getRelationship());
			}
			
			emergencyContactDetailsRepository.save(emergencyContactDetailsEntity);
		}
		
		log.info("updateMemberDetails() - end");
	}
	
}
