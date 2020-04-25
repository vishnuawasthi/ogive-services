package com.app.services;

import java.util.List;

import com.app.dto.MembershipDetailsResponse;
import com.app.dto.PersonalTrainingDetailsResponse;
import com.app.dto.UpdateMemberDetailRequest;

public interface MemberOperationService {

	List<PersonalTrainingDetailsResponse> getPersonalTrainingsByMemberId(Long memberId);

	List<MembershipDetailsResponse> loadMembershipDetailByMemberId(Long memberId);
	
	MembershipDetailsResponse loadMembershipDetailByMemberIdAndMembershipNumber(Long memberId, Long membershipId);
	
	PersonalTrainingDetailsResponse  getPersonalTrainingsByMemberIdAndId(Long memberId,Long trainingId);
	
	void updateMemberDetails(Long id,UpdateMemberDetailRequest request);
}
