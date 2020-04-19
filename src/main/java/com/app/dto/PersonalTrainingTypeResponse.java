package com.app.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class PersonalTrainingTypeResponse {

	@ApiModelProperty(required = true)
	private Long id;

	private String personalTrainingTypeName;

	@ApiModelProperty(required = true)
	private String description;

	@ApiModelProperty(required = true)
	private Float duration;

	private Integer extraSessions;

	private Integer allowedSessions;

	@ApiModelProperty(required = true)
	private Integer validityInDays;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date effectiveDate;

	private Float joiningFees;

	private Float subscriptionFees;

	private Float allowableDiscount;

	private String notes;

	private Long companyOrBusinessUnit;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Long getCompanyOrBusinessUnit() {
		return companyOrBusinessUnit;
	}

	public void setCompanyOrBusinessUnit(Long companyOrBusinessUnit) {
		this.companyOrBusinessUnit = companyOrBusinessUnit;
	}

	@Override
	public String toString() {
		return "PersonalTrainingTypeResponse [id=" + id + ", personalTrainingTypeName=" + personalTrainingTypeName
				+ ", description=" + description + ", duration=" + duration + ", extraSessions=" + extraSessions
				+ ", allowedSessions=" + allowedSessions + ", validityInDays=" + validityInDays + ", effectiveDate="
				+ effectiveDate + ", joiningFees=" + joiningFees + ", subscriptionFees=" + subscriptionFees
				+ ", allowableDiscount=" + allowableDiscount + ", notes=" + notes + ", companyOrBusinessUnit="
				+ companyOrBusinessUnit + "]";
	}

}
