package com.app.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class UpdateMembershipTypeRequest {

	private String membershipTypeName;

	private String description;

	private Float duration;

	private Float minimuHours;

	private Float maximumHours;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@ApiModelProperty(required = false, allowableValues = "yyyy-MM-dd")
	private Date effectiveDate;

	private Float joiningFees;

	private Float subscriptionFees;

	private Float allowedDiscount;

	private Long companyOrBusinessUnit;

	private String notes;

	public String getMembershipTypeName() {
		return membershipTypeName;
	}

	public void setMembershipTypeName(String membershipTypeName) {
		this.membershipTypeName = membershipTypeName;
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

	public Float getMinimuHours() {
		return minimuHours;
	}

	public void setMinimuHours(Float minimuHours) {
		this.minimuHours = minimuHours;
	}

	public Float getMaximumHours() {
		return maximumHours;
	}

	public void setMaximumHours(Float maximumHours) {
		this.maximumHours = maximumHours;
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

	public Float getAllowedDiscount() {
		return allowedDiscount;
	}

	public void setAllowedDiscount(Float allowedDiscount) {
		this.allowedDiscount = allowedDiscount;
	}

	public Long getCompanyOrBusinessUnit() {
		return companyOrBusinessUnit;
	}

	public void setCompanyOrBusinessUnit(Long companyOrBusinessUnit) {
		this.companyOrBusinessUnit = companyOrBusinessUnit;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}
