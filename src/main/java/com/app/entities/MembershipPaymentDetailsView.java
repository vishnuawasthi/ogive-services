package com.app.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MEMBERSHIP_PAYMENT_DTLS_VIEW")
public class MembershipPaymentDetailsView {

	@Id
	@Column(name = "MEMBERSHIP_DETAILS_ID")
	private Long membershipId;
	
	@Column(name = "MEMBER_DETAILS_ID")
	private Long memberId;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "MIDDLE_NAME")
	private String middleName;

	@Column(name = "DISPLAY_NAME")
	private String displayName;

	@Column(name = "JOINING_FEE")
	private Float joiningFee;

	@Column(name = "SUBSCRIPTION_FEE")
	private Float subscriptionFee;

	@Column(name = "DISCOUNT")
	private Float discount;

	@Column(name = "TOTAL_FEE")
	private Float NetFee;

	@Column(name = "DURATION")
	private Float duration;

	@Column(name = "START_DATE")
	private Date startDate;

	@Column(name = "JOINING_DATE")
	private Date joiningDate;

	@Column(name = "EXPIRE_DATE")
	private Date expireDate;

	@Column(name = "BUSINESS_UNIT_DTLS_ID")
	private Long companyOrbusinessUnit;

	public Long getMembershipId() {
		return membershipId;
	}

	public void setMembershipId(Long membershipId) {
		this.membershipId = membershipId;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
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

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Float getJoiningFee() {
		return joiningFee;
	}

	public void setJoiningFee(Float joiningFee) {
		this.joiningFee = joiningFee;
	}

	public Float getSubscriptionFee() {
		return subscriptionFee;
	}

	public void setSubscriptionFee(Float subscriptionFee) {
		this.subscriptionFee = subscriptionFee;
	}

	public Float getDiscount() {
		return discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

	public Float getNetFee() {
		return NetFee;
	}

	public void setNetFee(Float netFee) {
		NetFee = netFee;
	}

	public Float getDuration() {
		return duration;
	}

	public void setDuration(Float duration) {
		this.duration = duration;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public Long getCompanyOrbusinessUnit() {
		return companyOrbusinessUnit;
	}

	public void setCompanyOrbusinessUnit(Long companyOrbusinessUnit) {
		this.companyOrbusinessUnit = companyOrbusinessUnit;
	}

	@Override
	public String toString() {
		return "MembershipPaymentDetailsView [membershipId=" + membershipId + ", memberId=" + memberId + ", firstName="
				+ firstName + ", lastName=" + lastName + ", middleName=" + middleName + ", displayName=" + displayName
				+ ", joiningFee=" + joiningFee + ", subscriptionFee=" + subscriptionFee + ", discount=" + discount
				+ ", NetFee=" + NetFee + ", duration=" + duration + ", startDate=" + startDate + ", joiningDate="
				+ joiningDate + ", expireDate=" + expireDate + ", companyOrbusinessUnit=" + companyOrbusinessUnit + "]";
	}

}
