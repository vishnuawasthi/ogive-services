package com.app.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "COUNTRY_DETAILS")
@SequenceGenerator(sequenceName = "SEQ_COUNTRY_DETAILS", initialValue = 1, allocationSize = 1, name = "SEQ_COUNTRY_DETAILS")
public class CountryDetails {

	@Id
	@GeneratedValue(generator = "SEQ_COUNTRY_DETAILS", strategy = GenerationType.SEQUENCE)
	private Long id;

	private String countryName;

	@Column(unique=true,length=6)
	private String countryCode;

	private String nationality;

	@OneToMany(mappedBy = "countryDetails", fetch = FetchType.EAGER)
	Set<MemberDetails> memberDetails = new HashSet<MemberDetails>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Set<MemberDetails> getMemberDetails() {
		return memberDetails;
	}

	public void setMemberDetails(Set<MemberDetails> memberDetails) {
		this.memberDetails = memberDetails;
	}

	@Override
	public String toString() {
		return "CountryDetails [id=" + id + ", countryName=" + countryName + ", countryCode=" + countryCode
				+ ", nationality=" + nationality + ", memberDetails=" + memberDetails + "]";
	}

}
