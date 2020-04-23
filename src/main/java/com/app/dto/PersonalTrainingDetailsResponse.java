package com.app.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class PersonalTrainingDetailsResponse {

	private Long id;

	private String description;

	private Float duration;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date startDate;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
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

	/*
	 * @ApiModelProperty(required = true) private Long personalTrainingType;
	 * 
	 * @ApiModelProperty(required = true) private Long membershipId;
	 * 
	 * @ApiModelProperty(required = true) private Long trainerId;
	 * 
	 * @ApiModelProperty(required = true) private Long advisorId;
	 * 
	 * @ApiModelProperty(required = true) private Long companyOrBusinessUnit;
	 * 
	 */

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
	
	

}
