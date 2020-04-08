package com.app.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PROSPECT_DTLS")
@SequenceGenerator(sequenceName = "SEQ_PROSPECT_DTLS", initialValue = 1, allocationSize = 1, name = "SEQ_PROSPECT_DTLS")
public class ProspectDetails {

	@Id
	@GeneratedValue(generator = "SEQ_PROSPECT_DTLS", strategy = GenerationType.SEQUENCE)
	private Long id;

	private String salutation;

	private String firstName;

	private String lastName;

	private String familyName;

	private String idNumber;

	private String address;

	private String email;

	private String mobileNumber;

	private String advisorCode;

	private String advisorName;

	private String location;

	private Date enquiryDate;

	private String referenceNumber;

	private String membershipTypeCode;

	private String passportNumber;

	private Date dateOfBirth;

	private String gender;

	private String nationality;

	private Float height;

	private Float weight;

	private String companyOrBusinessUnitCode;

	private String maritalStatus;

	private String companyName;

	private String designation;

	private String source;

	private Date expectedJoinDate;

	private String observation;

	private String notes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getAdvisorCode() {
		return advisorCode;
	}

	public void setAdvisorCode(String advisorCode) {
		this.advisorCode = advisorCode;
	}

	public String getAdvisorName() {
		return advisorName;
	}

	public void setAdvisorName(String advisorName) {
		this.advisorName = advisorName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getEnquiryDate() {
		return enquiryDate;
	}

	public void setEnquiryDate(Date enquiryDate) {
		this.enquiryDate = enquiryDate;
	}

	public String getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public String getMembershipTypeCode() {
		return membershipTypeCode;
	}

	public void setMembershipTypeCode(String membershipTypeCode) {
		this.membershipTypeCode = membershipTypeCode;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
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

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
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

	public String getCompanyOrBusinessUnitCode() {
		return companyOrBusinessUnitCode;
	}

	public void setCompanyOrBusinessUnitCode(String companyOrBusinessUnitCode) {
		this.companyOrBusinessUnitCode = companyOrBusinessUnitCode;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
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

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Date getExpectedJoinDate() {
		return expectedJoinDate;
	}

	public void setExpectedJoinDate(Date expectedJoinDate) {
		this.expectedJoinDate = expectedJoinDate;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public ProspectDetails() {
		super();
	}

	public ProspectDetails(Long id, String salutation, String firstName, String lastName, String familyName,
			String idNumber, String address, String email, String mobileNumber, String advisorCode, String advisorName,
			String location, Date enquiryDate, String referenceNumber, String membershipTypeCode, String passportNumber,
			Date dateOfBirth, String gender, String nationality, Float height, Float weight,
			String companyOrBusinessUnitCode, String maritalStatus, String companyName, String designation,
			String source, Date expectedJoinDate, String observation, String notes) {
		super();
		this.id = id;
		this.salutation = salutation;
		this.firstName = firstName;
		this.lastName = lastName;
		this.familyName = familyName;
		this.idNumber = idNumber;
		this.address = address;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.advisorCode = advisorCode;
		this.advisorName = advisorName;
		this.location = location;
		this.enquiryDate = enquiryDate;
		this.referenceNumber = referenceNumber;
		this.membershipTypeCode = membershipTypeCode;
		this.passportNumber = passportNumber;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.nationality = nationality;
		this.height = height;
		this.weight = weight;
		this.companyOrBusinessUnitCode = companyOrBusinessUnitCode;
		this.maritalStatus = maritalStatus;
		this.companyName = companyName;
		this.designation = designation;
		this.source = source;
		this.expectedJoinDate = expectedJoinDate;
		this.observation = observation;
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "ProspectDetails [id=" + id + ", salutation=" + salutation + ", firstName=" + firstName + ", lastName="
				+ lastName + ", familyName=" + familyName + ", idNumber=" + idNumber + ", address=" + address
				+ ", email=" + email + ", mobileNumber=" + mobileNumber + ", advisorCode=" + advisorCode
				+ ", advisorName=" + advisorName + ", location=" + location + ", enquiryDate=" + enquiryDate
				+ ", referenceNumber=" + referenceNumber + ", membershipTypeCode=" + membershipTypeCode
				+ ", passportNumber=" + passportNumber + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender
				+ ", nationality=" + nationality + ", height=" + height + ", weight=" + weight
				+ ", companyOrBusinessUnitCode=" + companyOrBusinessUnitCode + ", maritalStatus=" + maritalStatus
				+ ", companyName=" + companyName + ", designation=" + designation + ", source=" + source
				+ ", expectedJoinDate=" + expectedJoinDate + ", observation=" + observation + ", notes=" + notes + "]";
	}

}
