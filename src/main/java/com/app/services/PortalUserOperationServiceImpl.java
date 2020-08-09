package com.app.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.constants.Authorities;
import com.app.dto.CreateFreezeRequest;
import com.app.dto.CreateMemberDetailsRequest;
import com.app.dto.CreateMemberTransferRequest;
import com.app.dto.CreateMembershipRequest;
import com.app.dto.CreatePersonalTrainingDetailRequest;
import com.app.dto.CreateProspectDetailsRequest;
import com.app.dto.EmergencyContactRequest;
import com.app.dto.GetMembershipDetail;
import com.app.dto.MemberDetailsResponse;
import com.app.dto.MembershipDetailsRequest;
import com.app.dto.MembershipDetailsResponse;
import com.app.dto.MembershipResponse;
import com.app.dto.PersonalTrainingDetailsResponse;
import com.app.dto.ProspectDetailsResponse;
import com.app.entities.AddressDetails;
import com.app.entities.BusinessUnitDetails;
import com.app.entities.CountryDetails;
import com.app.entities.EmergencyContactDetails;
import com.app.entities.FreezeRequestDetails;
import com.app.entities.MemberDetails;
import com.app.entities.MemberTransferDetails;
import com.app.entities.MembershipDetails;
import com.app.entities.MembershipType;
import com.app.entities.PersonalTrainingDetail;
import com.app.entities.PersonalTrainingDetailView;
import com.app.entities.PersonalTrainingType;
import com.app.entities.PortalUserDetails;
import com.app.entities.ProspectDetails;
import com.app.entities.StaffDetails;
import com.app.entities.UserAuthority;
import com.app.exception.OperationNotSupportedException;
import com.app.exception.RecordNotFoundException;
import com.app.filter.criteria.MemberSearchCriteria;
import com.app.filter.criteria.MembershipFilterCriteria;
import com.app.repositories.AddressDetailsRepository;
import com.app.repositories.BusinessUnitDetailsRepository;
import com.app.repositories.CountryDetailsRepository;
import com.app.repositories.EmergencyContactDetailsRepository;
import com.app.repositories.FreezeRequestDetailsRepository;
import com.app.repositories.MemberDetailsRepository;
import com.app.repositories.MemberTransferDetailsRepository;
import com.app.repositories.MembershipDetailsRepository;
import com.app.repositories.MembershipTypeRepository;
import com.app.repositories.PersonalTrainingDetailViewRepository;
import com.app.repositories.PersonalTrainingDetailsRepository;
import com.app.repositories.PersonalTrainingTypeRepository;
import com.app.repositories.PortalUserRepository;
import com.app.repositories.ProspectDetailsRepository;
import com.app.repositories.StaffDetailsRepository;
import com.app.repositories.UserAuthoritiesRepository;
import com.app.specification.MemberDetailsSpecification;
import com.app.specification.MembershipDetailsSpecification;
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
	
	@Autowired
	private StaffDetailsRepository staffDetailsRepository;
	
	@Autowired
	private AddressDetailsRepository addressDetailsRepository;
	
	@Autowired
	private PersonalTrainingTypeRepository personalTrainingTypeRepository;
	
	@Value("${application.member.default.password}")
	private String memberDefaultPassword;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private PortalUserRepository portalUserRepository;

	@Autowired
	private UserAuthoritiesRepository authoritiesRepository;
	
	@Autowired
	private PersonalTrainingDetailViewRepository personalTrainingDetailViewRepository;

	/** ######################### PROSPECT SERVICES ###################### */

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public Long createProspectDetails(CreateProspectDetailsRequest request) {
		log.info("createProspectDetails() - start");
		MemberDetails entity = new MemberDetails();
		BeanUtils.copyProperties(request, entity);
		
		BusinessUnitDetails businessUnitDetails   = businessUnitDetailsRepository.findById(request.getCompanyOrBusinessUnit()).orElse(null);
		
		if (Objects.isNull(businessUnitDetails)) {
			throw new RecordNotFoundException("No BusinessUnitDetails exist with given companyOrBusinessUnit "+request.getCompanyOrBusinessUnit());
		}
		
		CountryDetails countryDetails  = countryDetailsRepository.findCountryDetailsByCountryCodeIgnoreCase(request.getCountryCode());	
		
		if (Objects.isNull(countryDetails)) {
			throw new RecordNotFoundException("No CountryDetails exist with given countryCode "+request.getCountryCode());
		}

		AddressDetails addressDetails = new AddressDetails();
		BeanUtils.copyProperties(request, addressDetails);
		addressDetailsRepository.save(addressDetails);
		
		
		entity.setBusinessUnitDetails(businessUnitDetails);
		entity.setCountryDetails(countryDetails);
		entity.setAddressDetails(addressDetails);
		
		
		EmergencyContactRequest emergencyContactRequest = request.getEmergencyContactDetails();

		if (Objects.nonNull(emergencyContactRequest)) {
			EmergencyContactDetails emergencyContactEntity = new EmergencyContactDetails();
			BeanUtils.copyProperties(emergencyContactRequest, emergencyContactEntity);
			emergencyContactDetailsRepository.save(emergencyContactEntity);
			entity.setEmergencyContactDetails(emergencyContactEntity);
		}
		
		memberDetailsRepository.save(entity);
		log.info("createProspectDetails() - end");
		return entity.getId();
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public ProspectDetailsResponse updateCreateProspectDetails(Long id,CreateProspectDetailsRequest createProspectDetailsRequest) {
		log.info("updateCreateProspectDetails() - start");
		ProspectDetails entity = prospectDetailsRepository.findById(id).orElse(null);

		log.info("updateCreateProspectDetails() - end");
		return null;
	}

	@Override
	public List<ProspectDetailsResponse> getAllProspects(MemberSearchCriteria memberSearchCriteria) {
		log.info("getAllProspects() - start");
		Iterable<MemberDetails> prospectDetailsList = memberDetailsRepository.findAll(new MemberDetailsSpecification(memberSearchCriteria));
		List<ProspectDetailsResponse> responseObjectList = new ArrayList<ProspectDetailsResponse>();
		prospectDetailsList.forEach(entity -> {
			ProspectDetailsResponse responseObject = new ProspectDetailsResponse();
			
			BeanUtils.copyProperties(entity, responseObject);
			
			Long businessUnitId = Objects.nonNull(entity.getBusinessUnitDetails())
					? entity.getBusinessUnitDetails().getId()
					: null;
			responseObject.setCompanyOrBusinessUnit(businessUnitId);

			AddressDetails addressDetails = entity.getAddressDetails();
			
			if (Objects.nonNull(addressDetails)) {
				responseObject.setAddressLine1(addressDetails.getAddressLine1());
				responseObject.setAddressLine2(addressDetails.getAddressLine2());
				responseObject.setCity(addressDetails.getCity());
				responseObject.setPoBoxNumber(addressDetails.getPoBoxNumber());
				responseObject.setState(addressDetails.getState());
				responseObject.setCountryCode(addressDetails.getCountryCode());
			}
			EmergencyContactRequest emergencyContactDetails = null;

			if (Objects.nonNull(entity.getEmergencyContactDetails())) {
				emergencyContactDetails = new EmergencyContactRequest();
				BeanUtils.copyProperties(entity.getEmergencyContactDetails(), emergencyContactDetails);
			}

			responseObject.setEmergencyContactDetails(emergencyContactDetails);
			responseObjectList.add(responseObject);

		});
		log.info("getAllProspects() - end");
		return responseObjectList;
	}

	@Override
	public ProspectDetailsResponse getProspectById(Long id) {
		log.info("getProspectById() - end");
		MemberDetails entity = memberDetailsRepository.findById(id).orElse(null);
		ProspectDetailsResponse responseObject = null;
		if (null != entity) {
			responseObject = new ProspectDetailsResponse();
			BeanUtils.copyProperties(entity, responseObject);

			Long businessUnitId = Objects.nonNull(entity.getBusinessUnitDetails())
					? entity.getBusinessUnitDetails().getId()
					: null;
			responseObject.setCompanyOrBusinessUnit(businessUnitId);

			AddressDetails addressDetails = entity.getAddressDetails();

			if (Objects.nonNull(addressDetails)) {
				responseObject.setAddressLine1(addressDetails.getAddressLine1());
				responseObject.setAddressLine2(addressDetails.getAddressLine2());
				responseObject.setCity(addressDetails.getCity());
				responseObject.setPoBoxNumber(addressDetails.getPoBoxNumber());
				responseObject.setState(addressDetails.getState());
				responseObject.setCountryCode(addressDetails.getCountryCode());
			}
			EmergencyContactRequest emergencyContactDetails = null;

			if (Objects.nonNull(entity.getEmergencyContactDetails())) {
				emergencyContactDetails = new EmergencyContactRequest();
				BeanUtils.copyProperties(entity.getEmergencyContactDetails(), emergencyContactDetails);
			}

			responseObject.setEmergencyContactDetails(emergencyContactDetails);
		}
		log.info("getProspectById() - end");
		return responseObject;
	}

	/** ######################### MEMBERSHIP SERVICES ###################### */

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public GetMembershipDetail createMembership(CreateMembershipRequest createMembershipRequest) {
		log.info("createMembership() - start");

		CreateMemberDetailsRequest memberDetails = createMembershipRequest.getMemberDetails();

		MembershipDetailsRequest membershipDetails = createMembershipRequest.getMembershipDetails();
		
		EmergencyContactRequest emergencyContact = createMembershipRequest.getMemberDetails().getEmergencyContactDetails();

		CountryDetails countryDetails = countryDetailsRepository.findCountryDetailsByCountryCodeIgnoreCase(memberDetails.getCountryCode());

		if (Objects.isNull(countryDetails)) {
			throw new RecordNotFoundException("No CountryDetails exist with given nationality ");
		}

		BusinessUnitDetails businessUnitDetails = businessUnitDetailsRepository.findById(Long.valueOf(memberDetails.getCompanyOrBusinessUnit())).orElse(null);

		if (Objects.isNull(businessUnitDetails)) {
			throw new RecordNotFoundException("No BusinessUnitDetails exist with given companyOrBusinessUnit ");
		}

		Long membershipTypeId = Long.valueOf(membershipDetails.getMembershipType());

		MembershipType membershipTypes = membershipTypeRepository.findById(membershipTypeId).orElse(null);

		if (Objects.isNull(membershipTypes)) {
			throw new RecordNotFoundException("No MembershipTypes exist with given membershipType ");
		}

		StaffDetails staffDetails = staffDetailsRepository.findById(membershipDetails.getAdvisorId()).orElse(null);
		
		if (Objects.isNull(staffDetails)) {
			throw new RecordNotFoundException("No StaffDetails exist with given advisorId "+membershipDetails.getAdvisorId());
		}
		
		EmergencyContactDetails  emergencyContactDetailsEntity = new EmergencyContactDetails();
		BeanUtils.copyProperties(emergencyContact, emergencyContactDetailsEntity);
		emergencyContactDetailsRepository.save(emergencyContactDetailsEntity);
		
		
		MemberDetails memberDetailsEntity = new MemberDetails();
		BeanUtils.copyProperties(memberDetails, memberDetailsEntity);
		
		memberDetailsEntity.setBusinessUnitDetails(businessUnitDetails);
		memberDetailsEntity.setCountryDetails(countryDetails);
		memberDetailsEntity.setEmergencyContactDetails(emergencyContactDetailsEntity);
		
		AddressDetails addressDetails = new AddressDetails();
		BeanUtils.copyProperties(memberDetails, addressDetails);
		addressDetailsRepository.save(addressDetails);
		
		memberDetailsEntity.setAddressDetails(addressDetails);
		memberDetailsRepository.save(memberDetailsEntity);
		
		//MEMBERSHIP DETAILS
		MembershipDetails membershipDetailsEntity = new MembershipDetails();
		BeanUtils.copyProperties(membershipDetails, membershipDetailsEntity);
		
		membershipDetailsEntity.setMemberDetails(memberDetailsEntity);
		membershipDetailsEntity.setMembershipTypes(membershipTypes);
		membershipDetailsEntity.setStaffDetails(staffDetails);
		
		membershipDetailsRepository.save(membershipDetailsEntity);
		
		PortalUserDetails portalUserDetails = new PortalUserDetails();
		portalUserDetails.setFirstname(memberDetailsEntity.getFirstName());
		portalUserDetails.setLastname(memberDetailsEntity.getLastName());
		portalUserDetails.setEmail(memberDetailsEntity.getEmail());
		
		portalUserDetails.setUsername(String.valueOf(memberDetailsEntity.getId()));
		String encodedPassword =  passwordEncoder.encode(memberDefaultPassword);
		portalUserDetails.setPassword(encodedPassword);
		portalUserDetails.setGender(memberDetailsEntity.getGender());
		portalUserDetails.setContactNumber(memberDetailsEntity.getMobileNumber());
		
		portalUserRepository.save(portalUserDetails);
		UserAuthority auth = new UserAuthority();
		auth.setAuthority(Authorities.MEMBER);
		auth.setDescription("Created Through Membership Registraion Process");
		auth.setPortalUserDetails(portalUserDetails);
		authoritiesRepository.save(auth);
		
		GetMembershipDetail  getMembershipDetail = new GetMembershipDetail();
		getMembershipDetail.setMemberId(memberDetailsEntity.getId());
		getMembershipDetail.setMembershipId(membershipDetailsEntity.getId());
		log.info("createMembership() - end");
		return getMembershipDetail;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public MembershipResponse getMembershipDetailsById(Long id) {
		log.info("getMembershipDetailsById() - start");
		MembershipDetails membershipDetailsEntity = membershipDetailsRepository.findById(id).orElse(null);
		MembershipResponse responseObject = new MembershipResponse();

		if (membershipDetailsEntity != null) {
			
			MembershipDetailsResponse membershipDetailsResponse = new MembershipDetailsResponse();
			BeanUtils.copyProperties(membershipDetailsEntity, membershipDetailsResponse);

			Long advisorId = Objects.nonNull(membershipDetailsEntity.getStaffDetails())?membershipDetailsEntity.getStaffDetails().getId():null;
			String advisorName= Objects.nonNull(membershipDetailsEntity.getStaffDetails())?membershipDetailsEntity.getStaffDetails().getFirstName()+" "+membershipDetailsEntity.getStaffDetails().getLastName():null;
			
			Long membershipType =Objects.nonNull(membershipDetailsEntity.getMembershipTypes())?membershipDetailsEntity.getMembershipTypes().getId():null;
			String membershipTypeName  = Objects.nonNull(membershipDetailsEntity.getMembershipTypes())?membershipDetailsEntity.getMembershipTypes().getMembershipTypeName():null;
			
			membershipDetailsResponse.setAdvisorId(advisorId);
			membershipDetailsResponse.setAdvisorName(advisorName);
			
			membershipDetailsResponse.setMembershipTypeName(membershipTypeName);
			membershipDetailsResponse.setMembershipType(membershipType);
			
			responseObject.setMembershipDetails(membershipDetailsResponse);

			if (Objects.nonNull(membershipDetailsEntity.getMemberDetails())) {

				MemberDetails memberDetails = membershipDetailsEntity.getMemberDetails();
				MemberDetailsResponse memeberDetailsResponse = new MemberDetailsResponse();
				BeanUtils.copyProperties(memberDetails, memeberDetailsResponse);

				// TODO - Change the type as planned
				Long businessUnitId =Objects.nonNull(memberDetails.getBusinessUnitDetails()) ?memberDetails.getBusinessUnitDetails().getId():null;
				memeberDetailsResponse.setCompanyOrBusinessUnit(businessUnitId);
				
				
				populateAddressDetailsInResponse( memberDetails , memeberDetailsResponse );
				EmergencyContactRequest emergencyContactDetails = null;
				if(Objects.nonNull(memberDetails.getEmergencyContactDetails())) {
					emergencyContactDetails = new EmergencyContactRequest();
					BeanUtils.copyProperties(memberDetails.getEmergencyContactDetails(), emergencyContactDetails);
				}
				
				memeberDetailsResponse.setEmergencyContactDetails(emergencyContactDetails);
				responseObject.setMemeberDetails(memeberDetailsResponse);
			}
		}
		log.info("getMembershipDetailsById() - end");
		return responseObject;
	}
	
	private void populateAddressDetailsInResponse(MemberDetails memberDetails ,MemberDetailsResponse memeberDetailsResponse ) {
		AddressDetails addressDetails =	memberDetails.getAddressDetails();
		if(Objects.nonNull(addressDetails)) {
			memeberDetailsResponse.setAddressLine1(addressDetails.getAddressLine1());
			memeberDetailsResponse.setAddressLine2(addressDetails.getAddressLine2());
			memeberDetailsResponse.setCity(addressDetails.getCity());
			memeberDetailsResponse.setPoBoxNumber(addressDetails.getPoBoxNumber());
			memeberDetailsResponse.setState(addressDetails.getState());
			memeberDetailsResponse.setCountryCode(addressDetails.getCountryCode());
		}
	}

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public List<MembershipResponse> getAllMembershipDetails() {
		log.info("getAllMembershipDetails() - start");
		Iterable<MembershipDetails> membershpEntities = membershipDetailsRepository.findAll();

		List<MembershipResponse> responseList = new ArrayList<MembershipResponse>();
		
		membershpEntities.forEach(entity -> {
			convertEntityToMembershipResponse(entity,responseList);
		});

		log.info("getAllMembershipDetails() - end");
		return responseList;
	}
	
	private void convertEntityToMembershipResponse( MembershipDetails entity,List<MembershipResponse> responseList){
		
		MembershipResponse responseObject = new MembershipResponse();
		MembershipDetailsResponse membershipDetailsResponse = new MembershipDetailsResponse();
		BeanUtils.copyProperties(entity, membershipDetailsResponse);
		
		Long advisorId = Objects.nonNull(entity.getStaffDetails())?entity.getStaffDetails().getId():null;
		String advisorName= Objects.nonNull(entity.getStaffDetails())?entity.getStaffDetails().getFirstName()+" "+entity.getStaffDetails().getLastName():null;
		
		Long membershipType =Objects.nonNull(entity.getMembershipTypes())?entity.getMembershipTypes().getId():null;
		String membershipTypeName  = Objects.nonNull(entity.getMembershipTypes())?entity.getMembershipTypes().getMembershipTypeName():null;
		
		membershipDetailsResponse.setAdvisorId(advisorId);
		membershipDetailsResponse.setAdvisorName(advisorName);
		
		membershipDetailsResponse.setMembershipTypeName(membershipTypeName);
		membershipDetailsResponse.setMembershipType(membershipType);
		
		responseObject.setMembershipDetails(membershipDetailsResponse);

		if (Objects.nonNull(entity.getMemberDetails())) {

			MemberDetails memberDetails = entity.getMemberDetails();

			MemberDetailsResponse memeberDetailsResponse = new MemberDetailsResponse();
			BeanUtils.copyProperties(memberDetails, memeberDetailsResponse);

			// TODO - Change the type as planned
			Long businessUnitId =Objects.nonNull(memberDetails.getBusinessUnitDetails()) ?memberDetails.getBusinessUnitDetails().getId():null;
			memeberDetailsResponse.setCompanyOrBusinessUnit(businessUnitId);
			EmergencyContactRequest emergencyContactDetails =null;
			populateAddressDetailsInResponse( memberDetails , memeberDetailsResponse );
			
			if(Objects.nonNull(memberDetails.getEmergencyContactDetails())) {
				emergencyContactDetails = new EmergencyContactRequest();
				BeanUtils.copyProperties(memberDetails.getEmergencyContactDetails(), emergencyContactDetails);
				
			}
			memeberDetailsResponse.setEmergencyContactDetails(emergencyContactDetails);
			responseObject.setMemeberDetails(memeberDetailsResponse);
		}
		responseList.add(responseObject);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public List<MembershipResponse> getAllMembershipDetailWithFilter(MembershipFilterCriteria criteria) {
		log.info("getAllMembershipDetailWithFilter() - end");
		List<MembershipResponse> responseList = new ArrayList<MembershipResponse>();
		Iterable<MembershipDetails> membershpEntities = membershipDetailsRepository.findAll(new MembershipDetailsSpecification(criteria));

		membershpEntities.forEach(entity -> {
			convertEntityToMembershipResponse(entity, responseList);
		});
		log.info("getAllMembershipDetailWithFilter() - end");
		return responseList;
	}

	
	/* ###################### PERSONAL TRAINING DETAILS SERVICE ####################### */
	 

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public Long createPersonalTrainingDetails(CreatePersonalTrainingDetailRequest request) {
		log.info("createPersonalTrainingDetails() - start");
		PersonalTrainingDetail entity = new PersonalTrainingDetail();

		Long advisorId = request.getAdvisorId();

		Long trainerId = request.getTrainerId();

		Long membershipId = request.getMembershipId();

		Long companyOrBusinessUnit = request.getCompanyOrBusinessUnit();

		Long personalTrainingTypeId = request.getPersonalTrainingType();

		StaffDetails advisor = staffDetailsRepository.findById(advisorId).orElse(null);

		if (Objects.isNull(advisor)) {
			throw new RecordNotFoundException("No StaffDetails exist with given advisorId " + advisorId);
		}

		StaffDetails trainer = staffDetailsRepository.findById(trainerId).orElse(null);

		if (Objects.isNull(trainer)) {
			throw new RecordNotFoundException("No StaffDetails exist with given trainerId " + trainerId);
		}

		MembershipDetails membershipDetails = membershipDetailsRepository.findById(membershipId).orElse(null);

		if (Objects.isNull(membershipDetails)) {
			throw new RecordNotFoundException("No MembershipDetails exist with given membershipId " + membershipId);
		}

		PersonalTrainingType personalTrainingType = personalTrainingTypeRepository.findById(personalTrainingTypeId).orElse(null);
		
		if (Objects.isNull(personalTrainingType)) {
			throw new RecordNotFoundException("No PersonalTrainingType exist with given personalTrainingType " + membershipId);
		}
		
		BusinessUnitDetails businessUnitDetails  =  businessUnitDetailsRepository.findById(companyOrBusinessUnit).orElse(null);
		
		if (Objects.isNull(businessUnitDetails)) {
			throw new RecordNotFoundException("No BusinessUnitDetails exist with given companyOrBusinessUnit " + companyOrBusinessUnit);
		}
		
		BeanUtils.copyProperties(request, entity);
		
		entity.setMembershipDetails(membershipDetails);
		entity.setTrainerDetails(trainer);
		entity.setAdvisorDetails(advisor);
		entity.setPersonalTrainingType(personalTrainingType);
		entity.setBusinessUnitDetails(businessUnitDetails);

		personalTrainingDetailsRepository.save(entity);
		log.info("createPersonalTrainingDetails() - end");
		return entity.getId();
	}

	@Override
	public PersonalTrainingDetailsResponse updatePersonalTrainingDetails(Long id,
			CreatePersonalTrainingDetailRequest createPersonalTrainingDetailsRequest) {
		log.info("updatePersonalTrainingDetails() - start");
		PersonalTrainingDetail entity = personalTrainingDetailsRepository.findById(id).orElse(null);

		if (Objects.isNull(entity)) {
			throw new RecordNotFoundException("No such record exist with given id " + id);
		}
		log.info("updatePersonalTrainingDetails() - end");
		throw new AssertionError("Not yet implemented functionality");
	}

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public PersonalTrainingDetailsResponse getPersonalTrainingDetailsById(Long id) {
		log.info("getPersonalTrainingDetailsById() - start");
		//PersonalTrainingDetail entity = personalTrainingDetailsRepository.findById(id).orElse(null);
		PersonalTrainingDetailView entity =personalTrainingDetailViewRepository.findById(id).orElse(null);
		PersonalTrainingDetailsResponse responseObject = null;
		if (entity != null) {
			responseObject = new PersonalTrainingDetailsResponse();
			BeanUtils.copyProperties(entity, responseObject);
		}
		log.info("getPersonalTrainingDetailsById() - end");
		return responseObject;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public List<PersonalTrainingDetailsResponse> getAllPersonalTrainingDetails() {
		log.info("getAllPersonalTrainingDetails() - start");
		List<PersonalTrainingDetailsResponse> responseList = new ArrayList<PersonalTrainingDetailsResponse>();
		Iterable<PersonalTrainingDetailView> dbContents = personalTrainingDetailViewRepository.findAll();
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
		boolean isExpiryDateBeforeFreezeStartDate = membershipDetails.getExpireDate().before(createFreezeRequest.getStartDate());

		if (isExpiryDateBeforeFreezeStartDate) {
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
