package com.app.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "MEMBER_DETAILS")
@SequenceGenerator(sequenceName = "SEQ_MEMBER_DETAILS", initialValue = 1, allocationSize = 1, name = "SEQ_MEMBER_DETAILS")
public class MemberDetails {

	@Id
	@GeneratedValue(generator = "SEQ_MEMBER_DETAILS", strategy = GenerationType.SEQUENCE)
	private Long id;

	private String initial;

	private String firstName;

	private String middleName;
	private String lastName;
	private String familyName;

	private String displayName;
	private String fullName;

	private Date dateOfBirth;
	private String gender;
	private String maritalStatus;
	private String bloodGroup;
	private String email;

	private String mobileNumber;
	private Float height;
	private Float weight;
	private String referenceNumber;
	private String membershipNumber;

	private String idNumber;
	private String passportNumber;
	private String nationality;
	private String poBoxNumber;
	private String companyOrBusinessUnit;
	private String apartmentNumber;
	private String street;
	private String building;
	private String location;
	private String companyName;
	private String designation;

	@OneToOne
	@JoinColumn(name = "MEMBERSHIP_DTLS_ID", referencedColumnName = "ID")
	private MembershipDetails membershipDetails;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInitial() {
		return initial;
	}

	public void setInitial(String initial) {
		this.initial = initial;
	}

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

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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

	public String getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public String getMembershipNumber() {
		return membershipNumber;
	}

	public void setMembershipNumber(String membershipNumber) {
		this.membershipNumber = membershipNumber;
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

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getPoBoxNumber() {
		return poBoxNumber;
	}

	public void setPoBoxNumber(String poBoxNumber) {
		this.poBoxNumber = poBoxNumber;
	}

	public String getCompanyOrBusinessUnit() {
		return companyOrBusinessUnit;
	}

	public void setCompanyOrBusinessUnit(String companyOrBusinessUnit) {
		this.companyOrBusinessUnit = companyOrBusinessUnit;
	}

	public String getApartmentNumber() {
		return apartmentNumber;
	}

	public void setApartmentNumber(String apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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

	public MembershipDetails getMembershipDetails() {
		return membershipDetails;
	}

	public void setMembershipDetails(MembershipDetails membershipDetails) {
		this.membershipDetails = membershipDetails;
	}

	@Override
	public String toString() {
		return "MemberDetails [id=" + id + ", initial=" + initial + ", firstName=" + firstName + ", middleName="
				+ middleName + ", lastName=" + lastName + ", familyName=" + familyName + ", displayName=" + displayName
				+ ", fullName=" + fullName + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", maritalStatus="
				+ maritalStatus + ", bloodGroup=" + bloodGroup + ", email=" + email + ", mobileNumber=" + mobileNumber
				+ ", height=" + height + ", weight=" + weight + ", referenceNumber=" + referenceNumber
				+ ", membershipNumber=" + membershipNumber + ", idNumber=" + idNumber + ", passportNumber="
				+ passportNumber + ", nationality=" + nationality + ", poBoxNumber=" + poBoxNumber
				+ ", companyOrBusinessUnit=" + companyOrBusinessUnit + ", apartmentNumber=" + apartmentNumber
				+ ", street=" + street + ", building=" + building + ", location=" + location + ", companyName="
				+ companyName + ", designation=" + designation + ", membershipDetails=" + membershipDetails + "]";
	}

}
