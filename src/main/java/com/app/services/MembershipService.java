package com.app.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.app.dto.BusinessUnitDetailsResponse;
import com.app.dto.CreateMembershipPackageDetailsRequest;
import com.app.dto.CreateMembershipTypeRequest;
import com.app.dto.CreatePersonalTrainingTypeRequest;
import com.app.dto.CreateStaffDetailsRequest;
import com.app.dto.MembershipPackageDetailsResponse;
import com.app.dto.MembershipTypeResponse;
import com.app.dto.PersonalTrainingTypeResponse;
import com.app.dto.StaffDetailsResponse;

public interface MembershipService {

	 /** ######################## MEMBERSHIP TYPE SERVICE ############################ */
	 Long createMembershipType(CreateMembershipTypeRequest createMembershipTypeRequest);

	 MembershipTypeResponse updateMembershipType(Long id, CreateMembershipTypeRequest createMembershipTypeRequest);

	 MembershipTypeResponse getMembershipTypeById(Long id);
	
	 Page<MembershipTypeResponse> getAllMembershipTypes(String membershipTypeCode,Pageable pageRequest);
	 
	 Page<MembershipTypeResponse> getAllMembershipTypesAsPageable(Pageable pageRequest);
	 
	 /** ######################## COMAPY OR BUSINESS ENTITY ############################ */
	  
	 List<BusinessUnitDetailsResponse> getAllCompanyOrBusinessUnits();
	 
	 BusinessUnitDetailsResponse getBusinessUnitDetailsById(Long id);
	 
	 /** ###################### PERSONAL TRAINING TYPE   ################################  */
	 
	 Long createPersonalTrainingType(CreatePersonalTrainingTypeRequest createPersonalTrainingTypeRequest );
	 
	 PersonalTrainingTypeResponse updatePersonalTrainingType(Long id,CreatePersonalTrainingTypeRequest createPersonalTrainingTypeRequest );
	 
	 PersonalTrainingTypeResponse getPersonalTrainingTypeById(Long id);
	 
	 List< PersonalTrainingTypeResponse> getAllPersonalTrainingType();
	 
	 
	 /** ###################### STAFF DETAILS OPERATIONS   ###############################  */
	 
	 Long createStaffDetails(CreateStaffDetailsRequest createStaffDetailsRequest);
	 
	 StaffDetailsResponse updateStaffDetails(Long id, CreateStaffDetailsRequest createStaffDetailsRequest);
	 
	 StaffDetailsResponse getStaffDetailsById(Long id);
	 
	 List<StaffDetailsResponse> getAllStaffDetails();
	 
	 
	 /** ###################### MEMBERSHIP PKG DTLS   ######################################  */
	 
	 Long createMembershipPackageDetails(CreateMembershipPackageDetailsRequest createMembershipPackageDetailsRequest);
	 
	 MembershipPackageDetailsResponse getMembershipPackageDetailsById(Long id);
	
	 

}
