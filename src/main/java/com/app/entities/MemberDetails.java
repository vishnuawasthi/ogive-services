package com.app.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

	private String firstName;

	private String middleName;

	private String lastName;

	private String displayName;

	private Date dateOfBirth;

	private String gender;

	private String maritalStatus;

	private String bloodGroup;

	private String email;

	private String mobileNumber;

	private Float height;

	private Float weight;

	private String idNumber;

	private String passportNumber;

	private String companyName;

	private String designation;

	@OneToMany(mappedBy = "memberDetails", fetch = FetchType.EAGER)
	private Set<MembershipDetails> membershipDetails = new HashSet<MembershipDetails>();

	@OneToOne
	@JoinColumn(name = "COUNTRY_DETAILS_ID", referencedColumnName = "ID")
	private CountryDetails countryDetails;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "BUSINESS_UNIT_DTLS_ID")
	private BusinessUnitDetails businessUnitDetails;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "EMERG_CTC_DTLS_ID", referencedColumnName = "ID")
	private EmergencyContactDetails emergencyContactDetails;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ADDRESS_DTL_ID", referencedColumnName = "ID")
	private AddressDetails addressDetails;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public CountryDetails getCountryDetails() {
		return countryDetails;
	}

	public void setCountryDetails(CountryDetails countryDetails) {
		this.countryDetails = countryDetails;
	}

	public BusinessUnitDetails getBusinessUnitDetails() {
		return businessUnitDetails;
	}

	public void setBusinessUnitDetails(BusinessUnitDetails businessUnitDetails) {
		this.businessUnitDetails = businessUnitDetails;
	}

	public EmergencyContactDetails getEmergencyContactDetails() {
		return emergencyContactDetails;
	}

	public void setEmergencyContactDetails(EmergencyContactDetails emergencyContactDetails) {
		this.emergencyContactDetails = emergencyContactDetails;
	}

	public AddressDetails getAddressDetails() {
		return addressDetails;
	}

	public void setAddressDetails(AddressDetails addressDetails) {
		this.addressDetails = addressDetails;
	}

	public Set<MembershipDetails> getMembershipDetails() {
		return membershipDetails;
	}

	public void setMembershipDetails(Set<MembershipDetails> membershipDetails) {
		this.membershipDetails = membershipDetails;
	}

}
