package com.app.dto;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class PortalUserDetailsRequest {

	// private Long id;

	@ApiModelProperty(required = true)
	private String username;

	@ApiModelProperty(required = true)
	private String password;

	private String isAcccountLocked = "N";

	private String isEnabled = "Y";

	@ApiModelProperty(required = true)
	private String firstname;

	@ApiModelProperty(required = true)
	private String lastname;

	private String middlename;

	private String gender;

	private Date dateOfBirth;

	private String email;

	private String contactNumber;

	private String alternateContactNumber;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIsAcccountLocked() {
		return isAcccountLocked;
	}

	public void setIsAcccountLocked(String isAcccountLocked) {
		this.isAcccountLocked = isAcccountLocked;
	}

	public String getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(String isEnabled) {
		this.isEnabled = isEnabled;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getAlternateContactNumber() {
		return alternateContactNumber;
	}

	public void setAlternateContactNumber(String alternateContactNumber) {
		this.alternateContactNumber = alternateContactNumber;
	}

	@Override
	public String toString() {
		return "PortalUserDetailsRequest ["+"username=" + username + ", password=" + password
				+ ", isAcccountLocked=" + isAcccountLocked + ", isEnabled=" + isEnabled + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", middlename=" + middlename + ", gender=" + gender + ", dateOfBirth="
				+ dateOfBirth + ", email=" + email + ", contactNumber=" + contactNumber + ", alternateContactNumber="
				+ alternateContactNumber + "]";
	}

}
