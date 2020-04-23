package com.app.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class CreatePersonalTrainingDetailRequest {

	private String description;
	private Float duration;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date startDate;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date endDate;
	
	private Integer extraSessions;
	
	private Integer totalSessions;

	private Float joiningFee;
	
	private Float subscriptionFee;
	
	private Float discount;
	
	private Float totalFee;

	private String corporateCode;
	
	private String corporateName;

	private String notes;

	@NotNull
	@ApiModelProperty(required = true)
	private Long personalTrainingType;

	@NotNull
	@ApiModelProperty(required = true)
	private Long membershipId;

	@NotNull
	@ApiModelProperty(required = true)
	private Long trainerId;

	@NotNull
	@ApiModelProperty(required = true)
	private Long advisorId;

	@NotNull
	@ApiModelProperty(required = true)
	private Long companyOrBusinessUnit;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Long getPersonalTrainingType() {
		return personalTrainingType;
	}

	public void setPersonalTrainingType(Long personalTrainingType) {
		this.personalTrainingType = personalTrainingType;
	}

	public Long getMembershipId() {
		return membershipId;
	}

	public void setMembershipId(Long membershipId) {
		this.membershipId = membershipId;
	}

	public Long getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(Long trainerId) {
		this.trainerId = trainerId;
	}

	public Long getAdvisorId() {
		return advisorId;
	}

	public void setAdvisorId(Long advisorId) {
		this.advisorId = advisorId;
	}

	public Long getCompanyOrBusinessUnit() {
		return companyOrBusinessUnit;
	}

	public void setCompanyOrBusinessUnit(Long companyOrBusinessUnit) {
		this.companyOrBusinessUnit = companyOrBusinessUnit;
	}

}
