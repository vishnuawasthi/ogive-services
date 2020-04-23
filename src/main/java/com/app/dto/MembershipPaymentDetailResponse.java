package com.app.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MembershipPaymentDetailResponse {

	private Long membershipId;

	private Long memberId;

	private String firstName;

	private String lastName;

	private String middleName;

	private String displayName;

	private Float joiningFee;

	private Float subscriptionFee;

	private Float discount;

	private Float NetFee;

	private Float duration;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date startDate;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date joiningDate;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date expireDate;

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

}
