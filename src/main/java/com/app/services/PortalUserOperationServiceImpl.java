package com.app.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.CreateFreezeRequest;
import com.app.dto.CreateMemberDetailsRequest;
import com.app.dto.CreateMemberTransferRequest;
import com.app.dto.CreateMembershipRequest;
import com.app.dto.CreatePersonalTrainingDetailsRequest;
import com.app.dto.CreateProspectDetailsRequest;
import com.app.dto.EmergencyContactRequest;
import com.app.dto.MemberDetailsResponse;
import com.app.dto.MembershipDetailsRequest;
import com.app.dto.MembershipDetailsResponse;
import com.app.dto.MembershipResponse;
import com.app.dto.PersonalTrainingDetailsResponse;
import com.app.dto.ProspectDetailsResponse;
import com.app.entities.BusinessUnitDetails;
import com.app.entities.CountryDetails;
import com.app.entities.EmergencyContactDetails;
import com.app.entities.FreezeRequestDetails;
import com.app.entities.MemberDetails;
import com.app.entities.MemberTransferDetails;
import com.app.entities.MembershipDetails;
import com.app.entities.MembershipTypes;
import com.app.entities.PersonalTrainingDetails;
import com.app.entities.ProspectDetails;
import com.app.exception.OperationNotSupportedException;
import com.app.exception.RecordNotFoundException;
import com.app.repositories.BusinessUnitDetailsRepository;
import com.app.repositories.CountryDetailsRepository;
import com.app.repositories.EmergencyContactDetailsRepository;
import com.app.repositories.FreezeRequestDetailsRepository;
import com.app.repositories.MemberDetailsRepository;
import com.app.repositories.MemberTransferDetailsRepository;
import com.app.repositories.MembershipDetailsRepository;
import com.app.repositories.MembershipTypeRepository;
import com.app.repositories.PersonalTrainingDetailsRepository;
import com.app.repositories.ProspectDetailsRepository;
import com.app.utils.DateUtils;

@Service
public class PortalUserOperationServiceImpl implements PortalUserOperationService {

	private static final Logger log = Logger.getLogger(PortalUserOperationServiceImpl.class);

	@Autowired
	private ProspectDetailsRepository prospectDetailsRepository;

	@Autowired
	private MemberDetailsRepository memberDetailsRepository;

	@Autowired
	private MembershipDetailsRepository membershipDetailsRepository;

	@Autowired
	private PersonalTrainingDetailsRepository personalTrainingDetailsRepository;

	@Autowired
	private BusinessUnitDetailsRepository businessUnitDetailsRepository;

	@Autowired
	private MembershipTypeRepository membershipTypeRepository;

	@Autowired
	private CountryDetailsRepository countryDetailsRepository;

	@Autowired
	private MemberTransferDetailsRepository memberTransferDetailsRepository;
	
	@Autowired
	private FreezeRequestDetailsRepository freezeRequestDetailsRepository;
	
	@Autowired
	private EmergencyContactDetailsRepository emergencyContactDetailsRepository;

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

		CreateMemberDetailsRequest memberDetails = createMembershipRequest.getMemberDetails();

		MembershipDetailsRequest membershipDetails = createMembershipRequest.getMembershipDetails();
		
		EmergencyContactRequest emergencyContact = createMembershipRequest.getMemberDetails().getEmergencyContactDetails();

		CountryDetails countryDetails = countryDetailsRepository.findCountryDetailsByCountryCodeIgnoreCase(memberDetails.getCountry());

		if (Objects.isNull(countryDetails)) {
			throw new RecordNotFoundException("No CountryDetails exist with given nationality ");
		}

		BusinessUnitDetails businessUnitDetails = businessUnitDetailsRepository.findById(Long.valueOf(memberDetails.getCompanyOrBusinessUnit())).orElse(null);

		if (Objects.isNull(businessUnitDetails)) {
			throw new RecordNotFoundException("No BusinessUnitDetails exist with given companyOrBusinessUnit ");
		}

		Long membershipTypeId = Long.valueOf(membershipDetails.getMembershipType());

		MembershipTypes membershipTypes = membershipTypeRepository.findById(membershipTypeId).orElse(null);

		if (Objects.isNull(membershipTypes)) {
			throw new RecordNotFoundException("No MembershipTypes exist with given membershipType ");
		}

		
		EmergencyContactDetails  emergencyContactDetailsEntity = new EmergencyContactDetails();
		
