package com.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.BusinessUnitDetailsResponse;
import com.app.dto.CountryDetailsResponse;
import com.app.dto.LoginRequest;
import com.app.dto.PortalUserDetailsResponse;
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

		PortalUserDetailsResponse portalUserResponse = loginService
				.findUserByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());

		paramMap.put("profile", portalUserResponse);

		CompletableFuture<List<CountryDetailsResponse>> countryDetails = loginService.loadCountryDetails();

		CompletableFuture<List<BusinessUnitDetailsResponse>> loadAllBusinessUnits = loginService.loadAllBusinessUnits();

		CompletableFuture.allOf(countryDetails, loadAllBusinessUnits).join();

		try {
			masterData.put("countries", countryDetails.get());
			masterData.put("businessUnits", loadAllBusinessUnits.get());
		} catch (InterruptedException e) {
			log.error("Exception while loading master data  =>      {}    ", e);
		} catch (ExecutionException e) {
			log.error("Exception while loading master data  =>      {}    ", e);
		}

		paramMap.put("masterData", masterData);
		log.info("doLogin ()- end");
		return paramMap;
	}

}
