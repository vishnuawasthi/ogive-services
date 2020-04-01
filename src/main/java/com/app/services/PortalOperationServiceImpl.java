package com.app.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.app.dto.MemberDetailsResponse;
import com.app.dto.MemberRegistrationRequest;
import com.app.dto.PortalUserDetailsRequest;
import com.app.dto.PortalUserDetailsResponse;
import com.app.dto.UserAuthenticationDetails;
import com.app.entities.MembershipDetails;
import com.app.entities.PortalUserDetails;
import com.app.entities.UserAuthority;
import com.app.exception.RecordNotFoundException;
import com.app.repositories.MembershipDetailsRepository;
import com.app.repositories.PortalUserRepository;
import com.app.repositories.UserAuthoritiesRepository;

@Service
public class PortalOperationServiceImpl implements PortalOperationService {

	private static final Logger log = Logger.getLogger(PortalOperationServiceImpl.class);

	@Autowired
	private PortalUserRepository portalUserRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserAuthoritiesRepository authoritiesRepository;

	@Autowired
	private MembershipDetailsRepository membershipDetailsRepository;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public MemberRegistrationRequest getUserById(Long id) {
		MemberRegistrationRequest userDetailsDTO = null;
		PortalUserDetails portalUserDetails = portalUserRepository.findById(id).orElse(null);
		return userDetailsDTO;
	}

	private PortalUserDetails dtoToEntity(UserAuthenticationDetails userDetailsDTO) {
		PortalUserDetails portalUserDetails = new PortalUserDetails();
		portalUserDetails.setUsername(userDetailsDTO.getUsername());
		portalUserDetails.setPassword(userDetailsDTO.getPassword());
		portalUserDetails.setCreatedDate(new Date());
		portalUserDetails.setUpatedDate(new Date());
		return portalUserDetails;

	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public Long saveUserDetails(MemberRegistrationRequest userRegistrationDTO) {
		log.info("saveUserDetails() - start");
		// String encodedPassword =
		// passwordEncoder.encode(userRegistrationDTO.getPassword());
		// userRegistrationDTO.setPassword(encodedPassword);

		PortalUserDetails entity = dtoToEntity(userRegistrationDTO);
		portalUserRepository.save(entity);

		UserAuthority authority = new UserAuthority();
		authority.setPortalUserDetails(entity);
		// authority.setAuthority(userRegistrationDTO.getUserRoleType());
		authority.setDescription("This role assigned by application to all the api created user.");
		log.info("Saving authorities detaails   -> ," + authority);
		authoritiesRepository.save(authority);
		log.info("saveUserDetails() - stop");
		return entity.getId();
	}

	public PortalUserDetails dtoToEntity(MemberRegistrationRequest dto) {

		PortalUserDetails portalUserDetails = new PortalUserDetails();

		// portalUserDetails.setUsername(dto.getUsername());
		// portalUserDetails.setPassword(dto.getPassword());
		portalUserDetails.setEmail(dto.getEmail());
		portalUserDetails.setGender(dto.getGender());
		portalUserDetails.setIsAcccountLocked("N");
		// portalUserDetails.setContactNumber(dto.getContactNumber());
		// portalUserDetails.setAlternateContactNumber(dto.getAlternateContactNumber());
		// Set<UserAuthority> authorities = new HashSet<UserAuthority>();
		// portalUserDetails.setAuthorities(authorities);
		return portalUserDetails;
	}

	@Override
	public Long saveMembershipDetails(MemberRegistrationRequest memberRegistrationRequest) {
		log.info("saveMembershipDetails() - start");
		MembershipDetails entity = new MembershipDetails();
		BeanUtils.copyProperties(memberRegistrationRequest, entity);
		membershipDetailsRepository.save(entity);
		log.info("saveMembershipDetails() - end");
		return entity.getId();
	}

	@Override
	public List<MemberDetailsResponse> getAllMemberShips() {
		Iterable<MembershipDetails> entities = membershipDetailsRepository.findAll(Sort.by("id"));

		List<MemberDetailsResponse> responseList = new ArrayList<MemberDetailsResponse>();

		if (entities != null) {
			entities.forEach(entity -> {
				MemberDetailsResponse responseObj = new MemberDetailsResponse();
				BeanUtils.copyProperties(entity, responseObj);
				responseList.add(responseObj);
			});
		}
		return responseList;
	}

	@Override
	public Long savePortalUserDetails(PortalUserDetailsRequest request) {
		log.info("savePortalUserDetails() - start");
		PortalUserDetails entity = new PortalUserDetails();
		BeanUtils.copyProperties(request, entity);
		entity.setPassword(passwordEncoder.encode(entity.getPassword()));
		portalUserRepository.save(entity);
		log.info("savePortalUserDetails() - end");
		return entity.getId();
	}

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
				responseList.add(responseObj);
			});
		}
		log.info("getAllPortalUsers() - end");
		return responseList;
	}

	@Override
	public PortalUserDetailsResponse getPortalUserById(Long id) {
		log.info("getPortalUserById() - start");
		PortalUserDetails entity = portalUserRepository.findById(id).orElse(null);
		PortalUserDetailsResponse responseObj = null;

		if (Objects.nonNull(entity)) {
			responseObj = new PortalUserDetailsResponse();
			BeanUtils.copyProperties(entity, responseObj);
			responseObj.setPassword("");
		}
		log.info("getPortalUserById() - end");
		return responseObj;
	}

	@Override
	public PortalUserDetailsResponse updatePortalUserDetails(Long id, PortalUserDetailsRequest portalUserDetailsRequest)
			throws RecordNotFoundException {
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

		log.info("updatePortalUserDetails() - end");
		return null;
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
		portalUserRepository.save(entity);
		log.info("enableAcccount() - start");
	}

}
