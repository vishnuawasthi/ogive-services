package com.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.app.constants.ApplicationConstants;
import com.app.constants.MembershipTypeStatus;
import com.app.dto.BusinessUnitDetailsResponse;
import com.app.dto.CreateBusinessUnitDetailsRequest;
import com.app.dto.CreateMembershipTypeRequest;
import com.app.dto.CreatePackageDetailsRequest;
import com.app.dto.CreatePersonalTrainingTypeRequest;
import com.app.dto.CreateStaffDetailsRequest;
import com.app.dto.MembershipTypeResponse;
import com.app.dto.PackageDetailsResponse;
import com.app.dto.PackageSpecificationDetailsRequest;
import com.app.dto.PackageSpecificationDetailsResponse;
import com.app.dto.PersonalTrainingTypeResponse;
import com.app.dto.StaffDetailsResponse;
import com.app.dto.UpdateMembershipTypeRequest;
import com.app.entities.BusinessUnitDetails;
import com.app.entities.CountryDetails;
import com.app.entities.MembershipType;
import com.app.entities.PackageDetails;
import com.app.entities.PackageSpecificationDetails;
import com.app.entities.PersonalTrainingType;
import com.app.entities.StaffDetails;
import com.app.exception.RecordNotFoundException;
import com.app.repositories.BusinessUnitDetailsRepository;
import com.app.repositories.CountryDetailsRepository;
import com.app.repositories.MembershipPackageDetailsRepository;
import com.app.repositories.MembershipTypeRepository;
import com.app.repositories.PackageSpecificationDetailsRepository;
import com.app.repositories.PersonalTrainingTypeRepository;
import com.app.repositories.StaffDetailsRepository;

@Service
public class MembershipServiceImpl implements MembershipService {

	private static final Logger log = Logger.getLogger(MembershipServiceImpl.class);

	@Autowired
	private MembershipTypeRepository membershipTypeRepository;

	@Autowired
	private BusinessUnitDetailsRepository businessUnitDetailsRepository;

	@Autowired
	private PersonalTrainingTypeRepository personalTrainingTypeRepository;

	@Autowired
	private StaffDetailsRepository staffDetailsRepository;

	@Autowired
	private MembershipPackageDetailsRepository membershipPackageDetailsRepository;

	@Autowired
	private PackageSpecificationDetailsRepository packageSpecificationDetailsRepository;

