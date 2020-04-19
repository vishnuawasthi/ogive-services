package com.app.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

@JsonPropertyOrder(value= {
		
		"firstName", 
		"middleName", 
		"lastName", 
		"displayName",
		"gender",
		"dateOfBirth",
		"maritalStatus",
		"bloodGroup",
		"mobileNumber",
		"email",
		"idNumber",
		"passportNumber",
		"designation",
		"companyName"
		
		
})

public class CreateMemberDetailsRequest {

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

	private String gender;

	private String maritalStatus;
	private String bloodGroup;
	private String email;

	@ApiModelProperty(required = true)
	@Pattern(regexp = "\\d{10}")
	private String mobileNumber;

	private Float height;

	private Float weight;

	@ApiModelProperty(required = true)
	@NotEmpty
	private String idNumber;
	private String passportNumber;

	private String companyName;
	private String designation;
	// Address details
	@NotEmpty
	@ApiModelProperty(required = true)
	private String addressLine1;

	private String addressLine2;

	private String poBoxNumber;

	private String city;

	private String state;

	@NotEmpty()
	@ApiModelProperty(required = true, example = "IND,USA", allowableValues = "Any valid country code. It should be available in the system")
	private String country;

	@ApiModelProperty(required = true)
	@NotEmpty
	private String companyOrBusinessUnit;
	
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

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCompanyOrBusinessUnit() {
		return companyOrBusinessUnit;
	}

	public void setCompanyOrBusinessUnit(String companyOrBusinessUnit) {
		this.companyOrBusinessUnit = companyOrBusinessUnit;
	}

	public EmergencyContactRequest getEmergencyContactDetails() {
		return emergencyContactDetails;
	}

	public void setEmergencyContactDetails(EmergencyContactRequest emergencyContactDetails) {
		this.emergencyContactDetails = emergencyContactDetails;
	}

	@Override
	public String toString() {
		return "CreateMemberDetailsRequest [firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", displayName=" + displayName + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender
				+ ", maritalStatus=" + maritalStatus + ", bloodGroup=" + bloodGroup + ", email=" + email
				+ ", mobileNumber=" + mobileNumber + ", height=" + height + ", weight=" + weight + ", idNumber="
				+ idNumber + ", passportNumber=" + passportNumber + ", companyName=" + companyName + ", designation="
				+ designation + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", poBoxNumber="
				+ poBoxNumber + ", city=" + city + ", state=" + state + ", country=" + country
				+ ", companyOrBusinessUnit=" + companyOrBusinessUnit + ", emergencyContactDetails="
				+ emergencyContactDetails + "]";
	}

	

}