		BeanUtils.copyProperties(emergencyContact, emergencyContactDetailsEntity);
		emergencyContactDetailsRepository.save(emergencyContactDetailsEntity);
		
		
		MemberDetails memberDetailsEntity = new MemberDetails();
		BeanUtils.copyProperties(memberDetails, memberDetailsEntity);
		
		memberDetailsEntity.setBusinessUnitDetails(businessUnitDetails);
		//memberDetailsEntity.setMembershipDetails(membershipDetailsEntity);
		memberDetailsEntity.setCountryDetails(countryDetails);
		memberDetailsEntity.setEmergencyContactDetails(emergencyContactDetailsEntity);
		memberDetailsRepository.save(memberDetailsEntity);
		
		MembershipDetails membershipDetailsEntity = new MembershipDetails();
		BeanUtils.copyProperties(membershipDetails, membershipDetailsEntity);
		membershipDetailsEntity.setMemberDetails(memberDetailsEntity);
		membershipDetailsRepository.save(membershipDetailsEntity);
		
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

			if (Objects.nonNull(membershipDetailsEntity.getMemberDetails())) {

				MemberDetails memberDetails = membershipDetailsEntity.getMemberDetails();

				MemberDetailsResponse memeberDetailsResponse = new MemberDetailsResponse();
				BeanUtils.copyProperties(memberDetails, memeberDetailsResponse);

				// TODO - Change the type as planned
				String businessUnitId = String.valueOf(memberDetails.getBusinessUnitDetails().getId());
				memeberDetailsResponse.setCompanyOrBusinessUnit(businessUnitId);
				String nationality = memberDetails.getCountryDetails() == null ? "": memberDetails.getCountryDetails().getCountryCode();
				memeberDetailsResponse.setNationality(nationality);
				responseObject.setMemeberDetails(memeberDetailsResponse);
				
				if(Objects.nonNull(memberDetails.getEmergencyContactDetails())) {
					EmergencyContactRequest emergencyContactDetails = new EmergencyContactRequest();
					BeanUtils.copyProperties(memberDetails.getEmergencyContactDetails(), emergencyContactDetails);
					responseObject.setEmergencyContactDetails(emergencyContactDetails);
				}
			}
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

