package com.app.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
public class CreatePersonalTrainingTypeRequest {

	private String personalTrainingType;

	@ApiModelProperty(required = true)
	@NotEmpty
	private String personalTrainingCode;

	@ApiModelProperty(required = true)
	@NotEmpty
	private String description;

	private String companyOrBusinessUnitCode;

	@NotNull
	@ApiModelProperty(required = true)
	private Float duration;

	private Integer extraSessions;

	private Integer allowedSessions;

	@ApiModelProperty(required = true, example = "15")
	@NotEmpty
	private Integer validityInDays;

	private String enableRecurringPayment;

	private Date effectiveDate;

	private Float joiningFees;

	private Float subscriptionFees;

	private Float allowableDiscount;

	private String notes;

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
		return "CreatePersonalTrainingTypeRequest [personalTrainingType=" + personalTrainingType
				+ ", personalTrainingCode=" + personalTrainingCode + ", description=" + description
				+ ", companyOrBusinessUnitCode=" + companyOrBusinessUnitCode + ", duration=" + duration
				+ ", extraSessions=" + extraSessions + ", allowedSessions=" + allowedSessions + ", validityInDays="
				+ validityInDays + ", enableRecurringPayment=" + enableRecurringPayment + ", effectiveDate="
				+ effectiveDate + ", joiningFees=" + joiningFees + ", subscriptionFees=" + subscriptionFees
				+ ", allowableDiscount=" + allowableDiscount + ", notes=" + notes + "]";
	}

}
