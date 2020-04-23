package com.app.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class MembershipDetailsRequest {

	private String source;

	private String registrationType;
	
	@NotNull
	@ApiModelProperty(required = true)
	private Long membershipType;

	@NotNull
	@ApiModelProperty(required = true)
	private Float duration;

	
	private Long advisorId;

	private String accessCardNumber;

	@NotNull
	@ApiModelProperty(required = true, allowableValues = "yyyy-MM-dd")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date registrationDate;

	@NotNull
	@ApiModelProperty(required = true, allowableValues = "yyyy-MM-dd")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date joiningDate;

	@NotNull
	@ApiModelProperty(required = true, allowableValues = "yyyy-MM-dd")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date startDate;

	@NotNull
	@ApiModelProperty(required = true, allowableValues = "yyyy-MM-dd")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date expireDate;

	private String corporateCode;

	private String corporateName;

	// Fee Details
	@NotNull
	@ApiModelProperty(required = true)
	private Float joiningFee;
	
	@NotNull
	@ApiModelProperty(required = true)
	private Float subscriptionFee;
	
	@NotNull
	@ApiModelProperty(required = true)
	private Float discount;
	
	@NotNull
	@ApiModelProperty(required = true)
	private Float totalFee;

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getRegistrationType() {
		return registrationType;
	}

	public void setRegistrationType(String registrationType) {
		this.registrationType = registrationType;
	}

	public Long getMembershipType() {
		return membershipType;
	}

	public void setMembershipType(Long membershipType) {
		this.membershipType = membershipType;
	}

	public Float getDuration() {
		return duration;
	}

	public void setDuration(Float duration) {
		this.duration = duration;
	}

	public Long getAdvisorId() {
		return advisorId;
	}

	public void setAdvisorId(Long advisorId) {
		this.advisorId = advisorId;
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

	public Float getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(Float totalFee) {
		this.totalFee = totalFee;
	}

	@Override
	public String toString() {
		return "MembershipDetailsRequest [source=" + source + ", registrationType=" + registrationType
				+ ", membershipType=" + membershipType + ", duration=" + duration + ", advisorId=" + advisorId
				+ ", accessCardNumber=" + accessCardNumber + ", registrationDate=" + registrationDate + ", joiningDate="
				+ joiningDate + ", startDate=" + startDate + ", expireDate=" + expireDate + ", corporateCode="
				+ corporateCode + ", corporateName=" + corporateName + ", joiningFee=" + joiningFee
				+ ", subscriptionFee=" + subscriptionFee + ", discount=" + discount + ", totalFee=" + totalFee + "]";
	}

}
