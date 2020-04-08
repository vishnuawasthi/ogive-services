package com.app.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.CreateMembershipRequest;
import com.app.dto.CreateProspectDetailsRequest;
import com.app.dto.MemberDetailsRequest;
import com.app.dto.MemberDetailsResponse;
import com.app.dto.MembershipDetailsRequest;
import com.app.dto.MembershipDetailsResponse;
import com.app.dto.MembershipResponse;
import com.app.dto.ProspectDetailsResponse;
import com.app.entities.MemberDetails;
import com.app.entities.MembershipDetails;
import com.app.entities.ProspectDetails;
import com.app.repositories.MemberDetailsRepository;
import com.app.repositories.MembershipDetailsRepository;
import com.app.repositories.ProspectDetailsRepository;

@Service
public class PortalUserOperationServiceImpl implements PortalUserOperationService {

	private static final Logger log = Logger.getLogger(PortalUserOperationServiceImpl.class);

	@Autowired
	private ProspectDetailsRepository prospectDetailsRepository;

	@Autowired
	private MemberDetailsRepository memberDetailsRepository;

	@Autowired
	private MembershipDetailsRepository membershipDetailsRepository;

	/** ######################### PROSPECT SERVICES ###################### */

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public Long createProspectDetails(CreateProspectDetailsRequest createProspectDetailsRequest) {
		log.info("createProspectDetails() - start");
		ProspectDetails entity = new ProspectDetails();
		BeanUtils.copyProperties(createProspectDetailsRequest, entity);
		prospectDetailsRepository.save(entity);
		log.info("createProspectDetails() - end");
		return entity.getId();
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public ProspectDetailsResponse updateCreateProspectDetails(Long id,
			CreateProspectDetailsRequest createProspectDetailsRequest) {
		log.info("updateCreateProspectDetails() - start");
		ProspectDetails entity = prospectDetailsRepository.findById(id).orElse(null);

		log.info("updateCreateProspectDetails() - end");
		return null;
	}

	@Override
	public List<ProspectDetailsResponse> getAllProspects() {
		log.info("getAllProspects() - start");
		Iterable<ProspectDetails> prospectDetailsList = prospectDetailsRepository.findAll();
		List<ProspectDetailsResponse> responseObjectList = new ArrayList<ProspectDetailsResponse>();
		prospectDetailsList.forEach(entity -> {
			ProspectDetailsResponse responseObject = new ProspectDetailsResponse();
			BeanUtils.copyProperties(entity, responseObject);
			responseObjectList.add(responseObject);
		});
		log.info("getAllProspects() - end");
		return responseObjectList;
	}

	@Override
	public ProspectDetailsResponse getProspectById(Long id) {
		log.info("getProspectById() - end");
		ProspectDetails entity = prospectDetailsRepository.findById(id).orElse(null);
		ProspectDetailsResponse responseObject = null;
		if (null != entity) {
			responseObject = new ProspectDetailsResponse();
			BeanUtils.copyProperties(entity, responseObject);
		}
		log.info("getProspectById() - end");
		return responseObject;
	}

	/** ######################### MEMBERSHIP SERVICES ###################### */

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public Long createMembership(CreateMembershipRequest createMembershipRequest) {
		log.info("createMembership() - start");
		
		MemberDetailsRequest memberDetails = createMembershipRequest.getPersonalDetails();
		
		MembershipDetailsRequest membershipDetails = createMembershipRequest.getMembershipDetails();

		MembershipDetails membershipDetailsEntity = new MembershipDetails();
		BeanUtils.copyProperties(membershipDetails, membershipDetailsEntity);
		membershipDetailsRepository.save(membershipDetailsEntity);

		MemberDetails memberDetailsEntity = new MemberDetails();
		BeanUtils.copyProperties(memberDetails, memberDetailsEntity);
		memberDetailsEntity.setMembershipDetails(membershipDetailsEntity);

		memberDetailsRepository.save(memberDetailsEntity);
		log.info("createMembership() - end");
		return membershipDetailsEntity.getId();
	}

	@Override
	public MembershipResponse getMembershipDetailsById(Long id) {
		log.info("getMembershipDetailsById() - start");
		MembershipDetails membershipDetailsEntity = membershipDetailsRepository.findById(id).orElse(null);
		MembershipResponse responseObject = new MembershipResponse();

		if (membershipDetailsEntity != null) {
			MembershipDetailsResponse membershipDetailsResponse = new MembershipDetailsResponse();
			BeanUtils.copyProperties(membershipDetailsEntity, membershipDetailsResponse);
			responseObject.setMembershipDetails(membershipDetailsResponse);
			MemberDetailsResponse memeberDetailsResponse = new MemberDetailsResponse();
			BeanUtils.copyProperties(membershipDetailsEntity.getMemberDetails(), memeberDetailsResponse);
			responseObject.setMemeberDetails(memeberDetailsResponse);
		}
		log.info("getMembershipDetailsById() - end");
		return responseObject;
	}

	@Override
	public List<MembershipResponse> getAllMembershipDetails() {
		log.info("getAllMembershipDetails() - start");
		Iterable<MembershipDetails> membershpEntities = membershipDetailsRepository.findAll();

		List<MembershipResponse> responseList = new ArrayList<MembershipResponse>();

		membershpEntities.forEach(entity -> {
			MembershipResponse responseObject = new MembershipResponse();
			MembershipDetailsResponse membershipDetailsResponse = new MembershipDetailsResponse();
			BeanUtils.copyProperties(entity, membershipDetailsResponse);
			responseObject.setMembershipDetails(membershipDetailsResponse);

			if (null != entity.getMemberDetails()) {
				MemberDetailsResponse memeberDetailsResponse = new MemberDetailsResponse();
				BeanUtils.copyProperties(entity.getMemberDetails(), memeberDetailsResponse);
				responseObject.setMemeberDetails(memeberDetailsResponse);
			}
			responseList.add(responseObject);
		});

		log.info("getAllMembershipDetails() - end");
		return responseList;
	}

}
