package com.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.BusinessUnitDetailsResponse;
import com.app.dto.CountryDetailsResponse;
import com.app.dto.ErrorResponseEntity;
import com.app.dto.LoginRequest;
import com.app.dto.PortalUserDetailsResponse;
import com.app.dto.ResetPasswordRequest;
import com.app.services.LoginService;

@RestController
public class LoginController {

	private static final Logger log = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private LoginService loginService;

	@PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object doLogin(@RequestBody @Valid LoginRequest loginRequest) {
		log.info("doLogin ()- start");
		log.info("Request Body :  {} " + loginRequest);

		Map<String, Object> paramMap = new HashMap<String, Object>();
		Map<String, Object> masterData = new HashMap<String, Object>();

		PortalUserDetailsResponse portalUserResponse = loginService.findUserByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());
		
		paramMap.put("userProfile", portalUserResponse);

		CompletableFuture<List<CountryDetailsResponse>> countryDetails = loginService.loadCountryDetails();

		CompletableFuture<List<BusinessUnitDetailsResponse>> loadAllBusinessUnits = loginService.loadAllBusinessUnits();

		//List<Authorities> authorities = portalUserResponse.getAuthorities();
		
		/*paramMap.put("membershipDetails",Collections.EMPTY_LIST);
		CompletableFuture<List<MembershipDetailsResponse>> membershipList = null;
		
		if (authorities.contains(Authorities.MEMBER)) {
			Long memberId = null;
			
			try {
				memberId = Long.valueOf(loginRequest.getUsername());
			} catch (NumberFormatException e) {
				log.info("User is not a true member. Hence dont pull membership details...",e);
			}
			if (Objects.nonNull(memberId)) {
				membershipList = loginService.loadMembershipDetailByMemberId(memberId);
			}
		}*/

		CompletableFuture.allOf(countryDetails, loadAllBusinessUnits).join();

		try {
			masterData.put("countries", countryDetails.get());
			masterData.put("businessUnits", loadAllBusinessUnits.get());
			
			/*if(null != membershipList) {
				paramMap.put("membershipDetails",membershipList.get());
			}*/
			
		} catch (InterruptedException e) {
			log.error("Exception while loading master data  =>      {}    ", e);
		} catch (ExecutionException e) {
			log.error("Exception while loading master data  =>      {}    ", e);
		}

		paramMap.put("masterData", masterData);
		log.info("doLogin ()- end");
		return paramMap;
	}
	
	
	@PostMapping(value = "/reset-password", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object resetPassword(@RequestBody @Valid ResetPasswordRequest request) {
		log.info("resetPassword ()- start");
		log.info("Request Body :  {} " + request);
		loginService.resetPassword(request);
		log.info("resetPassword ()- end");
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping(value = "/users/accessDenied", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object accessDeniedHandler(@RequestParam("authentication") Authentication authentication) {
		ErrorResponseEntity errorEntity = new ErrorResponseEntity();
		if (Objects.nonNull(authentication)) {
			errorEntity.setDescription(authentication.getName() + " is not allowed to access the resource");
			errorEntity.setStatus("403- Access Denied");
		}
		return new ResponseEntity<ErrorResponseEntity>(errorEntity, HttpStatus.OK);
	}

}
