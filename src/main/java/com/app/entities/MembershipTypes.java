package com.app.entities;

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

	private String description;

	private String membershipType;

	private String duration;

	private float minimumHours;

	private float maximumHours;

	private float joiningFees;

	private String subscriptionFees;

	private float allowedDiscount;

	private String enableRecurringPayment;

	private String companyOrBusinessUnitName;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMembershipType() {
		return membershipType;
	}

	public void setMembershipType(String membershipType) {
		this.membershipType = membershipType;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public float getMinimumHours() {
		return minimumHours;
	}

	public void setMinimumHours(float minimumHours) {
		this.minimumHours = minimumHours;
	}

	public float getMaximumHours() {
		return maximumHours;
	}

	public void setMaximumHours(float maximumHours) {
		this.maximumHours = maximumHours;
	}

	public float getJoiningFees() {
		return joiningFees;
	}

	public void setJoiningFees(float joiningFees) {
		this.joiningFees = joiningFees;
	}

	public String getSubscriptionFees() {
		return subscriptionFees;
	}

	public void setSubscriptionFees(String subscriptionFees) {
		this.subscriptionFees = subscriptionFees;
	}

	public float getAllowedDiscount() {
		return allowedDiscount;
	}

	public void setAllowedDiscount(float allowedDiscount) {
		this.allowedDiscount = allowedDiscount;
	}

	public String getEnableRecurringPayment() {
		return enableRecurringPayment;
	}

	public void setEnableRecurringPayment(String enableRecurringPayment) {
		this.enableRecurringPayment = enableRecurringPayment;
	}

	public String getCompanyOrBusinessUnitName() {
		return companyOrBusinessUnitName;
	}

	public void setCompanyOrBusinessUnitName(String companyOrBusinessUnitName) {
		this.companyOrBusinessUnitName = companyOrBusinessUnitName;
	}

	@Override
	public String toString() {
		return "MembershipTypes [id=" + id + ", membershipTypeCode=" + membershipTypeCode + ", description="
				+ description + ", membershipType=" + membershipType + ", duration=" + duration + ", minimumHours="
				+ minimumHours + ", maximumHours=" + maximumHours + ", joiningFees=" + joiningFees
				+ ", subscriptionFees=" + subscriptionFees + ", allowedDiscount=" + allowedDiscount
				+ ", enableRecurringPayment=" + enableRecurringPayment + ", companyOrBusinessUnitName="
				+ companyOrBusinessUnitName + "]";
	}

}
