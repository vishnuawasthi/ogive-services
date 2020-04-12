package com.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.app.dto.BusinessUnitDetailsResponse;
import com.app.dto.CreateMembershipPackageDetailsRequest;
import com.app.dto.CreateMembershipTypeRequest;
import com.app.dto.CreatePersonalTrainingTypeRequest;
import com.app.dto.CreateStaffDetailsRequest;
import com.app.dto.MembershipPackageDetailsResponse;
import com.app.dto.MembershipTypeResponse;
import com.app.dto.PackageSpecificationDetailsRequest;
import com.app.dto.PackageSpecificationDetailsResponse;
import com.app.dto.PersonalTrainingTypeResponse;
import com.app.dto.StaffDetailsResponse;
import com.app.entities.BusinessUnitDetails;
import com.app.entities.MembershipPackageDetails;
import com.app.entities.MembershipTypes;
import com.app.entities.PackageSpecificationDetails;
import com.app.entities.PersonalTrainingType;
import com.app.entities.StaffDetails;
import com.app.exception.RecordNotFoundException;
import com.app.repositories.BusinessUnitDetailsRepository;
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

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public Long createMembershipType(CreateMembershipTypeRequest createMembershipTypeRequest) {
		log.info("createMembershipType() - start");
		MembershipTypes entity = new MembershipTypes();
		BeanUtils.copyProperties(createMembershipTypeRequest, entity);
		log.info("entity -> " + entity);
		System.out.println("entity ->" + entity);
		membershipTypeRepository.save(entity);
		log.info("createMembershipType() - end");
		return entity.getId();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public MembershipTypeResponse updateMembershipType(Long id,
			CreateMembershipTypeRequest createMembershipTypeRequest) {
		log.info("updateMembershipType() - start");
		MembershipTypes entity = membershipTypeRepository.findById(id).orElse(null);
		if (Objects.isNull(entity)) {
			throw new RecordNotFoundException("No such record exist with given id " + id);
		}
		log.info("updateMembershipType() - end");
		return null;
	}

	@Override
	public MembershipTypeResponse getMembershipTypeById(Long id) {
		log.info("getMembershipTypeById() - start");
		MembershipTypes entity = membershipTypeRepository.findById(id).orElse(null);
		MembershipTypeResponse responseObject = null;

		if (Objects.nonNull(entity)) {
			responseObject = new MembershipTypeResponse();
			BeanUtils.copyProperties(entity, responseObject);
		}
		log.info("getMembershipTypeById() - start");
		return responseObject;
	}

	@Override
	public Page<MembershipTypeResponse> getAllMembershipTypes(String membershipTypeCode, Pageable pageRequest) {
		log.info("getMembershipTypeById() - start");

		Page<MembershipTypes> pagedMembershipData = membershipTypeRepository.findByMembershipTypeCodeAllIgnoreCase(membershipTypeCode, pageRequest);

		Page<MembershipTypeResponse> dtoPage = pagedMembershipData.map(entity -> {
			MembershipTypeResponse responseObject = new MembershipTypeResponse();
			BeanUtils.copyProperties(entity, responseObject);
			return responseObject;
		});

		log.info("getAllMembershipTypes() - end");
		return dtoPage;
	}

	@Override
	public Page<MembershipTypeResponse> getAllMembershipTypesAsPageable(Pageable pageRequest) {
		log.info("getAllMembershipTypesAsPagable() - start");
		Page<MembershipTypes> pageableMembershipDetails = membershipTypeRepository.findAll(pageRequest);

		Page<MembershipTypeResponse> pageableMembershipResponses = pageableMembershipDetails.map(entity -> {
			MembershipTypeResponse responseObject = new MembershipTypeResponse();
			BeanUtils.copyProperties(entity, responseObject);
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
		}

		log.info("getAllCompanyOrBusinessUnits() - start");
		return responseObject;
	}

	/** ########################## PERSONAL TRAINING TYPE ####################### */

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public Long createPersonalTrainingType(CreatePersonalTrainingTypeRequest createPersonalTrainingTypeRequest) {
		log.info("createPersonalTrainingType() - start");
		PersonalTrainingType entity = new PersonalTrainingType();
		BeanUtils.copyProperties(createPersonalTrainingTypeRequest, entity);
		personalTrainingTypeRepository.save(entity);
		log.info("createPersonalTrainingType() - start");
		return entity.getId();
	}

	// TODO - Update logic implementation pending.
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public PersonalTrainingTypeResponse updatePersonalTrainingType(Long id,
			CreatePersonalTrainingTypeRequest createPersonalTrainingTypeRequest) {
		log.info("updatePersonalTrainingType() - start");
		PersonalTrainingType entity = personalTrainingTypeRepository.findById(id).orElse(null);

		if (Objects.isNull(entity)) {
			throw new RecordNotFoundException("No such record exist with given id " + id);
		}
		// personalTrainingTypeRepository.save(entity);

		PersonalTrainingTypeResponse responseObject = new PersonalTrainingTypeResponse();
		BeanUtils.copyProperties(entity, responseObject);
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
			responseList.add(responseObject);
		});
		log.info("getAllPersonalTrainingType() - end");
		return responseList;
	}

	/** ########################## STAFF DETAILS SERVICES ####################### */

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public Long createStaffDetails(CreateStaffDetailsRequest createStaffDetailsRequest) {
		log.info("createStaffDetails() - start");
		StaffDetails entity = new StaffDetails();
		BeanUtils.copyProperties(createStaffDetailsRequest, entity);
		staffDetailsRepository.save(entity);
		log.info("createStaffDetails() - end");
		return entity.getId();
	}

	// TODO- Update logic implementation pending.
	@Override
	public StaffDetailsResponse updateStaffDetails(Long id, CreateStaffDetailsRequest createStaffDetailsRequest) {
		log.info("updateStaffDetails() - start");

		log.info("updateStaffDetails() - end");
		return null;
	}

	@Override
	public StaffDetailsResponse getStaffDetailsById(Long id) {
		log.info("getStaffDetailsById() - start");
		StaffDetails entity = staffDetailsRepository.findById(id).orElse(null);
		StaffDetailsResponse responseObject = null;
		if (Objects.nonNull(entity)) {
			responseObject = new StaffDetailsResponse();
			BeanUtils.copyProperties(entity, responseObject);
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
			responseObjectList.add(responseObject);
		});

		log.info("getAllStaffDetails() - end");
		return responseObjectList;
	}

	/** ###################### MEMBERSHIP PKG DTLS ############################ */

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public Long createMembershipPackageDetails(CreateMembershipPackageDetailsRequest createMembershipPackageDetailsRequest) {
		log.info("createMembershipPackageDetails() - start");
		
		MembershipPackageDetails entity = new MembershipPackageDetails();
		BeanUtils.copyProperties(createMembershipPackageDetailsRequest, entity);
		membershipPackageDetailsRepository.save(entity);

		log.info("Saving PackageSpecificationDetails ... ");
		List<PackageSpecificationDetailsRequest> packageSpecificationDetails = createMembershipPackageDetailsRequest.getPackageSpecificationDetails();
		
		if(!CollectionUtils.isEmpty(packageSpecificationDetails)) {
			List<PackageSpecificationDetails>  pkgSpecDetailsList = new ArrayList<PackageSpecificationDetails>();
			packageSpecificationDetails.forEach(specificationObj->{
				
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
	public MembershipPackageDetailsResponse getMembershipPackageDetailsById(Long id) {
		log.info("createMembershipPackageDetails() - start");

		MembershipPackageDetails entity = membershipPackageDetailsRepository.findById(id).orElse(null);

		if (null == entity) {
			return null;
		}
		MembershipPackageDetailsResponse responseObject = new MembershipPackageDetailsResponse();
		BeanUtils.copyProperties(entity, responseObject);
		List<PackageSpecificationDetailsResponse> packageSpecificationDetails = new ArrayList<PackageSpecificationDetailsResponse>();
		entity.getPackageSpecificationDetails().forEach(pkgSpecDtls -> {
			
			PackageSpecificationDetailsResponse specDetailsResponse = new PackageSpecificationDetailsResponse();
			BeanUtils.copyProperties(pkgSpecDtls, specDetailsResponse);
			packageSpecificationDetails.add(specDetailsResponse);

		});
		responseObject.setPackageSpecificationDetails(packageSpecificationDetails);
		log.info("getMembershipPackageDetailsById() - start");
		return responseObject;
	}

}
