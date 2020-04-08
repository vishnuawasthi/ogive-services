package com.app.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

public class CreateMembershipRequest {

	@ApiModelProperty(required = true)
	@Valid
	@NotNull
	private MemberDetailsRequest memberDetails;

	@ApiModelProperty(required = true)
	@Valid
	@NotNull
	private MembershipDetailsRequest membershipDetails;

	public MemberDetailsRequest getPersonalDetails() {
		return memberDetails;
	}

	public void setPersonalDetails(MemberDetailsRequest personalDetails) {
		this.memberDetails = personalDetails;
	}

	public MembershipDetailsRequest getMembershipDetails() {
		return membershipDetails;
	}

	public void setMembershipDetails(MembershipDetailsRequest membershipDetails) {
		this.membershipDetails = membershipDetails;
	}

	@Override
	public String toString() {
		return "CreateMembershipRequest [personalDetails=" + memberDetails + ", membershipDetails="
				+ membershipDetails + "]";
	}

}
