package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "BUSINESS_UNIT_DETAILS")
@SequenceGenerator(sequenceName = "SEQ_BUSINESS_UNIT_DETAILS", initialValue = 10, allocationSize = 1, name = "SEQ_BUSINESS_UNIT_DETAILS")
public class BusinessUnitDetails {

	@Id
	@GeneratedValue(generator = "SEQ_BUSINESS_UNIT_DETAILS", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(unique = true, length = 10)
	private String businessUnitCode;

	@Column(length = 120)
	private String businessUnitName;

	@Column(length = 120)
	private String addressLine1;

	@Column(length = 120)
	private String addressLine2;

	@Column(length = 20)
	private String postOfficeBox;

	@Column(length = 20)
	private String city;

	@Column(length = 20)
	private String state;

	@OneToOne
	@JoinColumn(name = "COUNTRY_DETAILS_ID", referencedColumnName = "ID")
	private CountryDetails countryDetails;

	/*@OneToMany(mappedBy = "businessUnitDetails", fetch = FetchType.EAGER)
	private Set<MemberDetails> memberDetails = new HashSet<MemberDetails>();*/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBusinessUnitCode() {
		return businessUnitCode;
	}

	public void setBusinessUnitCode(String businessUnitCode) {
		this.businessUnitCode = businessUnitCode;
	}

	public String getBusinessUnitName() {
		return businessUnitName;
	}

	public void setBusinessUnitName(String businessUnitName) {
		this.businessUnitName = businessUnitName;
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

	public String getPostOfficeBox() {
		return postOfficeBox;
	}

	public void setPostOfficeBox(String postOfficeBox) {
		this.postOfficeBox = postOfficeBox;
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

	

	public CountryDetails getCountryDetails() {
		return countryDetails;
	}

	public void setCountryDetails(CountryDetails countryDetails) {
		this.countryDetails = countryDetails;
	}

	@Override
	public String toString() {
		return "BusinessUnitDetails [id=" + id + ", businessUnitCode=" + businessUnitCode + ", businessUnitName="
				+ businessUnitName + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2
				+ ", postOfficeBox=" + postOfficeBox + ", city=" + city + ", state=" + state + ", countryDetails="
				+ countryDetails +  "]";
	}

}
