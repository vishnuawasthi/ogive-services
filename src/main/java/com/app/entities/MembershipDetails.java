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
@Table(name = "MEMBERSHIP_DETAILS")
@SequenceGenerator(sequenceName = "SEQ_MEMBERSHIP_DETAILS", initialValue = 1, allocationSize = 1, name = "SEQ_MEMBERSHIP_DETAILS")
public class MembershipDetails {

	@Id
	@GeneratedValue(generator = "SEQ_MEMBERSHIP_DETAILS", strategy = GenerationType.SEQUENCE)
	private Long id;

	private String membershipType;

	private String source;

	private String introducedMemberCode;

	private String registrationType;

	private String membershipTypeCode;

	private Float duration;

	private String corporateCode;

	private String corporateName;

	private String packageCode;

	private String packageName;

	private String advisorName;

	private String advisorCode;

	private String accessCardNumber;

	private Date registrationDate;

	private Date joiningDate;

	private Date startDate;

	private Date expireDate;

	@OneToOne(mappedBy = "membershipDetails")
	private MemberDetails memberDetails;

	@OneToOne
	@JoinColumn(name = "MEMBERSHIP_TYPE_ID", referencedColumnName = "ID")
	private MembershipTypes membershipTypes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMembershipType() {
		return membershipType;
	}

	public void setMembershipType(String membershipType) {
		this.membershipType = membershipType;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getIntroducedMemberCode() {
		return introducedMemberCode;
	}

	public void setIntroducedMemberCode(String introducedMemberCode) {
		this.introducedMemberCode = introducedMemberCode;
	}

	public String getRegistrationType() {
		return registrationType;
	}

	public void setRegistrationType(String registrationType) {
		this.registrationType = registrationType;
	}

	public String getMembershipTypeCode() {
		return membershipTypeCode;
	}

	public void setMembershipTypeCode(String membershipTypeCode) {
		this.membershipTypeCode = membershipTypeCode;
	}

	public Float getDuration() {
		return duration;
	}

	public void setDuration(Float duration) {
		this.duration = duration;
	}

	public String getCorporateCode() {
		return corporateCode;
	}

	public void setCorporateCode(String corporateCode) {
		this.corporateCode = corporateCode;
	}

	public String getCorporateName() {
		return corporateName;
	}

	public void setCorporateName(String corporateName) {
		this.corporateName = corporateName;
	}

	public String getPackageCode() {
		return packageCode;
	}

	public void setPackageCode(String packageCode) {
		this.packageCode = packageCode;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getAdvisorName() {
		return advisorName;
	}

	public void setAdvisorName(String advisorName) {
		this.advisorName = advisorName;
	}

	public String getAdvisorCode() {
		return advisorCode;
	}

	public void setAdvisorCode(String advisorCode) {
		this.advisorCode = advisorCode;
	}

	public String getAccessCardNumber() {
		return accessCardNumber;
	}

	public void setAccessCardNumber(String accessCardNumber) {
		this.accessCardNumber = accessCardNumber;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public MemberDetails getMemberDetails() {
		return memberDetails;
	}

	public void setMemberDetails(MemberDetails memberDetails) {
		this.memberDetails = memberDetails;
	}

	public MembershipTypes getMembershipTypes() {
		return membershipTypes;
	}

	public void setMembershipTypes(MembershipTypes membershipTypes) {
		this.membershipTypes = membershipTypes;
	}

	@Override
	public String toString() {
		return "MembershipDetails [id=" + id + ", membershipType=" + membershipType + ", source=" + source
				+ ", introducedMemberCode=" + introducedMemberCode + ", registrationType=" + registrationType
				+ ", membershipTypeCode=" + membershipTypeCode + ", duration=" + duration + ", corporateCode="
				+ corporateCode + ", corporateName=" + corporateName + ", packageCode=" + packageCode + ", packageName="
				+ packageName + ", advisorName=" + advisorName + ", advisorCode=" + advisorCode + ", accessCardNumber="
				+ accessCardNumber + ", registrationDate=" + registrationDate + ", joiningDate=" + joiningDate
				+ ", startDate=" + startDate + ", expireDate=" + expireDate + ", memberDetails=" + memberDetails
				+ ", membershipTypes=" + membershipTypes + "]";
	}

}