	@Autowired
	private CountryDetailsRepository countryDetailsRepository;

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public Long createMembershipType(CreateMembershipTypeRequest createMembershipTypeRequest) {
		log.info("createMembershipType() - start");
		MembershipType entity = new MembershipType();

		BusinessUnitDetails businessUnitDetails = businessUnitDetailsRepository.findById(createMembershipTypeRequest.getCompanyOrBusinessUnit()).orElse(null);

		if (Objects.isNull(businessUnitDetails)) {
			throw new RecordNotFoundException("No BusinessUnitDetails record exist with given companyOrBusinessUnit "+ createMembershipTypeRequest.getCompanyOrBusinessUnit());
		}

		Long pkgNumber = createMembershipTypeRequest.getPackageNumber();
		
		PackageDetails membershipPackageDetails = membershipPackageDetailsRepository.findById(pkgNumber).orElse(null);

		if (Objects.isNull(membershipPackageDetails)) {
			throw new RecordNotFoundException("No MembershipPackageDetails record exist with given packageNumber " + pkgNumber);
		}

		BeanUtils.copyProperties(createMembershipTypeRequest, entity);
		log.info("entity -> " + entity);
		entity.setBusinessUnitDetails(businessUnitDetails);
		entity.setMembershipPackageDetails(membershipPackageDetails);
		membershipTypeRepository.save(entity);
		log.info("createMembershipType() - end");
		return entity.getId();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public MembershipTypeResponse updateMembershipType(Long id, UpdateMembershipTypeRequest request) {
		log.info("updateMembershipType() - start");
		
		MembershipType entity = membershipTypeRepository.findById(id).orElse(null);

		if (Objects.isNull(entity)) {
			throw new RecordNotFoundException("No such MembershipType record exist with given id " + id);
		}
		
		if (!StringUtils.isEmpty(request.getDescription())) {
			entity.setDescription(request.getDescription());
		}
		
		if (!StringUtils.isEmpty(request.getMembershipTypeName())) {
			entity.setMembershipTypeName(request.getMembershipTypeName());
		}

		if (Objects.nonNull(request.getDuration())) {
			entity.setDuration(request.getDuration());
		}

		if (Objects.nonNull(request.getJoiningFees())) {
			entity.setJoiningFees(request.getJoiningFees());
		}

		if (Objects.nonNull(request.getSubscriptionFees())) {
			entity.setSubscriptionFees(request.getSubscriptionFees());
		}

		if (Objects.nonNull(request.getMaximumHours())) {
			entity.setMaximumHours(request.getMaximumHours());
		}

		if (Objects.nonNull(request.getMinimuHours())) {
			entity.setMinimuHours(request.getMinimuHours());
		}

		if (Objects.nonNull(request.getAllowedDiscount())) {
			entity.setAllowedDiscount(request.getAllowedDiscount());
		}

		if (Objects.nonNull(request.getCompanyOrBusinessUnit())) {

			BusinessUnitDetails businessUnitDetails = businessUnitDetailsRepository
					.findById(request.getCompanyOrBusinessUnit()).orElse(null);

			if (Objects.isNull(businessUnitDetails)) {
				throw new RecordNotFoundException(
						"No BusinessUnitDetails record exist with given companyOrBusinessUnit "
								+ request.getCompanyOrBusinessUnit());
			}

			entity.setBusinessUnitDetails(businessUnitDetails);
		}
		MembershipTypeResponse responseObject = new MembershipTypeResponse();
		membershipTypeRepository.save(entity);
		BeanUtils.copyProperties(entity, responseObject);

		Long companyOrBusinessUnit = Objects.nonNull(entity.getBusinessUnitDetails())
				? entity.getBusinessUnitDetails().getId()
				: null;
				
		responseObject.setCompanyOrBusinessUnit(companyOrBusinessUnit);
		
		PackageDetails packageDetails = Objects.nonNull(entity.getMembershipPackageDetails())
				? entity.getMembershipPackageDetails()
				: null;

		if (Objects.nonNull(packageDetails)) {
			PackageDetailsResponse packageDetailsResponse = new PackageDetailsResponse();
			BeanUtils.copyProperties(packageDetails, packageDetailsResponse);

			Set<PackageSpecificationDetails> packageSpecificationDetails = packageDetails
					.getPackageSpecificationDetails();
			List<PackageSpecificationDetailsResponse> packageSpecificationResList = new ArrayList<PackageSpecificationDetailsResponse>();

			packageSpecificationDetails.forEach(specificationEntity -> {
				PackageSpecificationDetailsResponse specificationResObject = new PackageSpecificationDetailsResponse();
				BeanUtils.copyProperties(specificationEntity, specificationResObject);
				packageSpecificationResList.add(specificationResObject);
			});

			packageDetailsResponse.setPackageSpecificationDetails(packageSpecificationResList);
			responseObject.setPackageDetails(packageDetailsResponse);
		}
		
		responseObject.setCompanyOrBusinessUnit(companyOrBusinessUnit);
		
		log.info("updateMembershipType() - end");
		return responseObject;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateMembershipTypeStatus(Long id, MembershipTypeStatus status) {
		log.info("suspendMembershipType() - start");
		membershipTypeRepository.updateMembershipTypeStatus(id,status);
		log.info("suspendMembershipType() - end");
	}

	@Override
	public MembershipTypeResponse getMembershipTypeById(Long id) {
		log.info("getMembershipTypeById() - start");
		MembershipType entity = membershipTypeRepository.findById(id).orElse(null);
		MembershipTypeResponse responseObject = null;

		if (Objects.nonNull(entity)) {
			responseObject = new MembershipTypeResponse();
			BeanUtils.copyProperties(entity, responseObject);

			Long companyOrBusinessUnit = Objects.nonNull(entity.getBusinessUnitDetails())
					? entity.getBusinessUnitDetails().getId()
					: null;
			responseObject.setCompanyOrBusinessUnit(companyOrBusinessUnit);

			PackageDetails packageDetails = Objects.nonNull(entity.getMembershipPackageDetails())
					? entity.getMembershipPackageDetails()
					: null;

			if (Objects.nonNull(packageDetails)) {
				PackageDetailsResponse packageDetailsResponse = new PackageDetailsResponse();
				BeanUtils.copyProperties(packageDetails, packageDetailsResponse);

				Set<PackageSpecificationDetails> packageSpecificationDetails = packageDetails
						.getPackageSpecificationDetails();
				List<PackageSpecificationDetailsResponse> packageSpecificationResList = new ArrayList<PackageSpecificationDetailsResponse>();

				packageSpecificationDetails.forEach(specificationEntity -> {
					PackageSpecificationDetailsResponse specificationResObject = new PackageSpecificationDetailsResponse();
					BeanUtils.copyProperties(specificationEntity, specificationResObject);
					packageSpecificationResList.add(specificationResObject);
				});

				packageDetailsResponse.setPackageSpecificationDetails(packageSpecificationResList);
				responseObject.setPackageDetails(packageDetailsResponse);
			}
		}

		log.info("getMembershipTypeById() - start");
		return responseObject;
	}

	@Override
	public Page<MembershipTypeResponse> getAllMembershipTypes(String membershipTypeCode, Pageable pageRequest) {
		log.info("getMembershipTypeById() - start");

		// Page<MembershipTypes> pagedMembershipData =
		// membershipTypeRepository.findByMembershipTypeCodeAllIgnoreCase(membershipTypeCode,
		// pageRequest);

		Page<MembershipType> pagedMembershipData = membershipTypeRepository.findAll(pageRequest);

		Page<MembershipTypeResponse> dtoPage = pagedMembershipData.map(entity -> {
			MembershipTypeResponse responseObject = new MembershipTypeResponse();
			BeanUtils.copyProperties(entity, responseObject);

			Long companyOrBusinessUnit = Objects.nonNull(entity.getBusinessUnitDetails())
					? entity.getBusinessUnitDetails().getId()
					: null;
			responseObject.setCompanyOrBusinessUnit(companyOrBusinessUnit);

			PackageDetails packageDetails = Objects.nonNull(entity.getMembershipPackageDetails())
					? entity.getMembershipPackageDetails()
					: null;

			PackageDetailsResponse packageDetailsResponse = new PackageDetailsResponse();
			BeanUtils.copyProperties(packageDetails, packageDetailsResponse);

			Set<PackageSpecificationDetails> packageSpecificationDetails = packageDetails.getPackageSpecificationDetails();
			List<PackageSpecificationDetailsResponse> packageSpecificationResList = new ArrayList<PackageSpecificationDetailsResponse>();

			packageSpecificationDetails.forEach(specificationEntity -> {
				PackageSpecificationDetailsResponse specificationResObject = new PackageSpecificationDetailsResponse();
				BeanUtils.copyProperties(specificationEntity, specificationResObject);
				packageSpecificationResList.add(specificationResObject);
			});
			
			packageDetailsResponse.setPackageSpecificationDetails(packageSpecificationResList);
			responseObject.setPackageDetails(packageDetailsResponse);
			//responseObject.setPackageNumber(packageNumber);
			return responseObject;
		});

		log.info("getAllMembershipTypes() - end");
		return dtoPage;
	}

	@Override
	public Page<MembershipTypeResponse> getAllMembershipTypesAsPageable(Pageable pageRequest) {
		log.info("getAllMembershipTypesAsPagable() - start");
		Page<MembershipType> pageableMembershipDetails = membershipTypeRepository.findAll(pageRequest);

		Page<MembershipTypeResponse> pageableMembershipResponses = pageableMembershipDetails.map(entity -> {
			MembershipTypeResponse responseObject = new MembershipTypeResponse();
			BeanUtils.copyProperties(entity, responseObject);

			Long companyOrBusinessUnit = Objects.nonNull(entity.getBusinessUnitDetails())
					? entity.getBusinessUnitDetails().getId()
					: null;
			responseObject.setCompanyOrBusinessUnit(companyOrBusinessUnit);

			PackageDetails packageDetails = Objects.nonNull(entity.getMembershipPackageDetails())
					? entity.getMembershipPackageDetails()
					: null;

			if (Objects.nonNull(packageDetails)) {
				PackageDetailsResponse packageDetailsResponse = new PackageDetailsResponse();
				BeanUtils.copyProperties(packageDetails, packageDetailsResponse);

				Set<PackageSpecificationDetails> packageSpecificationDetails = packageDetails
						.getPackageSpecificationDetails();
				List<PackageSpecificationDetailsResponse> packageSpecificationResList = new ArrayList<PackageSpecificationDetailsResponse>();

				packageSpecificationDetails.forEach(specificationEntity -> {
					PackageSpecificationDetailsResponse specificationResObject = new PackageSpecificationDetailsResponse();
					BeanUtils.copyProperties(specificationEntity, specificationResObject);
					packageSpecificationResList.add(specificationResObject);
				});

				packageDetailsResponse.setPackageSpecificationDetails(packageSpecificationResList);
				responseObject.setPackageDetails(packageDetailsResponse);
			}
			return responseObject;
		});

		log.info("getAllMembershipTypesAsPagable() - end");
		return pageableMembershipResponses;
	}

	@Override
	public List<BusinessUnitDetailsResponse> getAllCompanyOrBusinessUnits() {
		log.info("getAllCompanyOrBusinessUnits() - start");
		Iterable<BusinessUnitDetails> businessUnitDetails = businessUnitDetailsRepository.findAll();

		List<BusinessUnitDetailsResponse> responseList = new ArrayList<BusinessUnitDetailsResponse>();
		businessUnitDetails.forEach(entity -> {
			BusinessUnitDetailsResponse responseObject = new BusinessUnitDetailsResponse();
			BeanUtils.copyProperties(entity, responseObject);

			String countryName = Objects.nonNull(entity.getCountryDetails())
					? entity.getCountryDetails().getCountryName()
					: null;
			responseObject.setCountryName(countryName);
			responseList.add(responseObject);

		});
		log.info("getAllCompanyOrBusinessUnits() - end");
		return responseList;
	}

	@Override
	public BusinessUnitDetailsResponse getBusinessUnitDetailsById(Long id) {
		log.info("getAllCompanyOrBusinessUnits() - start");
		BusinessUnitDetails entity = businessUnitDetailsRepository.findById(id).orElse(null);
		BusinessUnitDetailsResponse responseObject = null;

		if (Objects.nonNull(entity)) {
			responseObject = new BusinessUnitDetailsResponse();
			BeanUtils.copyProperties(entity, responseObject);
			String countryName = Objects.nonNull(entity.getCountryDetails())
					? entity.getCountryDetails().getCountryName()
					: null;
			responseObject.setCountryName(countryName);
		}
		log.info("getAllCompanyOrBusinessUnits() - start");
		return responseObject;
	}

	@Override
	public Long createCompanyOrBusinessUnit(CreateBusinessUnitDetailsRequest createBusinessUnitDetailsRequest) {
		log.info("createCompanyOrBusinessUnit() - start");
		BusinessUnitDetails entity = new BusinessUnitDetails();

		BeanUtils.copyProperties(createBusinessUnitDetailsRequest, entity);
		CountryDetails countryDetails = countryDetailsRepository
				.findCountryDetailsByCountryCodeIgnoreCase(createBusinessUnitDetailsRequest.getCountryCode());

		if (Objects.isNull(countryDetails)) {
			throw new RecordNotFoundException("No CountryDetails record exist with given countryCode "
					+ createBusinessUnitDetailsRequest.getCountryCode());
		}
		entity.setCountryDetails(countryDetails);
		businessUnitDetailsRepository.save(entity);
		log.info("createCompanyOrBusinessUnit() - end");
		return entity.getId();
	}
	
	
	@Override
	public BusinessUnitDetailsResponse updateCompanyOrBusinessUnit(Long id,CreateBusinessUnitDetailsRequest request) {
		log.info("updateCompanyOrBusinessUnit() - start");
		BusinessUnitDetails entity = businessUnitDetailsRepository.findById(id).orElse(null);

		if (Objects.isNull(entity)) {
			throw new RecordNotFoundException("No BusinessUnitDetails record exist with given id " + id);
		}
		
		BeanUtils.copyProperties(request, entity);
		log.info("updateCompanyOrBusinessUnit() - start");
		
		
		CountryDetails countryDetails = countryDetailsRepository.findCountryDetailsByCountryCodeIgnoreCase(request.getCountryCode());
		if (Objects.isNull(countryDetails)) {
			throw new RecordNotFoundException("No CountryDetails record exist with given countryCode " + request.getCountryCode());
		}
		entity.setCountryDetails(countryDetails);
		businessUnitDetailsRepository.save(entity);
		BusinessUnitDetailsResponse responseObject = new BusinessUnitDetailsResponse();
		BeanUtils.copyProperties(entity, responseObject);
		return responseObject;
	}

	/** ########################## PERSONAL TRAINING TYPE ####################### */

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public Long createPersonalTrainingType(CreatePersonalTrainingTypeRequest request) {
		log.info("createPersonalTrainingType() - start");
		PersonalTrainingType entity = new PersonalTrainingType();
		
		BusinessUnitDetails businessUnitDetails = businessUnitDetailsRepository.findById(request.getCompanyOrBusinessUnit()).orElse(null);
		
		if (Objects.isNull(businessUnitDetails)) {
			throw new RecordNotFoundException("No BusinessUnitDetails record exist with given id " + request.getCompanyOrBusinessUnit());
		}
		
		BeanUtils.copyProperties(request, entity);
		
		entity.setBusinessUnitDetails(businessUnitDetails);
		
		personalTrainingTypeRepository.save(entity);
		log.info("createPersonalTrainingType() - start");
		return entity.getId();
	}

	// TODO - Update logic implementation pending.
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public PersonalTrainingTypeResponse updatePersonalTrainingType(Long id, CreatePersonalTrainingTypeRequest request) {
		log.info("updatePersonalTrainingType() - start");
		PersonalTrainingType entity = personalTrainingTypeRepository.findById(id).orElse(null);

		if (Objects.isNull(entity)) {
			throw new RecordNotFoundException("No such PersonalTrainingType exist with given id " + id);
		}

		if (Objects.nonNull(request.getDuration())) {
			entity.setDuration(request.getDuration());
		}

		if (Objects.nonNull(request.getExtraSessions())) {
			entity.setExtraSessions(request.getExtraSessions());
		}

		if (Objects.nonNull(request.getAllowableDiscount())) {
			entity.setAllowableDiscount(request.getAllowableDiscount());
		}
		
		if (Objects.nonNull(request.getAllowedSessions())) {
			entity.setAllowedSessions(request.getAllowedSessions());
		}

		if (Objects.nonNull(request.getValidityInDays())) {
			entity.setValidityInDays(request.getValidityInDays());
		}

		if (Objects.nonNull(request.getEffectiveDate())) {
			entity.setEffectiveDate(request.getEffectiveDate());
		}

		if (Objects.nonNull(request.getJoiningFees())) {
			entity.setJoiningFees(request.getJoiningFees());
		}

		if (Objects.nonNull(request.getSubscriptionFees())) {
			request.setSubscriptionFees(request.getSubscriptionFees());
		}
		
		personalTrainingTypeRepository.save(entity);
		PersonalTrainingTypeResponse responseObject = new PersonalTrainingTypeResponse();
		BeanUtils.copyProperties(entity, responseObject);
		
		Long companyOrBusinessUnit =Objects.nonNull(entity.getBusinessUnitDetails())? entity.getBusinessUnitDetails().getId():null;
		responseObject.setCompanyOrBusinessUnit(companyOrBusinessUnit);
		log.info("updatePersonalTrainingType() - start");
		return responseObject;
	}

	@Override
	public PersonalTrainingTypeResponse getPersonalTrainingTypeById(Long id) {
		log.info("getPersonalTrainingTypeById() - start");
		PersonalTrainingType entity = personalTrainingTypeRepository.findById(id).orElse(null);
		PersonalTrainingTypeResponse responseObject = null;
		if (Objects.nonNull(entity)) {
			responseObject = new PersonalTrainingTypeResponse();
			BeanUtils.copyProperties(entity, responseObject);
		}
		Long companyOrBusinessUnit =Objects.nonNull(entity.getBusinessUnitDetails())? entity.getBusinessUnitDetails().getId():null;
		responseObject.setCompanyOrBusinessUnit(companyOrBusinessUnit);
		log.info("getPersonalTrainingTypeById() - start");
		return responseObject;
	}

	@Override
	public List<PersonalTrainingTypeResponse> getAllPersonalTrainingType() {
		log.info("getAllPersonalTrainingType() - start");
		Iterable<PersonalTrainingType> personalTrainingTypeList = personalTrainingTypeRepository.findAll();
		List<PersonalTrainingTypeResponse> responseList = new ArrayList<PersonalTrainingTypeResponse>();
		personalTrainingTypeList.forEach(entity -> {
			PersonalTrainingTypeResponse responseObject = new PersonalTrainingTypeResponse();
			BeanUtils.copyProperties(entity, responseObject);
			Long companyOrBusinessUnit =Objects.nonNull(entity.getBusinessUnitDetails())? entity.getBusinessUnitDetails().getId():null;
			responseObject.setCompanyOrBusinessUnit(companyOrBusinessUnit);
			responseList.add(responseObject);
		});
		log.info("getAllPersonalTrainingType() - end");
		return responseList;
	}

	/** ########################## STAFF DETAILS SERVICES ####################### */

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public Long createStaffDetails(CreateStaffDetailsRequest request) {
		log.info("createStaffDetails() - start");

		BusinessUnitDetails businessUnitDetails = businessUnitDetailsRepository.findById(request.getCompanyOrBusinessUnit()).orElse(null);

		if (Objects.isNull(businessUnitDetails)) {
			throw new RecordNotFoundException("No BusinessUnitDetails record exist with given id " + request.getCompanyOrBusinessUnit());
		}

		StaffDetails entity = new StaffDetails();
		BeanUtils.copyProperties(request, entity);
		entity.setBusinessUnitDetails(businessUnitDetails);
		
		staffDetailsRepository.save(entity);
		log.info("createStaffDetails() - end");
		return entity.getId();
	}

	// TODO- Update logic implementation pending.
	@Override
	public StaffDetailsResponse updateStaffDetails(Long id, CreateStaffDetailsRequest request) {
		log.info("updateStaffDetails() - start");

		StaffDetails entity = staffDetailsRepository.findById(id).orElse(null);

		if (Objects.isNull(entity)) {
			throw new RecordNotFoundException("No such StaffDetails exist with given id " + id);
		}
		BeanUtils.copyProperties(request, entity);
		
		if (Objects.nonNull(request.getCompanyOrBusinessUnit())) {
			BusinessUnitDetails businessUnitDetails = businessUnitDetailsRepository.findById(request.getCompanyOrBusinessUnit()).orElse(null);

			if (Objects.isNull(businessUnitDetails)) {
				throw new RecordNotFoundException(
						"No BusinessUnitDetails record exist with given id " + request.getCompanyOrBusinessUnit());
			}
			
			entity.setBusinessUnitDetails(businessUnitDetails);
		}

		staffDetailsRepository.save(entity);
		StaffDetailsResponse responseObject = new StaffDetailsResponse();
		BeanUtils.copyProperties(entity, responseObject);
		Long companyOrBusinessUnit  = Objects.nonNull(entity.getBusinessUnitDetails()) ? entity.getBusinessUnitDetails().getId():null;
		responseObject.setCompanyOrBusinessUnit(companyOrBusinessUnit);
		
		log.info("updateStaffDetails() - end");
		return responseObject;
	}

	@Override
	public StaffDetailsResponse getStaffDetailsById(Long id) {
		log.info("getStaffDetailsById() - start");
		StaffDetails entity = staffDetailsRepository.findById(id).orElse(null);
		StaffDetailsResponse responseObject = null;
		if (Objects.nonNull(entity)) {
			responseObject = new StaffDetailsResponse();
			BeanUtils.copyProperties(entity, responseObject);
			Long companyOrBusinessUnit  = Objects.nonNull(entity.getBusinessUnitDetails()) ? entity.getBusinessUnitDetails().getId():null;
			responseObject.setCompanyOrBusinessUnit(companyOrBusinessUnit);
		}
		log.info("getStaffDetailsById() - end");
		return responseObject;
	}

	@Override
	public List<StaffDetailsResponse> getAllStaffDetails() {
		log.info("getAllStaffDetails() - start");
		List<StaffDetailsResponse> responseObjectList = new ArrayList<StaffDetailsResponse>();
		Iterable<StaffDetails> dbContents = staffDetailsRepository.findAll();

		dbContents.forEach(entity -> {
			StaffDetailsResponse responseObject = new StaffDetailsResponse();
			BeanUtils.copyProperties(entity, responseObject);
			Long companyOrBusinessUnit  = Objects.nonNull(entity.getBusinessUnitDetails()) ? entity.getBusinessUnitDetails().getId():null;
			responseObject.setCompanyOrBusinessUnit(companyOrBusinessUnit);
			responseObjectList.add(responseObject);
		});

		log.info("getAllStaffDetails() - end");
		return responseObjectList;
	}

	/** ###################### MEMBERSHIP PKG DTLS ############################ */

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public Long createMembershipPackageDetails(CreatePackageDetailsRequest createMembershipPackageDetailsRequest) {
		log.info("createMembershipPackageDetails() - start");

		PackageDetails entity = new PackageDetails();
		BeanUtils.copyProperties(createMembershipPackageDetailsRequest, entity);
		
		Long businessUnit = createMembershipPackageDetailsRequest.getCompanyOrBusinessUnit();
		
		BusinessUnitDetails businessUnitDetails  = businessUnitDetailsRepository.findById(businessUnit).orElse(null);

		if (Objects.isNull(businessUnitDetails)) {
			throw new RecordNotFoundException("No BusinessUnitDetails record exist with given id " + businessUnit);
		}
		
		entity.setBusinessUnitDetails(businessUnitDetails);
		membershipPackageDetailsRepository.save(entity);

		log.info("Saving PackageSpecificationDetails ... ");
		List<PackageSpecificationDetailsRequest> packageSpecificationDetails = createMembershipPackageDetailsRequest
				.getPackageSpecificationDetails();

		if (!CollectionUtils.isEmpty(packageSpecificationDetails)) {
			List<PackageSpecificationDetails> pkgSpecDetailsList = new ArrayList<PackageSpecificationDetails>();
			packageSpecificationDetails.forEach(specificationObj -> {

				PackageSpecificationDetails pkgSpecDtlsEntity = new PackageSpecificationDetails();
				BeanUtils.copyProperties(specificationObj, pkgSpecDtlsEntity);
				pkgSpecDtlsEntity.setMembershipPackageDetails(entity);
				pkgSpecDetailsList.add(pkgSpecDtlsEntity);
			});
			packageSpecificationDetailsRepository.saveAll(pkgSpecDetailsList);
			log.info("PackageSpecificationDetails  saved successfully. ");
		}
		log.info("createMembershipPackageDetails() - start");
		return entity.getId();
	}

	@Override
	public PackageDetailsResponse getMembershipPackageDetailsById(Long id) {
		log.info("createMembershipPackageDetails() - start");
		PackageDetails entity = membershipPackageDetailsRepository.findById(id).orElse(null);

		if (null == entity) {
			return null;
		}
		PackageDetailsResponse responseObject = new PackageDetailsResponse();
		BeanUtils.copyProperties(entity, responseObject);
		
		Long companyOrBusinessUnit = Objects.nonNull(entity.getBusinessUnitDetails()) ? entity.getBusinessUnitDetails().getId():null;
		responseObject.setCompanyOrBusinessUnit(companyOrBusinessUnit);
		List<PackageSpecificationDetailsResponse> packageSpecificationDetails = new ArrayList<PackageSpecificationDetailsResponse>();
		
		entity.getPackageSpecificationDetails().forEach(pkgSpecDtls -> {
			PackageSpecificationDetailsResponse specDetailsResponse = new PackageSpecificationDetailsResponse();
			BeanUtils.copyProperties(pkgSpecDtls, specDetailsResponse);
			packageSpecificationDetails.add(specDetailsResponse);
		});
		
		responseObject.setPackageSpecificationDetails(packageSpecificationDetails);
		log.info("getMembershipPackageDetailsById() - end");
		return responseObject;
	}

	@Override
	public List<PackageDetailsResponse> getAllPackageDetails() {
		log.info("getAllPackageDetails() - start");

		Iterable<PackageDetails> listOfPackages = membershipPackageDetailsRepository.findAll();

		List<PackageDetailsResponse> pkgResponseList = new ArrayList<PackageDetailsResponse>();

		listOfPackages.forEach(entity -> {

			PackageDetailsResponse responseObject = new PackageDetailsResponse();
			BeanUtils.copyProperties(entity, responseObject);

			Long companyOrBusinessUnit = Objects.nonNull(entity.getBusinessUnitDetails())
					? entity.getBusinessUnitDetails().getId()
					: null;

			responseObject.setCompanyOrBusinessUnit(companyOrBusinessUnit);
			List<PackageSpecificationDetailsResponse> packageSpecificationDetails = new ArrayList<PackageSpecificationDetailsResponse>();

			entity.getPackageSpecificationDetails().forEach(pkgSpecDtls -> {
				PackageSpecificationDetailsResponse specDetailsResponse = new PackageSpecificationDetailsResponse();
				BeanUtils.copyProperties(pkgSpecDtls, specDetailsResponse);
				packageSpecificationDetails.add(specDetailsResponse);
			});

			responseObject.setPackageSpecificationDetails(packageSpecificationDetails);
			pkgResponseList.add(responseObject);

		});

		log.info("getAllPackageDetails() - end");
		return pkgResponseList;
	}

	
	
	

}
