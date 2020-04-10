package com.app.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class CreatePersonalTrainingDetailsRequest {

	private Long membershipNumber;

	private String membershipTypeCode;

	private String firstName;

	private String lastName;

	private String mobileNumber;

	@ApiModelProperty(required = true)
	@NotEmpty
	private String companyOrBusinessUnit;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@ApiModelProperty(required = true,example="yyyy-MM-dd")
	private Date joiningDate;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@ApiModelProperty(required = true,example="yyyy-MM-dd")
	private Date expireDate;

	/** ############### PERSONAL TRAINING DETAILS ####################### */

	@ApiModelProperty(required = true)
	@NotEmpty
	private String type;
	private String personalTrainingCode;
	private String description;
	private String referenceNumber;
	private Float duration;

	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@ApiModelProperty(required = true,example="yyyy-MM-dd")
	private Date startDate;

	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@ApiModelProperty(required = true,example="yyyy-MM-dd")
	private Date endDate;

	private String startTime;
	private String endTime;
	
	@NotNull
	@ApiModelProperty(required = true)
	private Integer extraSessions;
	
	@NotNull
	@ApiModelProperty(required = true)
	private Integer totalSessions;

	@NotEmpty
	@ApiModelProperty(required = true)
	private String trainerCode;

	@NotEmpty
	@ApiModelProperty(required = true)
	private String trainerName;

	@NotNull
	@ApiModelProperty(required = true)
	private Float joiningFees;

	@NotNull
	@ApiModelProperty(required = true)
	private Float subscriptionFees;

	@NotNull
	@ApiModelProperty(required = true)
	private Float grossTotal;

	@NotEmpty
	@ApiModelProperty(required = true)
	private String advisorCode;
	@NotEmpty
	@ApiModelProperty(required = true)
	private String advisorName;

	private String corporateCode;

	private String corporateName;

	@NotNull
	@ApiModelProperty(required = true)
	private Float netAmount;
	private String notes;

	public Long getMembershipNumber() {
		return membershipNumber;
	}

	public void setMembershipNumber(Long membershipNumber) {
		this.membershipNumber = membershipNumber;
	}

	public String getMembershipTypeCode() {
		return membershipTypeCode;
	}

	public void setMembershipTypeCode(String membershipTypeCode) {
		this.membershipTypeCode = membershipTypeCode;
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

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getCompanyOrBusinessUnit() {
		return companyOrBusinessUnit;
	}

	public void setCompanyOrBusinessUnit(String companyOrBusinessUnit) {
		this.companyOrBusinessUnit = companyOrBusinessUnit;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPersonalTrainingCode() {
		return personalTrainingCode;
	}

	public void setPersonalTrainingCode(String personalTrainingCode) {
		this.personalTrainingCode = personalTrainingCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
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

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Integer getExtraSessions() {
		return extraSessions;
	}

	public void setExtraSessions(Integer extraSessions) {
		this.extraSessions = extraSessions;
	}

	public Integer getTotalSessions() {
		return totalSessions;
	}

	public void setTotalSessions(Integer totalSessions) {
		this.totalSessions = totalSessions;
	}

	public String getTrainerCode() {
		return trainerCode;
	}

	public void setTrainerCode(String trainerCode) {
		this.trainerCode = trainerCode;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public Float getJoiningFees() {
		return joiningFees;
	}

	public void setJoiningFees(Float joiningFees) {
		this.joiningFees = joiningFees;
	}

	public Float getSubscriptionFees() {
		return subscriptionFees;
	}

	public void setSubscriptionFees(Float subscriptionFees) {
		this.subscriptionFees = subscriptionFees;
	}

	public Float getGrossTotal() {
		return grossTotal;
	}

	public void setGrossTotal(Float grossTotal) {
		this.grossTotal = grossTotal;
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

	public Float getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(Float netAmount) {
		this.netAmount = netAmount;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}
