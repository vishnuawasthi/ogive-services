package com.app.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.app.constants.Authorities;
import com.app.dto.CountryDetailsResponse;
import com.app.dto.CreateCountryDetailsRequest;
import com.app.dto.CreatePortalUserDetailsRequest;
import com.app.dto.CreateSourceDetailsRequest;
import com.app.dto.PortalUserDetailsResponse;
import com.app.dto.SourceDetailsResponse;
import com.app.entities.CountryDetails;
import com.app.entities.PortalUserDetails;
import com.app.entities.SourceDetails;
import com.app.entities.UserAuthority;
import com.app.exception.RecordNotFoundException;
import com.app.repositories.CountryDetailsRepository;
import com.app.repositories.MembershipDetailsRepository;
import com.app.repositories.PortalUserRepository;
import com.app.repositories.SourceDetailsRepository;
import com.app.repositories.UserAuthoritiesRepository;
import com.app.utils.CommonUtils;

@Service
public class PortalAdminOperationServiceImpl implements PortalAdminOperationService {

	private static final Logger log = Logger.getLogger(PortalAdminOperationServiceImpl.class);

	@Autowired
	private PortalUserRepository portalUserRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserAuthoritiesRepository authoritiesRepository;

	@Autowired
	private MembershipDetailsRepository membershipDetailsRepository;

	@Autowired
	private CountryDetailsRepository countryDetailsRepository;

