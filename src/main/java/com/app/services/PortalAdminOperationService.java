package com.app.services;

import java.util.List;

import com.app.constants.Authorities;
import com.app.dto.CountryDetailsResponse;
import com.app.dto.CreateCountryDetailsRequest;
import com.app.dto.CreatePortalUserDetailsRequest;
import com.app.dto.CreateSourceDetailsRequest;
import com.app.dto.PortalUserDetailsResponse;
import com.app.dto.SourceDetailsResponse;
import com.app.exception.RecordNotFoundException;

public interface PortalAdminOperationService {

	Long savePortalUserDetails(CreatePortalUserDetailsRequest request);

	List<PortalUserDetailsResponse> getAllPortalUsers();

	PortalUserDetailsResponse getPortalUserById(Long id);

	PortalUserDetailsResponse updatePortalUserDetails(Long id, CreatePortalUserDetailsRequest portalUserDetailsRequest)
			throws RecordNotFoundException;

	void suspendAcccount(Long id);

	void enableAcccount(Long id);
	
	void updateAuthorities(Long id,List<Authorities> authorities);
	
	void deleteAuthorities(Long id,List<Authorities> authorities);
	
	/**################### COUNTRY SERVICES #######################*/
	
	Long addCountryDetails(CreateCountryDetailsRequest createCountryDetailsRequest );
	
	List<CountryDetailsResponse> getAllCountryDetails();
	
	CountryDetailsResponse getCountryDetailsByCode(String code);
	
	CountryDetailsResponse getCountryDetailsById(Long id);
	
	/*################# SOURCE DETAILS ############################ */ 
	
	String createSourceDetails(CreateSourceDetailsRequest createSourceDetailsRequest);
	
    List<SourceDetailsResponse > getAllSourcesDetails();
   
    void deleteSource(String id);
   
	
}
