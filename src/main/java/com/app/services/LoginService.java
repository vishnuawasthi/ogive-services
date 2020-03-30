package com.app.services;

import java.util.List;

import com.app.dto.MemberDetailsResponse;
import com.app.dto.MemberRegistrationRequest;

public interface LoginService {

	MemberRegistrationRequest getUserById(Long id);

	Long saveUserDetails(MemberRegistrationRequest userDetailsDTO);

	Long saveMembershipDetails(MemberRegistrationRequest memberRegistrationRequest);

	List<MemberDetailsResponse> getAllMemberShips();

}
