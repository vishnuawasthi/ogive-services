package com.app.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.app.dto.CreateMembershipTypeRequest;
import com.app.dto.MembershipTypeResponse;

public interface MembershipService {

	Long createMembershipType(CreateMembershipTypeRequest createMembershipTypeRequest);

	MembershipTypeResponse updateMembershipType(Long id, CreateMembershipTypeRequest createMembershipTypeRequest);

	MembershipTypeResponse getMembershipTypeById(Long id);
	
	 Page<MembershipTypeResponse> getAllMembershipTypes(String membershipTypeCode,Pageable pageRequest);

}
