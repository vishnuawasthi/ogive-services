package com.app.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "MEMBERSHIP_DETAILS")
@SequenceGenerator(sequenceName = "SEQ_MEMBERSHIP_DETAILS", initialValue = 1, allocationSize = 1, name = "SEQ_MEMBERSHIP_DETAILS")
public class MembershipDetails {

	@Id
	@GeneratedValue(generator = "SEQ_MEMBERSHIP_DETAILS", strategy = GenerationType.SEQUENCE)
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
	private Integer height;
	private float weight;
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

	public MembershipDetails() {
		super();
	}

	public MembershipDetails(Long id, String initial, String firstName, String middleName, String lastName,
			String familyName, String displayName, String fullName, Date dateOfBirth, String gender,
			String maritalStatus, String bloodGroup, String email, String mobileNumber, Integer height, float weight,
			String referenceNumber, String membershipNumber, String idNumber, String passportNumber, String nationality,
			String poBoxNumber, String companyOrBusinessUnit, String apartmentNumber, String street, String building,
			String location, String companyName, String designation) {
		super();
		this.id = id;
		this.initial = initial;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.familyName = familyName;
		this.displayName = displayName;
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.maritalStatus = maritalStatus;
		this.bloodGroup = bloodGroup;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.height = height;
		this.weight = weight;
		this.referenceNumber = referenceNumber;
		this.membershipNumber = membershipNumber;
		this.idNumber = idNumber;
		this.passportNumber = passportNumber;
		this.nationality = nationality;
		this.poBoxNumber = poBoxNumber;
		this.companyOrBusinessUnit = companyOrBusinessUnit;
		this.apartmentNumber = apartmentNumber;
		this.street = street;
		this.building = building;
		this.location = location;
		this.companyName = companyName;
		this.designation = designation;
	}

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

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
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

	@Override
	public String toString() {
		return "MembershipDetails [id=" + id + ", initial=" + initial + ", firstName=" + firstName + ", middleName="
				+ middleName + ", lastName=" + lastName + ", familyName=" + familyName + ", displayName=" + displayName
				+ ", fullName=" + fullName + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", maritalStatus="
				+ maritalStatus + ", bloodGroup=" + bloodGroup + ", email=" + email + ", mobileNumber=" + mobileNumber
				+ ", height=" + height + ", weight=" + weight + ", referenceNumber=" + referenceNumber
				+ ", membershipNumber=" + membershipNumber + ", idNumber=" + idNumber + ", passportNumber="
				+ passportNumber + ", nationality=" + nationality + ", poBoxNumber=" + poBoxNumber
				+ ", companyOrBusinessUnit=" + companyOrBusinessUnit + ", apartmentNumber=" + apartmentNumber
				+ ", street=" + street + ", building=" + building + ", location=" + location + ", companyName="
				+ companyName + ", designation=" + designation + "]";
	}

}
