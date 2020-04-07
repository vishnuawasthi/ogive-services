package com.app.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "MEMBERSHIP_TYPES")
@SequenceGenerator(sequenceName = "SEQ_MEMBERSHIP_TYPES", initialValue = 1, allocationSize = 1, name = "SEQ_MEMBERSHIP_TYPES")
public class MembershipTypes {

	@Id
	@GeneratedValue(generator = "SEQ_MEMBERSHIP_TYPES", strategy = GenerationType.SEQUENCE)
	private Long id;

	private String membershipTypeCode;

	private String membershipType;

	private String description;

	private Float duration;

	private Float minimuHours;

	private Float maximumHours;

	private String enableRecurringPayment;

	private Date effectiveDate;

	private Float joiningFees;

	private Float subscriptionFees;

	private Float allowedDiscount;

	private String companyOrBusinessUnitCode;

	private String notes;

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

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getCompanyOrBusinessUnitCode() {
		return companyOrBusinessUnitCode;
	}

	public void setCompanyOrBusinessUnitCode(String companyOrBusinessUnitCode) {
		this.companyOrBusinessUnitCode = companyOrBusinessUnitCode;
	}

	@Override
	public String toString() {
		return "MembershipTypes [id=" + id + ", membershipTypeCode=" + membershipTypeCode + ", membershipType="
				+ membershipType + ", description=" + description + ", duration=" + duration + ", minimuHours="
				+ minimuHours + ", maximumHours=" + maximumHours + ", enableRecurringPayment=" + enableRecurringPayment
				+ ", effectiveDate=" + effectiveDate + ", joiningFees=" + joiningFees + ", subscriptionFees="
				+ subscriptionFees + ", allowedDiscount=" + allowedDiscount + ", companyOrBusinessUnitCode="
				+ companyOrBusinessUnitCode + ", notes=" + notes + "]";
	}

}
