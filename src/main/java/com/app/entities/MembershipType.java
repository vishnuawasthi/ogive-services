package com.app.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.app.constants.MembershipTypeStatus;

@Entity
@Table(name = "MEMBERSHIP_TYPES")
@SequenceGenerator(sequenceName = "SEQ_MEMBERSHIP_TYPES", initialValue = 1, allocationSize = 1, name = "SEQ_MEMBERSHIP_TYPES")
public class MembershipType {

	@Id
	@GeneratedValue(generator = "SEQ_MEMBERSHIP_TYPES", strategy = GenerationType.SEQUENCE)
	private Long id;

	private String membershipTypeName;

	private String description;

	private Float duration;

	private Float minimuHours;

	private Float maximumHours;

	private Date effectiveDate;

	private Float joiningFees;

	private Float subscriptionFees;

	private Float allowedDiscount;

	private String notes;

	@Enumerated(EnumType.STRING)
	private MembershipTypeStatus status;

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "BUSINESS_UNIT_DETAILS_ID", referencedColumnName = "ID")
	private BusinessUnitDetails businessUnitDetails;

	@OneToOne
	@JoinColumn(name = "MBR_PKG_DTLS_ID", referencedColumnName = "ID")
	private PackageDetails membershipPackageDetails;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public BusinessUnitDetails getBusinessUnitDetails() {
		return businessUnitDetails;
	}

	public void setBusinessUnitDetails(BusinessUnitDetails businessUnitDetails) {
		this.businessUnitDetails = businessUnitDetails;
	}

	public PackageDetails getMembershipPackageDetails() {
		return membershipPackageDetails;
	}

	public void setMembershipPackageDetails(PackageDetails membershipPackageDetails) {
		this.membershipPackageDetails = membershipPackageDetails;
	}

	public MembershipTypeStatus getStatus() {
		return status;
	}

	public void setStatus(MembershipTypeStatus status) {
		this.status = status;
	}

}
