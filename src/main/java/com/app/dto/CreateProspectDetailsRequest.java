package com.app.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class CreateProspectDetailsRequest {

	@NotEmpty
	@ApiModelProperty(required = true)
	private String firstName;

	private String middleName;

	@NotEmpty
	@ApiModelProperty(required = true)
	private String lastName;

	private String displayName;

	@ApiModelProperty(allowableValues = "yyyy-MM-dd", required = true)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateOfBirth;

	private String gender;

	private String maritalStatus;

	private String bloodGroup;

	@NotEmpty()
	private String email;

	@ApiModelProperty(required = true)
	@Pattern(regexp = "\\d{10}")
	private String mobileNumber;

	private Float height;

	private Float weight;

	private String idNumber;

	private String passportNumber;

	// Address details
	@NotEmpty
	@ApiModelProperty(required = true)
	private String addressLine1;

	private String addressLine2;

	private String poBoxNumber;

	private String city;

	private String state;

	@NotEmpty()
	@ApiModelProperty(required = true, example = "QAT", allowableValues = "Any valid country code. It should be available in the system")
	private String countryCode;

	@ApiModelProperty(required = true)
	@NotNull
	private Long companyOrBusinessUnit;

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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
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

	public Float getHeight() {
		return height;
	}

	public void setHeight(Float height) {
		this.height = height;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getPoBoxNumber() {
		return poBoxNumber;
	}

	public void setPoBoxNumber(String poBoxNumber) {
		this.poBoxNumber = poBoxNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public Long getCompanyOrBusinessUnit() {
		return companyOrBusinessUnit;
	}

	public void setCompanyOrBusinessUnit(Long companyOrBusinessUnit) {
		this.companyOrBusinessUnit = companyOrBusinessUnit;
	}

	public EmergencyContactRequest getEmergencyContactDetails() {
		return emergencyContactDetails;
	}

	public void setEmergencyContactDetails(EmergencyContactRequest emergencyContactDetails) {
		this.emergencyContactDetails = emergencyContactDetails;
	}
	
	
}