	@Autowired
	private SourceDetailsRepository sourceDetailsRepository;

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public Long savePortalUserDetails(CreatePortalUserDetailsRequest request) {
		log.info("savePortalUserDetails() - start");
		PortalUserDetails entity = new PortalUserDetails();
		BeanUtils.copyProperties(request, entity);
		entity.setPassword(passwordEncoder.encode(entity.getPassword()));
		String username = CommonUtils.getCurrentUser();
		entity.setCreatedBy(username);
		entity.setUpdatedBy(username);
		
		Date date = new Date();
		
		entity.setCreatedDate(date);
		entity.setUpatedDate(date);
		portalUserRepository.save(entity);
		List<Authorities> authorities = request.getAuthorities();

		if (!CollectionUtils.isEmpty(authorities)) {

			List<UserAuthority> authoDetailsList = new ArrayList<UserAuthority>();

			authorities.forEach(auth -> {
				UserAuthority authEntity = new UserAuthority();
				authEntity.setAuthority(auth);
				authEntity.setPortalUserDetails(entity);
				authEntity.setDescription("Auth created for user id " + entity.getId());
				authoDetailsList.add(authEntity);
			});
			authoritiesRepository.saveAll(authoDetailsList);
		}
		log.info("savePortalUserDetails() - end");
		return entity.getId();
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public List<PortalUserDetailsResponse> getAllPortalUsers() {
		log.info("getAllPortalUsers() - start");
		Iterable<PortalUserDetails> entities = portalUserRepository.findAll(Sort.by("id"));
		List<PortalUserDetailsResponse> responseList = new ArrayList<PortalUserDetailsResponse>();
		if (entities != null) {
			entities.forEach(entity -> {
				PortalUserDetailsResponse responseObj = new PortalUserDetailsResponse();
				BeanUtils.copyProperties(entity, responseObj);
				responseObj.setPassword("");
				
				List<Authorities> authorities = new ArrayList<Authorities>();
				entity.getAuthorities().forEach(auth -> {
					authorities.add(auth.getAuthority());
				});
				responseObj.setAuthorities(authorities);
				responseList.add(responseObj);
			});
		}
		log.info("getAllPortalUsers() - end");
		return responseList;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public PortalUserDetailsResponse getPortalUserById(Long id) {
		log.info("getPortalUserById() - start");
		PortalUserDetails entity = portalUserRepository.findById(id).orElse(null);
		PortalUserDetailsResponse responseObj = null;

		if (Objects.nonNull(entity)) {
			responseObj = new PortalUserDetailsResponse();
			BeanUtils.copyProperties(entity, responseObj);
			responseObj.setPassword("");
			List<Authorities> authorities = new ArrayList<Authorities>();

			entity.getAuthorities().forEach(auth -> {
				authorities.add(auth.getAuthority());
			});
			responseObj.setAuthorities(authorities);
		}
		log.info("getPortalUserById() - end");
		return responseObj;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public PortalUserDetailsResponse updatePortalUserDetails(Long id,
			CreatePortalUserDetailsRequest portalUserDetailsRequest) throws RecordNotFoundException {
		log.info("updatePortalUserDetails() - start");

		PortalUserDetails entity = portalUserRepository.findById(id).orElse(null);

		if (Objects.isNull(entity)) {
			throw new RecordNotFoundException("No such record exist with given id " + id);
		}

		if (!StringUtils.isEmpty(portalUserDetailsRequest.getFirstname())) {
			entity.setFirstname(portalUserDetailsRequest.getFirstname());
		}

		if (!StringUtils.isEmpty(portalUserDetailsRequest.getLastname())) {
			entity.setLastname(portalUserDetailsRequest.getLastname());
		}

		if (!StringUtils.isEmpty(portalUserDetailsRequest.getContactNumber())) {
			entity.setContactNumber(portalUserDetailsRequest.getContactNumber());
		}

		if (!StringUtils.isEmpty(portalUserDetailsRequest.getEmail())) {
			entity.setEmail(portalUserDetailsRequest.getEmail());
		}

		/*
		 * List<Authorities> authoritiesFromUI =
		 * portalUserDetailsRequest.getAuthorities(); List<String> listOfAuthNames =
		 * authoritiesFromUI.stream().map(item ->{ return item.name();
		 * 
		 * }).collect(Collectors.toList());
		 * 
		 * if (!CollectionUtils.isEmpty(authoritiesFromUI)) {
		 * entity.getAuthorities().forEach(authority -> { if
		 * (!listOfAuthNames.contains(authority.getAuthority().name())) {
		 * authoritiesRepository.delete(authority); } }); }
		 */
		String updatedBy = CommonUtils.getCurrentUser();
		entity.setUpdatedBy(updatedBy);
		entity.setUpatedDate(new Date());
		portalUserRepository.save(entity);
		PortalUserDetailsResponse response = new PortalUserDetailsResponse();
		BeanUtils.copyProperties(entity, response);
		log.info("updatePortalUserDetails() - end");
		return response;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void suspendAcccount(Long id) throws RecordNotFoundException {
		log.info("suspendAcccount() - start");
		PortalUserDetails entity = portalUserRepository.findById(id).orElse(null);

		if (Objects.isNull(entity)) {
			throw new RecordNotFoundException("Record Not Found with id = " + id);
		}
		entity.setIsEnabled("N");
		String updatedBy = CommonUtils.getCurrentUser();
		entity.setUpdatedBy(updatedBy);
		entity.setUpatedDate(new Date());
		portalUserRepository.save(entity);
		log.info("suspendAcccount() - end");
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void enableAcccount(Long id) {
		log.info("enableAcccount() - start");
		PortalUserDetails entity = portalUserRepository.findById(id).orElse(null);

		if (Objects.isNull(entity)) {
			throw new RecordNotFoundException("Record Not Found with id = " + id);
		}
		entity.setIsEnabled("Y");
		String updatedBy = CommonUtils.getCurrentUser();
		entity.setUpdatedBy(updatedBy);
		entity.setUpatedDate(new Date());
		portalUserRepository.save(entity);
		log.info("enableAcccount() - end");
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void updateAuthorities(Long id, List<Authorities> authorities) {
		log.info("updateAuthorities() - start");
		PortalUserDetails entity = portalUserRepository.findById(id).orElse(null);

		if (Objects.isNull(entity)) {
			throw new RecordNotFoundException("Record Not Found with id = " + id);
		}

		List<UserAuthority> authoDetailsList = new ArrayList<UserAuthority>();
		authorities.forEach(auth -> {
			UserAuthority authEntity = new UserAuthority();
			authEntity.setAuthority(auth);
			authEntity.setPortalUserDetails(entity);
			authEntity.setDescription("Auth created for user id " + entity.getId());
			authoDetailsList.add(authEntity);
		});
		authoritiesRepository.saveAll(authoDetailsList);
		log.info("updateAuthorities() - end");
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void deleteAuthorities(Long id, List<Authorities> authorities) {
		log.info("deleteAuthorities() - start");

		PortalUserDetails entity = portalUserRepository.findById(id).orElse(null);

		if (Objects.isNull(entity)) {
			throw new RecordNotFoundException("Record Not Found with id = " + id);
		}

		List<String> authNamesToDelete = authorities.stream().map(auth -> {
			return auth.name();
		}).collect(Collectors.toList());

		entity.getAuthorities().stream().forEach(auth -> {
			if (authNamesToDelete.contains(auth.getAuthority().name())) {
				authoritiesRepository.delete(auth);
			}
		});
		log.info("deleteAuthorities() - end");

	}

	/** ################### COUNTRY DETAILS SERVICES ####################### */
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public Long addCountryDetails(CreateCountryDetailsRequest createCountryDetailsRequest) {
		log.info("addCountryDetails() - start");
		CountryDetails entity = new CountryDetails();
		BeanUtils.copyProperties(createCountryDetailsRequest, entity);
		countryDetailsRepository.save(entity);
		log.info("addCountryDetails() - end");
		return entity.getId();
	}

	@Override
	public List<CountryDetailsResponse> getAllCountryDetails() {
		log.info("getAllCountryDetails() - start");

		Iterable<CountryDetails> countriesDetails = countryDetailsRepository.findAll();
		List<CountryDetailsResponse> responseObjectList = new ArrayList<CountryDetailsResponse>();

		countriesDetails.forEach(country -> {
			CountryDetailsResponse respnseObject = new CountryDetailsResponse();
			BeanUtils.copyProperties(country, respnseObject);
			responseObjectList.add(respnseObject);
		});

		log.info("getAllCountryDetails() - end");
		return responseObjectList;
	}

	@Override
	public CountryDetailsResponse getCountryDetailsByCode(String code) {
		log.info("getCountryDetailsByCode() - start");

		CountryDetails entity = countryDetailsRepository.findCountryDetailsByCountryCodeIgnoreCase(code);
		CountryDetailsResponse responseObject = null;
		if (Objects.nonNull(entity)) {
			responseObject = new CountryDetailsResponse();
			BeanUtils.copyProperties(entity, responseObject);
		}
		log.info("getCountryDetailsByCode() - end");
		return responseObject;
	}

	@Override
	public CountryDetailsResponse getCountryDetailsById(Long id) {
		log.info("getCountryDetailsById() - start");
		CountryDetails entity = countryDetailsRepository.findById(id).orElse(null);

		CountryDetailsResponse responseObject = null;
		if (Objects.nonNull(entity)) {
			responseObject = new CountryDetailsResponse();
			BeanUtils.copyProperties(entity, responseObject);
		}
		log.info("getCountryDetailsById() - end");
		return responseObject;
	}

	/** ##################### SOURCE DETAILS ############################# */

	@Override
	public String createSourceDetails(CreateSourceDetailsRequest createSourceDetailsRequest) {
		log.info("createSourceDetails() - start");
		SourceDetails entity = new SourceDetails();
		BeanUtils.copyProperties(createSourceDetailsRequest, entity);
		sourceDetailsRepository.save(entity);
		log.info("createSourceDetails() - end");
		return entity.getId();
	}

	@Override
	public List<SourceDetailsResponse> getAllSourcesDetails() {
		log.info("getAllSourcesDetails() - start");
		Iterable<SourceDetails> dbContents = sourceDetailsRepository.findAll();
		List<SourceDetailsResponse> responseList = new ArrayList<>();

		dbContents.forEach(entity -> {
			SourceDetailsResponse responseObject = new SourceDetailsResponse();
			BeanUtils.copyProperties(entity, responseObject);
			responseList.add(responseObject);
		});
		
		log.info("getAllSourcesDetails() - end");
		return responseList;
	}

	@Override
	public void deleteSource(String id) {
		log.info("deleteSource() - start");
		sourceDetailsRepository.deleteById(id);
		log.info("deleteSource() - end");
	}

}
