package com.app.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.app.constants.Authorities;
import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class PortalUserDetailsResponse {

	private Long id;
	
	@ApiModelProperty(required = true)
	private String username;

	private String password;

	private String isAcccountLocked = "N";

	private String isEnabled = "Y";

	@ApiModelProperty(required = true)
	private String firstname;

	@ApiModelProperty(required = true)
	private String lastname;

	private String middlename;

	private String gender;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateOfBirth;

	private String email;

	private String contactNumber;

	private String alternateContactNumber;

	private List<Authorities> authorities = new ArrayList<Authorities>();

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

	public PortalUserDetailsResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PortalUserDetailsResponse(String username, String password, String isAcccountLocked, String isEnabled,
			String firstname, String lastname, String middlename, String gender, Date dateOfBirth, String email,
			String contactNumber, String alternateContactNumber) {
		super();
		this.username = username;
		this.password = password;
		this.isAcccountLocked = isAcccountLocked;
		this.isEnabled = isEnabled;
		this.firstname = firstname;
		this.lastname = lastname;
		this.middlename = middlename;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.contactNumber = contactNumber;
		this.alternateContactNumber = alternateContactNumber;
	}

	public List<Authorities> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Authorities> authorities) {
		this.authorities = authorities;
	}

	
}