			if (Objects.nonNull(entity.getMemberDetails())) {

				MemberDetails memberDetails = entity.getMemberDetails();

				MemberDetailsResponse memeberDetailsResponse = new MemberDetailsResponse();
				BeanUtils.copyProperties(memberDetails, memeberDetailsResponse);

				// TODO - Change the type as planned
				String businessUnitId = String.valueOf(memberDetails.getBusinessUnitDetails().getId());
				memeberDetailsResponse.setCompanyOrBusinessUnit(businessUnitId);

				String nationality = memberDetails.getCountryDetails() == null ? "": memberDetails.getCountryDetails().getCountryCode();
				memeberDetailsResponse.setNationality(nationality);
				responseObject.setMemeberDetails(memeberDetailsResponse);
				
				if(Objects.nonNull(memberDetails.getEmergencyContactDetails())) {
					EmergencyContactRequest emergencyContactDetails = new EmergencyContactRequest();
					BeanUtils.copyProperties(memberDetails.getEmergencyContactDetails(), emergencyContactDetails);
					responseObject.setEmergencyContactDetails(emergencyContactDetails);
				}
			}
			responseList.add(responseObject);
		});

		log.info("getAllMembershipDetails() - end");
		return responseList;
	}

	
	/* ###################### PERSONAL TRAINING DETAILS SERVICE ####################### */
	 

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public Long createPersonalTrainingDetails(
			CreatePersonalTrainingDetailsRequest createPersonalTrainingDetailsRequest) {
		log.info("createPersonalTrainingDetails() - start");
		PersonalTrainingDetails entity = new PersonalTrainingDetails();
		BeanUtils.copyProperties(createPersonalTrainingDetailsRequest, entity);
		personalTrainingDetailsRepository.save(entity);
		log.info("createPersonalTrainingDetails() - end");
		return entity.getId();
	}

	@Override
	public PersonalTrainingDetailsResponse updatePersonalTrainingDetails(Long id,
			CreatePersonalTrainingDetailsRequest createPersonalTrainingDetailsRequest) {
		log.info("updatePersonalTrainingDetails() - start");
		PersonalTrainingDetails entity = personalTrainingDetailsRepository.findById(id).orElse(null);

		if (Objects.isNull(entity)) {
			throw new RecordNotFoundException("No such record exist with given id " + id);
		}
		log.info("updatePersonalTrainingDetails() - end");
		throw new AssertionError("Not yet implemented functionality");
	}

	@Override
	public PersonalTrainingDetailsResponse getPersonalTrainingDetailsById(Long id) {
		log.info("getPersonalTrainingDetailsById() - start");
		PersonalTrainingDetails entity = personalTrainingDetailsRepository.findById(id).orElse(null);

		PersonalTrainingDetailsResponse responseObject = null;
		if (entity != null) {
			responseObject = new PersonalTrainingDetailsResponse();
			BeanUtils.copyProperties(entity, responseObject);
		}
		log.info("getPersonalTrainingDetailsById() - end");
		return responseObject;
	}

	@Override
	public List<PersonalTrainingDetailsResponse> getAllPersonalTrainingDetails() {
		log.info("getAllPersonalTrainingDetails() - start");
		List<PersonalTrainingDetailsResponse> responseList = new ArrayList<PersonalTrainingDetailsResponse>();

		Iterable<PersonalTrainingDetails> dbContents = personalTrainingDetailsRepository.findAll();

		dbContents.forEach(entity -> {
			PersonalTrainingDetailsResponse responseObject = new PersonalTrainingDetailsResponse();
			BeanUtils.copyProperties(entity, responseObject);

			responseList.add(responseObject);
		});

		log.info("getAllPersonalTrainingDetails() - end");
		return responseList;
	}

	/** ############## MEMBER TRANSFER SERVICE ############################ */

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public Long createMemberTransfer(CreateMemberTransferRequest createMemberTransferRequest) {
		log.info("createMemberTransfer() - start");
		Long memberNumber = createMemberTransferRequest.getMemberNumber();
		MemberDetails memberDetails = memberDetailsRepository.findById(memberNumber).orElse(null);

		if (Objects.isNull(memberDetails)) {
			throw new RecordNotFoundException("No MemberDetails exist with given memberNumber " + memberNumber);
		}

		Long toBusinesssUnitId = createMemberTransferRequest.getToCompanyOrBusinessUnit();
		
		BusinessUnitDetails toBusinessUnitDetails = businessUnitDetailsRepository.findById(toBusinesssUnitId).orElse(null);

		if (Objects.isNull(toBusinessUnitDetails)) {
			throw new RecordNotFoundException(
					"No BusinessUnitDetails exist with given toCompanyOrBusinessUnit " + toBusinesssUnitId);
		}
		memberDetails.setBusinessUnitDetails(toBusinessUnitDetails);
		memberDetailsRepository.save(memberDetails);
		MemberTransferDetails memberTransferDetails = new MemberTransferDetails();
		BeanUtils.copyProperties(createMemberTransferRequest, memberTransferDetails);
		
		//TODO - Transfer from & TransferTo values are not saving.
		
		memberTransferDetailsRepository.save(memberTransferDetails);
		log.info("createMemberTransfer() - end");
		return memberTransferDetails.getId();
	}

	/*############# FREEZE REQUEST SERVICE ########################   */
	
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public Long createFreezeRequest(CreateFreezeRequest createFreezeRequest) {
		log.info("createFreezeRequest() - start");
		Long membershioNumber = createFreezeRequest.getMembershipId();
		MembershipDetails membershipDetails = membershipDetailsRepository.findById(membershioNumber).orElse(null);

		if (Objects.isNull(membershipDetails)) {
			throw new RecordNotFoundException("No MembershipDetails exist with given membershipId " + membershioNumber);
		}
		boolean isExpiryDateBeforFreezeStartDate = membershipDetails.getExpireDate().before(createFreezeRequest.getStartDate());

		if (isExpiryDateBeforFreezeStartDate) {
			String message = "This action can not be performed because expiry Date is before the freeze start date";
			throw new OperationNotSupportedException(message);
		}

		//TODO
		long numberOfDaysToSettle = DateUtils.getNumberOfDaysBetbeenDates(createFreezeRequest.getStartDate(),membershipDetails.getExpireDate());
		
		Date newExpiryDate = DateUtils.addNumberOfDaysInDate((int) numberOfDaysToSettle,membershipDetails.getExpireDate());
		membershipDetails.setExpireDate(newExpiryDate);
		membershipDetailsRepository.save(membershipDetails);

		FreezeRequestDetails freezeRequestDetails = new FreezeRequestDetails();
		BeanUtils.copyProperties(createFreezeRequest, freezeRequestDetails);

		freezeRequestDetailsRepository.save(freezeRequestDetails);
		log.info("createFreezeRequest() - end");
		return freezeRequestDetails.getId();
	}

}
