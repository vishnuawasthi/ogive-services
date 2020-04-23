package com.app.services;

import com.app.dto.CreatePaymentRequest;
import com.app.dto.MembershipPaymentDetailResponse;

public interface PaymentService {

	void savePaymentDetails(CreatePaymentRequest request);
	
	MembershipPaymentDetailResponse fetchPaymentDetails(Long membershipId);
	
	
}
