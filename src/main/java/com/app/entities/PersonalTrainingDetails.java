package com.app.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PRSN_TRN_DTLS")
@SequenceGenerator(sequenceName = "SEQ_PRSN_TRN_DTLS", initialValue = 1, allocationSize = 1, name = "SEQ_PRSN_TRN_DTLS")
public class PersonalTrainingDetails {

	@Id
	@GeneratedValue(generator = "SEQ_PRSN_TRN_DTLS", strategy = GenerationType.SEQUENCE)
	private Long id;

	// MEMBERSHIP DETAILS
	// TODO - Can we just establish relationship between membership and personal
	// training instead of creating field ?
	private Long membershipNumber;

	private String membershipTypeCode;

	private String firstName;

	private String lastName;

	private String mobileNumber;

	private String companyOrBusinessUnit;

	private Date joiningDate;

	private Date expireDate;

	/** ############### PERSONAL TRAINING DETAILS ####################### */

	private String type;
	private String personalTrainingCode;
	private String description;
	private String referenceNumber;
	private Float duration;

	private Date startDate;
	private Date endDate;
	private String startTime;
	private String endTime;
	private Integer extraSessions;
	private Integer totalSessions;

	private String trainerCode;
	private String trainerName;
	private Float joiningFees;
	private Float subscriptionFees;
	private Float grossTotal;

	private String advisorCode;
	private String advisorName;
	private String corporateCode;
	private String corporateName;
	private Float netAmount;
	private String notes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMembershipNumber() {
		return membershipNumber;
	}

	public void setMembershipNumber(Long membershipNumber) {
		this.membershipNumber = membershipNumber;
	}

	public String getMembershipTypeCode() {
		return membershipTypeCode;
	}

	public void setMembershipTypeCode(String membershipTypeCode) {
		this.membershipTypeCode = membershipTypeCode;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getCompanyOrBusinessUnit() {
		return companyOrBusinessUnit;
	}

	public void setCompanyOrBusinessUnit(String companyOrBusinessUnit) {
		this.companyOrBusinessUnit = companyOrBusinessUnit;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
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

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
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

	public String getTrainerCode() {
		return trainerCode;
	}

	public void setTrainerCode(String trainerCode) {
		this.trainerCode = trainerCode;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
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

	public Float getGrossTotal() {
		return grossTotal;
	}

	public void setGrossTotal(Float grossTotal) {
		this.grossTotal = grossTotal;
	}

	public String getAdvisorCode() {
		return advisorCode;
	}

	public void setAdvisorCode(String advisorCode) {
		this.advisorCode = advisorCode;
	}

	public String getAdvisorName() {
		return advisorName;
	}

	public void setAdvisorName(String advisorName) {
		this.advisorName = advisorName;
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

	public Float getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(Float netAmount) {
		this.netAmount = netAmount;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "PersonalTrainingDetails [id=" + id + ", membershipNumber=" + membershipNumber + ", membershipTypeCode="
				+ membershipTypeCode + ", firstName=" + firstName + ", lastName=" + lastName + ", mobileNumber="
				+ mobileNumber + ", companyOrBusinessUnit=" + companyOrBusinessUnit + ", joiningDate=" + joiningDate
				+ ", expireDate=" + expireDate + ", type=" + type + ", personalTrainingCode=" + personalTrainingCode
				+ ", description=" + description + ", referenceNumber=" + referenceNumber + ", duration=" + duration
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", startTime=" + startTime + ", endTime="
				+ endTime + ", extraSessions=" + extraSessions + ", totalSessions=" + totalSessions + ", trainerCode="
				+ trainerCode + ", trainerName=" + trainerName + ", joiningFees=" + joiningFees + ", subscriptionFees="
				+ subscriptionFees + ", grossTotal=" + grossTotal + ", advisorCode=" + advisorCode + ", advisorName="
				+ advisorName + ", corporateCode=" + corporateCode + ", corporateName=" + corporateName + ", netAmount="
				+ netAmount + ", notes=" + notes + "]";
	}

}
