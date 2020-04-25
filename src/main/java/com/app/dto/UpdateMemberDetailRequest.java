package com.app.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class UpdateMemberDetailRequest {

	@NotEmpty
	@ApiModelProperty(required = true)
	private String firstName;

	private String middleName;

	@NotEmpty
	@ApiModelProperty(required = true)
	private String lastName;

	@NotEmpty
	@ApiModelProperty(required = true)
	private String displayName;

	@ApiModelProperty(allowableValues = "yyyy-MM-dd", required = true)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateOfBirth;

	@NotEmpty()
	private String email;

	@ApiModelProperty(required = true)
	@Pattern(regexp = "\\d{10}")
	private String mobileNumber;

	private EmergencyContactRequest emergencyContactDetails;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public EmergencyContactRequest getEmergencyContactDetails() {
		return emergencyContactDetails;
	}

	public void setEmergencyContactDetails(EmergencyContactRequest emergencyContactDetails) {
		this.emergencyContactDetails = emergencyContactDetails;
	}

	
}
