package com.app.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PERSONAL_TRAINING_DTL")
@SequenceGenerator(sequenceName = "SEQ_PERSONAL_TRAINING_DTL", initialValue = 1, allocationSize = 1, name = "SEQ_PERSONAL_TRAINING_DTL")
public class PersonalTrainingDetail {

	@Id
	@GeneratedValue(generator = "SEQ_PERSONAL_TRAINING_DTL", strategy = GenerationType.SEQUENCE)
	private Long id;

	/** ############### PERSONAL TRAINING DETAILS ####################### */
	private String description;
	private Float duration;

	private Date startDate;
	private Date endDate;
	private Integer extraSessions;
	private Integer totalSessions;

	private Float joiningFee;
	private Float subscriptionFee;
	private Float discount;
	private Float totalFee;

	private String corporateCode;
	private String corporateName;

	private String notes;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "PERSONAL_TRAINING_TYPE_ID", referencedColumnName = "ID")
	private PersonalTrainingType personalTrainingType;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "MEMBERSHIP_DETAILS_ID", referencedColumnName = "ID")
	private MembershipDetails membershipDetails;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "TRAINER_ID", referencedColumnName = "ID")
	private StaffDetails trainerDetails;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ADVISOR_ID", referencedColumnName = "ID")
	private StaffDetails advisorDetails;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "BUSINESS_UNIT_DETAILS_ID", referencedColumnName = "ID")
	private BusinessUnitDetails businessUnitDetails;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getExtraSessions() {
		return extraSessions;
	}

	public void setExtraSessions(Integer extraSessions) {
		this.extraSessions = extraSessions;
	}

	public Integer getTotalSessions() {
		return totalSessions;
	}

	public void setTotalSessions(Integer totalSessions) {
		this.totalSessions = totalSessions;
	}

	public Float getJoiningFee() {
		return joiningFee;
	}

	public void setJoiningFee(Float joiningFee) {
		this.joiningFee = joiningFee;
	}

	public Float getSubscriptionFee() {
		return subscriptionFee;
	}

	public void setSubscriptionFee(Float subscriptionFee) {
		this.subscriptionFee = subscriptionFee;
	}

	public Float getDiscount() {
		return discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

	public Float getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(Float totalFee) {
		this.totalFee = totalFee;
	}

	public String getCorporateCode() {
		return corporateCode;
	}

	public void setCorporateCode(String corporateCode) {
		this.corporateCode = corporateCode;
	}

	public String getCorporateName() {
		return corporateName;
	}

	public void setCorporateName(String corporateName) {
		this.corporateName = corporateName;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public PersonalTrainingType getPersonalTrainingType() {
		return personalTrainingType;
	}

	public void setPersonalTrainingType(PersonalTrainingType personalTrainingType) {
		this.personalTrainingType = personalTrainingType;
	}

	public MembershipDetails getMembershipDetails() {
		return membershipDetails;
	}

	public void setMembershipDetails(MembershipDetails membershipDetails) {
		this.membershipDetails = membershipDetails;
	}

	public StaffDetails getTrainerDetails() {
		return trainerDetails;
	}

	public void setTrainerDetails(StaffDetails trainerDetails) {
		this.trainerDetails = trainerDetails;
	}

	public StaffDetails getAdvisorDetails() {
		return advisorDetails;
	}

	public void setAdvisorDetails(StaffDetails advisorDetails) {
		this.advisorDetails = advisorDetails;
	}

	public BusinessUnitDetails getBusinessUnitDetails() {
		return businessUnitDetails;
	}

	public void setBusinessUnitDetails(BusinessUnitDetails businessUnitDetails) {
		this.businessUnitDetails = businessUnitDetails;
	}

}
