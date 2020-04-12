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
	
	

	private EmergencyContactRequest emergencyContactDetails;

	public MemberDetailsRequest getMemberDetails() {
		return memberDetails;
	}

	public void setMemberDetails(MemberDetailsRequest memberDetails) {
		this.memberDetails = memberDetails;
	}

	public MembershipDetailsRequest getMembershipDetails() {
		return membershipDetails;
	}

	public void setMembershipDetails(MembershipDetailsRequest membershipDetails) {
		this.membershipDetails = membershipDetails;
	}

	public EmergencyContactRequest getEmergencyContactDetails() {
		return emergencyContactDetails;
	}

	public void setEmergencyContactDetails(EmergencyContactRequest emergencyContactDetails) {
		this.emergencyContactDetails = emergencyContactDetails;
	}

}
