package com.app.dto;

public class MembershipResponse {

	private MembershipDetailsResponse membershipDetails;

	private MemberDetailsResponse memeberDetails;

	public MembershipDetailsResponse getMembershipDetails() {
		return membershipDetails;
	}

	public void setMembershipDetails(MembershipDetailsResponse membershipDetails) {
		this.membershipDetails = membershipDetails;
	}

	public MemberDetailsResponse getMemeberDetails() {
		return memeberDetails;
	}

	public void setMemeberDetails(MemberDetailsResponse memeberDetails) {
		this.memeberDetails = memeberDetails;
	}

}
