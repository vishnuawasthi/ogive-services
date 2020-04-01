package com.app.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.app.dto.MemberDetailsResponse;
import com.app.dto.MemberRegistrationRequest;
import com.app.dto.PortalUserDetailsRequest;
import com.app.dto.PortalUserDetailsResponse;
import com.app.exception.RecordNotFoundException;

public interface PortalOperationService {

	MemberRegistrationRequest getUserById(Long id);

	Long saveUserDetails(MemberRegistrationRequest userDetailsDTO);

	Long saveMembershipDetails(MemberRegistrationRequest memberRegistrationRequest);

	List<MemberDetailsResponse> getAllMemberShips();

	// Portal User Details

	Long savePortalUserDetails(PortalUserDetailsRequest request);

	List<PortalUserDetailsResponse> getAllPortalUsers();

	PortalUserDetailsResponse getPortalUserById(Long id);

	PortalUserDetailsResponse updatePortalUserDetails(Long id, PortalUserDetailsRequest portalUserDetailsRequest)
			throws RecordNotFoundException;

	void suspendAcccount(Long id);

	void enableAcccount(Long id);

}
