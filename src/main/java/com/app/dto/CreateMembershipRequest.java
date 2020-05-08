package com.app.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

@JsonPropertyOrder(alphabetic=true)
public class CreateMembershipRequest {

	@ApiModelProperty(required = true)
	@Valid
	@NotNull
	private CreateMemberDetailsRequest memberDetails;

	@ApiModelProperty(required = true)
	@Valid
	@NotNull
	private MembershipDetailsRequest membershipDetails;

	public CreateMemberDetailsRequest getMemberDetails() {
		return memberDetails;
	}

	public void setMemberDetails(CreateMemberDetailsRequest memberDetails) {
		this.memberDetails = memberDetails;
	}

	public MembershipDetailsRequest getMembershipDetails() {
		return membershipDetails;
	}

	public void setMembershipDetails(MembershipDetailsRequest membershipDetails) {
		this.membershipDetails = membershipDetails;
	}

}
