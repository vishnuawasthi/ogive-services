package com.app.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PERSONAL_TRAINING_TYPES")
@SequenceGenerator(sequenceName = "SEQ_PERSONAL_TRAINING_TYPES", initialValue = 1, allocationSize = 1, name = "SEQ_PERSONAL_TRAINING_TYPES")
public class PersonalTrainingType {

	@Id
	@GeneratedValue(generator = "SEQ_PERSONAL_TRAINING_TYPES", strategy = GenerationType.SEQUENCE)
	private Long id;

	private String personalTrainingType;

	private String personalTrainingCode;

	private String description;

	private String companyOrBusinessUnitCode;

	private Float duration;

	private Integer extraSessions;

	private Integer allowedSessions;

	private Integer validityInDays;

	private String enableRecurringPayment;

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
		return "PersonalTrainingType [id=" + id + ", personalTrainingType=" + personalTrainingType
				+ ", personalTrainingCode=" + personalTrainingCode + ", description=" + description
				+ ", companyOrBusinessUnitCode=" + companyOrBusinessUnitCode + ", duration=" + duration
				+ ", extraSessions=" + extraSessions + ", allowedSessions=" + allowedSessions + ", validityInDays="
				+ validityInDays + ", enableRecurringPayment=" + enableRecurringPayment + ", effectiveDate="
				+ effectiveDate + ", joiningFees=" + joiningFees + ", subscriptionFees=" + subscriptionFees
				+ ", allowableDiscount=" + allowableDiscount + ", notes=" + notes + "]";
	}

}
