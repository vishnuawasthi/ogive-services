package com.app.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class CreatePersonalTrainingTypeRequest {

	@ApiModelProperty(required = true)
	@NotEmpty
	private String personalTrainingTypeName;

	@ApiModelProperty(required = true)
	@NotEmpty
	private String description;

	@ApiModelProperty(required = true)
	@NotNull
	private Long companyOrBusinessUnit;

	@NotNull
	@ApiModelProperty(required = true)
	private Float duration;

	private Integer extraSessions;

	private Integer allowedSessions;

	@ApiModelProperty(required = true, example = "15")
	@NotNull
	private Integer validityInDays;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@ApiModelProperty(required = false, allowableValues = "yyyy-MM-dd")
	private Date effectiveDate;

	private Float joiningFees;

	private Float subscriptionFees;

	@ApiModelProperty(required = true)
	@NotNull
	private Float allowableDiscount;

	private String notes;

	public String getPersonalTrainingTypeName() {
		return personalTrainingTypeName;
	}

	public void setPersonalTrainingTypeName(String personalTrainingTypeName) {
		this.personalTrainingTypeName = personalTrainingTypeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getCompanyOrBusinessUnit() {
		return companyOrBusinessUnit;
	}

	public void setCompanyOrBusinessUnit(Long companyOrBusinessUnit) {
		this.companyOrBusinessUnit = companyOrBusinessUnit;
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
		return "CreatePersonalTrainingTypeRequest [personalTrainingTypeName=" + personalTrainingTypeName
				+ ", description=" + description + ", companyOrBusinessUnit=" + companyOrBusinessUnit + ", duration="
				+ duration + ", extraSessions=" + extraSessions + ", allowedSessions=" + allowedSessions
				+ ", validityInDays=" + validityInDays + ", effectiveDate=" + effectiveDate + ", joiningFees="
				+ joiningFees + ", subscriptionFees=" + subscriptionFees + ", allowableDiscount=" + allowableDiscount
				+ ", notes=" + notes + "]";
	}

}
