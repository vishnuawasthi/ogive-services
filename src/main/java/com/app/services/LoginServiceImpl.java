package com.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.constants.Authorities;
import com.app.dto.BusinessUnitDetailsResponse;
import com.app.dto.CountryDetailsResponse;
import com.app.dto.MembershipDetailsResponse;
import com.app.dto.PortalUserDetailsResponse;
import com.app.dto.ResetPasswordRequest;
import com.app.entities.MembershipDetails;
import com.app.entities.PortalUserDetails;
import com.app.exception.UserNotFoundException;
import com.app.repositories.BusinessUnitDetailsRepository;
import com.app.repositories.CountryDetailsRepository;
import com.app.repositories.MembershipDetailsRepository;
import com.app.repositories.MembershipTypeRepository;
import com.app.repositories.PersonalTrainingTypeRepository;
import com.app.repositories.PortalUserRepository;

@Service
public class LoginServiceImpl implements LoginService {

	private static final Logger log = Logger.getLogger(LoginServiceImpl.class);

	@Autowired
	private PortalUserRepository portalUserRepository;

	@Autowired
	private BusinessUnitDetailsRepository businessUnitDetailsRepository;

	@Autowired
	private MembershipTypeRepository membershipTypeRepository;

	@Autowired
	private PersonalTrainingTypeRepository personalTrainingTypeRepository;

	@Autowired
	private CountryDetailsRepository countryDetailsRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private MembershipDetailsRepository membershipDetailsRepository;

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public PortalUserDetailsResponse findUserByUsernameAndPassword(String username, String rawPassword) {
		log.info("findUserByUsernameAndPassword() - start");

		PortalUserDetails portalUserDetails = portalUserRepository.findByUsername(username);

		if (Objects.isNull(portalUserDetails)  || !passwordEncoder.matches(rawPassword, portalUserDetails.getPassword())) {
			throw new UserNotFoundException("Invalid username or password");
		}

		PortalUserDetailsResponse responseObj = new PortalUserDetailsResponse();
		BeanUtils.copyProperties(portalUserDetails, responseObj);
		responseObj.setPassword("");

		List<Authorities> authorities = new ArrayList<Authorities>();

		portalUserDetails.getAuthorities().forEach(auth -> {
			authorities.add(auth.getAuthority());
		});

		responseObj.setAuthorities(authorities);
		log.info("findUserByUsernameAndPassword() - end");
		return responseObj;
	}

	@Async
	@Override
	public CompletableFuture<List<CountryDetailsResponse>> loadCountryDetails() {
		log.info("loadCountryDetails() - start");
		List<Object[]> dbContents = countryDetailsRepository.findAllCountries();

		List<CountryDetailsResponse> countriesDetails = new ArrayList<CountryDetailsResponse>();
		
		for (Object[] row : dbContents) {
			CountryDetailsResponse entity = new CountryDetailsResponse();
			entity.setId((Long) row[0]);
			entity.setCountryName((String) row[1]);
			entity.setCountryCode((String) row[2]);
			entity.setNationality((String) row[3]);
			countriesDetails.add(entity);
		}
		log.info("loadCountryDetails() - end");
		return CompletableFuture.completedFuture(countriesDetails);
	}

	@Async
	@Override
	public CompletableFuture<List<BusinessUnitDetailsResponse>> loadAllBusinessUnits() {
		log.info("loadAllBusinessUnits() - start");
		List<BusinessUnitDetailsResponse> businessUnitsDetails = new ArrayList<BusinessUnitDetailsResponse>();
		List<Object[]> dbContents = businessUnitDetailsRepository.loadAllBusinessUnits();
		
		for (Object[] row : dbContents) {
			BusinessUnitDetailsResponse entity = new BusinessUnitDetailsResponse();
			entity.setId((Long) row[0]);
			//entity.setBusinessUnitCode((String) row[1]);
			entity.setBusinessUnitName((String) row[2]);
			businessUnitsDetails.add(entity);
		}
		log.info("loadAllBusinessUnits() - end");
		return CompletableFuture.completedFuture(businessUnitsDetails);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public void resetPassword(ResetPasswordRequest request) {
		log.info("resetPassword() - start");
		PortalUserDetails entity = portalUserRepository.findByUsername(request.getUsername());
		if (Objects.isNull(entity) || !passwordEncoder.matches(entity.getPassword(), entity.getPassword())) {
			throw new UserNotFoundException("Invalid username or password");
		}
		entity.setPassword(passwordEncoder.encode(request.getNewPassword()));
		portalUserRepository.save(entity);
		log.info("resetPassword() - end");
	}

	@Override
	public CompletableFuture<List<MembershipDetailsResponse>> loadMembershipDetailByMemberId(Long memberId) {
		log.info("loadMembershipDetailByMemberId() - start");
		List<MembershipDetailsResponse> membershipsList = new ArrayList<MembershipDetailsResponse>();

		List<MembershipDetails> dbContents = membershipDetailsRepository.loadMembershipDetailByMemberId(memberId);
		dbContents.stream().forEach(membership -> {
			MembershipDetailsResponse responseObject = new MembershipDetailsResponse();
			BeanUtils.copyProperties(membership, responseObject);
			membershipsList.add(responseObject);
		});
		log.info("loadMembershipDetailByMemberId() - start");
		return CompletableFuture.completedFuture(membershipsList);
	}
	
}
