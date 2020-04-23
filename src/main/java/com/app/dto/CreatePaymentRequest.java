package com.app.dto;

import java.util.List;

import javax.validation.Valid;

import com.sun.istack.NotNull;

public class CreatePaymentRequest {

	@NotNull
	private Long membershipId;

	@NotNull
	private Long memberId;

	@NotNull
	@Valid
	private List<PaymentRequest> payments;

	public List<PaymentRequest> getPayments() {
		return payments;
	}

	public void setPayments(List<PaymentRequest> payments) {
		this.payments = payments;
	}

	public Long getMembershipId() {
		return membershipId;
	}

	public void setMembershipId(Long membershipId) {
		this.membershipId = membershipId;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	
}
