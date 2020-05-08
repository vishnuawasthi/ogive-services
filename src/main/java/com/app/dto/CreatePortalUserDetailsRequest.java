package com.app.dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.app.constants.ApplicationConstants;
import com.app.constants.Authorities;
import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class CreatePortalUserDetailsRequest {

	@NotEmpty
	@ApiModelProperty(required = true)
	private String username;

	@NotEmpty
	@ApiModelProperty(required = true)
	private String password;

	// private String isAcccountLocked = "N";

	// private String isEnabled = "Y";

	@NotEmpty
	@ApiModelProperty(required = true)
	private String firstname;

	@NotEmpty
	@ApiModelProperty(required = true)
	private String lastname;

	private String middlename;

	@ApiModelProperty(required = false, example = "MALE,FEMALE,OTHER")
	private String gender;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@ApiModelProperty(required = false, allowableValues = "yyyy-MM-dd")
	private Date dateOfBirth;

	@Pattern(regexp = ApplicationConstants.EMAIL_PATTERN,message="Invalid Email format")
	private String email;

	private String contactNumber;

	private String alternateContactNumber;

	@ApiModelProperty(example = "['ADMIN','OPERATOR','MEMBER']", required = true)
	private List<Authorities> authorities;

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

	public List<Authorities> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Authorities> authorities) {
		this.authorities = authorities;
	}

}
