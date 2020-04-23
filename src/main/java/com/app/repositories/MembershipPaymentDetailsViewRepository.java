package com.app.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.app.entities.MembershipPaymentDetailsView;
import com.app.entities.MembershipPaymentIndetifier;

public interface MembershipPaymentDetailsViewRepository
		extends PagingAndSortingRepository<MembershipPaymentDetailsView, MembershipPaymentIndetifier> {

	MembershipPaymentDetailsView findByMembershipId(Long membershipId);

}
