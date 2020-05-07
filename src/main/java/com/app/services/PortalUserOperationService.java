package com.app.services;

import java.util.List;

import com.app.dto.CreateFreezeRequest;
import com.app.dto.CreateMemberTransferRequest;
import com.app.dto.CreateMembershipRequest;
import com.app.dto.CreatePersonalTrainingDetailRequest;
import com.app.dto.CreateProspectDetailsRequest;
import com.app.dto.GetMembershipDetail;
import com.app.dto.MembershipResponse;
import com.app.dto.PersonalTrainingDetailsResponse;
import com.app.dto.ProspectDetailsResponse;
import com.app.filter.criteria.MemberSearchCriteria;
import com.app.filter.criteria.MembershipFilterCriteria;

public interface PortalUserOperationService {
	
    /** #################  PROSPECT SERVICES ####################### */
	
	Long createProspectDetails(CreateProspectDetailsRequest createProspectDetailsRequest);

	ProspectDetailsResponse updateCreateProspectDetails(Long id,CreateProspectDetailsRequest createProspectDetailsRequest);
	
	List<ProspectDetailsResponse> getAllProspects(MemberSearchCriteria criteria);
	
	ProspectDetailsResponse getProspectById(Long id);
	
	/** #################  MEMBERSHIP  SERVICES ##################### */
	
	GetMembershipDetail createMembership(CreateMembershipRequest createMembershipRequest);
	
	MembershipResponse getMembershipDetailsById(Long id);
	
	List<MembershipResponse> getAllMembershipDetails();
	
	List<MembershipResponse> getAllMembershipDetailWithFilter(MembershipFilterCriteria criteria);
	
	/** ############# PERSONAL TRAINING DETAILS SERVICE ########## */
	
	
	Long createPersonalTrainingDetails(CreatePersonalTrainingDetailRequest CreatePersonalTrainingDetailsRequest);
	
	PersonalTrainingDetailsResponse updatePersonalTrainingDetails(Long id,CreatePersonalTrainingDetailRequest createPersonalTrainingDetailsRequest);
	
	PersonalTrainingDetailsResponse getPersonalTrainingDetailsById(Long id);
	
	List<PersonalTrainingDetailsResponse> getAllPersonalTrainingDetails();
	
	/* ############  MEMBER TRANSFER SERVICE #######################  */
	
	Long createMemberTransfer(CreateMemberTransferRequest createMemberTransferRequest);
	
	
	/*############# FREEZE REQUEST SERVICE ########################   */
	
	Long createFreezeRequest(CreateFreezeRequest createFreezeRequest);
	

}
