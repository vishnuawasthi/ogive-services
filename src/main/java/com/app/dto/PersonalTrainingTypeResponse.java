package com.app.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class PersonalTrainingTypeResponse {

	@ApiModelProperty(required = true)
	private Long id;

	private String personalTrainingType;

	private String personalTrainingCode;

	@ApiModelProperty(required = true)
	private String description;

	private String companyOrBusinessUnitCode;

	@ApiModelProperty(required = true)
	private Float duration;

	private Integer extraSessions;

	private Integer allowedSessions;

	@ApiModelProperty(required = true)
	private Integer validityInDays;

	private String enableRecurringPayment;

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date effectiveDate;

	private Float joiningFees;

	private Float subscriptionFees;

	private Float allowableDiscount;

	private String notes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPersonalTrainingType() {
		return personalTrainingType;
	}

	public void setPersonalTrainingType(String personalTrainingType) {
		this.personalTrainingType = personalTrainingType;
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

	public String getCompanyOrBusinessUnitCode() {
		return companyOrBusinessUnitCode;
	}

	public void setCompanyOrBusinessUnitCode(String companyOrBusinessUnitCode) {
		this.companyOrBusinessUnitCode = companyOrBusinessUnitCode;
	}

	public Float getDuration() {
		return duration;
	}

	public void setDuration(Float duration) {
		this.duration = duration;
	}

	public Integer getExtraSessions() {
		return extraSessions;
	}

	public void setExtraSessions(Integer extraSessions) {
		this.extraSessions = extraSessions;
	}

	public Integer getAllowedSessions() {
		return allowedSessions;
	}

	public void setAllowedSessions(Integer allowedSessions) {
		this.allowedSessions = allowedSessions;
	}

	public Integer getValidityInDays() {
		return validityInDays;
	}

	public void setValidityInDays(Integer validityInDays) {
		this.validityInDays = validityInDays;
	}

	public String getEnableRecurringPayment() {
		return enableRecurringPayment;
	}

	public void setEnableRecurringPayment(String enableRecurringPayment) {
		this.enableRecurringPayment = enableRecurringPayment;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
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

	public Float getAllowableDiscount() {
		return allowableDiscount;
	}

	public void setAllowableDiscount(Float allowableDiscount) {
		this.allowableDiscount = allowableDiscount;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "PersonalTrainingTypeResponse [id=" + id + ", personalTrainingType=" + personalTrainingType
				+ ", personalTrainingCode=" + personalTrainingCode + ", description=" + description
				+ ", companyOrBusinessUnitCode=" + companyOrBusinessUnitCode + ", duration=" + duration
				+ ", extraSessions=" + extraSessions + ", allowedSessions=" + allowedSessions + ", validityInDays="
				+ validityInDays + ", enableRecurringPayment=" + enableRecurringPayment + ", effectiveDate="
				+ effectiveDate + ", joiningFees=" + joiningFees + ", subscriptionFees=" + subscriptionFees
				+ ", allowableDiscount=" + allowableDiscount + ", notes=" + notes + "]";
	}

}
