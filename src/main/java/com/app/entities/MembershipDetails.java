package com.app.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "MEMBERSHIP_DETAILS")
@SequenceGenerator(sequenceName = "SEQ_MEMBERSHIP_DETAILS", initialValue = 1, allocationSize = 1, name = "SEQ_MEMBERSHIP_DETAILS")
public class MembershipDetails {

	@Id
	@GeneratedValue(generator = "SEQ_MEMBERSHIP_DETAILS", strategy = GenerationType.SEQUENCE)
	private Long id;

	private String source;

	private String registrationType;

	private Float duration;

	private String accessCardNumber;

	@ApiModelProperty(required = true, allowableValues = "yyyy-MM-dd")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date registrationDate;

	@ApiModelProperty(required = true, allowableValues = "yyyy-MM-dd")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date joiningDate;

	@ApiModelProperty(required = true, allowableValues = "yyyy-MM-dd")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date startDate;

	@ApiModelProperty(required = true, allowableValues = "yyyy-MM-dd")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date expireDate;

	private String corporateCode;

	private String corporateName;

	// Fee Details
	private Float joiningFee;
	private Float subscriptionFee;
	private Float discount;
	private Float totalFee;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "MEMBER_DETAILS_ID", referencedColumnName = "ID")
	private MemberDetails memberDetails;

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "MEMBERSHIP_TYPE_ID", referencedColumnName = "ID")
	private MembershipType membershipTypes;

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "STAFF_DETAILS_ID", referencedColumnName = "ID")
	private StaffDetails staffDetails;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getRegistrationType() {
		return registrationType;
	}

	public void setRegistrationType(String registrationType) {
		this.registrationType = registrationType;
	}

	public Float getDuration() {
		return duration;
	}

	public void setDuration(Float duration) {
		this.duration = duration;
	}

	public String getAccessCardNumber() {
		return accessCardNumber;
	}

	public void setAccessCardNumber(String accessCardNumber) {
		this.accessCardNumber = accessCardNumber;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
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

	public MemberDetails getMemberDetails() {
		return memberDetails;
	}

	public void setMemberDetails(MemberDetails memberDetails) {
		this.memberDetails = memberDetails;
	}

	public MembershipType getMembershipTypes() {
		return membershipTypes;
	}

	public void setMembershipTypes(MembershipType membershipTypes) {
		this.membershipTypes = membershipTypes;
	}

	public StaffDetails getStaffDetails() {
		return staffDetails;
	}

	public void setStaffDetails(StaffDetails staffDetails) {
		this.staffDetails = staffDetails;
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
	
	

	@Override
	public String toString() {
		return "MembershipDetails [id=" + id + ", source=" + source + ", registrationType=" + registrationType
				+ ", duration=" + duration + ", accessCardNumber=" + accessCardNumber + ", registrationDate="
				+ registrationDate + ", joiningDate=" + joiningDate + ", startDate=" + startDate + ", expireDate="
				+ expireDate + ", corporateCode=" + corporateCode + ", corporateName=" + corporateName + ", joiningFee="
				+ joiningFee + ", subscriptionFee=" + subscriptionFee + ", discount=" + discount + ", totalFee="
				+ totalFee + ", memberDetails=" + memberDetails + ", membershipTypes=" + membershipTypes
				+ ", staffDetails=" + staffDetails + "]";
	}

}
