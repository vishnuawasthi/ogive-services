package com.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.app.entities.MembershipDetails;

public interface MembershipDetailsRepository extends PagingAndSortingRepository<MembershipDetails, Long>, JpaSpecificationExecutor<MembershipDetails> {

	@Query(value = "SELECT mbrship FROM MembershipDetails mbrship  WHERE mbrship.memberDetails.id=:memberId")
	List<MembershipDetails> loadMembershipDetailByMemberId(@Param(value = "memberId") Long memberId);
	
	@Query(value = "SELECT mbrship FROM MembershipDetails mbrship  WHERE mbrship.id=:membershipId AND mbrship.memberDetails.id=:memberId")
	MembershipDetails loadMembershipDetailByMemberIdAndMembershipNumber(@Param(value = "memberId") Long memberId, @Param(value="membershipId") Long membershipId);
}
