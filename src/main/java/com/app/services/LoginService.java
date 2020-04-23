package com.app.services;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.app.dto.BusinessUnitDetailsResponse;
import com.app.dto.CountryDetailsResponse;
import com.app.dto.PortalUserDetailsResponse;
import com.app.dto.ResetPasswordRequest;

public interface LoginService {

	PortalUserDetailsResponse findUserByUsernameAndPassword(String username, String password);

	CompletableFuture<List<CountryDetailsResponse>> loadCountryDetails();

	CompletableFuture<List<BusinessUnitDetailsResponse>> loadAllBusinessUnits();
	
	void resetPassword(ResetPasswordRequest request0);
	

}
