package com.app.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class MembershipTypeResponse {

	private Long id;

	@ApiModelProperty(required = true)
	private String membershipTypeCode;

	private String membershipType;

	@ApiModelProperty(required = true)
	private String description;

	@ApiModelProperty(required = true)
	private Float duration;

	private Float minimuHours;

	private Float maximumHours;

	private String enableRecurringPayment;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@ApiModelProperty(required = false, allowableValues = "yyyy-MM-dd")
	private Date effectiveDate;

	private Float joiningFees;

	private Float subscriptionFees;

	private Float allowedDiscount;

	private String companyOrBusinessUnitName;

	private String notes;

	public MembershipTypeResponse() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMembershipTypeCode() {
		return membershipTypeCode;
	}

	public void setMembershipTypeCode(String membershipTypeCode) {
		this.membershipTypeCode = membershipTypeCode;
	}

	public String getMembershipType() {
		return membershipType;
	}

	public void setMembershipType(String membershipType) {
		this.membershipType = membershipType;
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

	public Float getAllowedDiscount() {
		return allowedDiscount;
	}

	public void setAllowedDiscount(Float allowedDiscount) {
		this.allowedDiscount = allowedDiscount;
	}

	public String getCompanyOrBusinessUnitName() {
		return companyOrBusinessUnitName;
	}

	public void setCompanyOrBusinessUnitName(String companyOrBusinessUnitName) {
		this.companyOrBusinessUnitName = companyOrBusinessUnitName;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "MembershipTypeResponse [id=" + id + ", membershipTypeCode=" + membershipTypeCode + ", membershipType="
				+ membershipType + ", description=" + description + ", duration=" + duration + ", minimuHours="
				+ minimuHours + ", maximumHours=" + maximumHours + ", enableRecurringPayment=" + enableRecurringPayment
				+ ", effectiveDate=" + effectiveDate + ", joiningFees=" + joiningFees + ", subscriptionFees="
				+ subscriptionFees + ", allowedDiscount=" + allowedDiscount + ", companyOrBusinessUnitName="
				+ companyOrBusinessUnitName + ", notes=" + notes + "]";
	}

}
