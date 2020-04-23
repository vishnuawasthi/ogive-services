package com.app.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PERSONAL_TRAINING_TYPE")
@SequenceGenerator(sequenceName = "SEQ_PERSONAL_TRAINING_TYPE", initialValue = 1, allocationSize = 1, name = "SEQ_PERSONAL_TRAINING_TYPE")
public class PersonalTrainingType {

	@Id
	@GeneratedValue(generator = "SEQ_PERSONAL_TRAINING_TYPE", strategy = GenerationType.SEQUENCE)
	private Long id;

	private String personalTrainingTypeName;

	private String description;

	private Float duration;

	private Integer extraSessions;

	private Integer allowedSessions;

	private Integer validityInDays;

	private Date effectiveDate;

	private Float joiningFees;

	private Float subscriptionFees;

	private Float allowableDiscount;

	private String notes;

	@ManyToOne
	@JoinColumn(name = "BUSINESS_UNIT_ID", referencedColumnName = "ID")
	private BusinessUnitDetails businessUnitDetails;

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

	public BusinessUnitDetails getBusinessUnitDetails() {
		return businessUnitDetails;
	}

	public void setBusinessUnitDetails(BusinessUnitDetails businessUnitDetails) {
		this.businessUnitDetails = businessUnitDetails;
	}

}
