package com.app.services;

import java.util.List;

import com.app.dto.CreateMembershipRequest;
import com.app.dto.CreateProspectDetailsRequest;
import com.app.dto.MembershipResponse;
import com.app.dto.ProspectDetailsResponse;

public interface PortalUserOperationService {
	
    /** #################  PROSPECT SERVICES ####################### */
	
	Long createProspectDetails(CreateProspectDetailsRequest createProspectDetailsRequest);

	ProspectDetailsResponse updateCreateProspectDetails(Long id,CreateProspectDetailsRequest createProspectDetailsRequest);
	
	List<ProspectDetailsResponse> getAllProspects();
	
	ProspectDetailsResponse getProspectById(Long id);
	
	/** #################  MEMBERSHIP  SERVICES ##################### */
	
	Long createMembership(CreateMembershipRequest createMembershipRequest);
	
	MembershipResponse getMembershipDetailsById(Long id);
	
	List<MembershipResponse> getAllMembershipDetails();
	
	

}
