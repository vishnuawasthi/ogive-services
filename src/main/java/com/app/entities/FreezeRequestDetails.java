package com.app.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "FREEZE_REQ_DETAILS")
@SequenceGenerator(sequenceName = "SEQ_FREEZE_REQ_DETAILS", initialValue = 1, allocationSize = 1, name = "SEQ_FREEZE_REQ_DETAILS")
public class FreezeRequestDetails {

	@Id
	@GeneratedValue(generator = "SEQ_FREEZE_REQ_DETAILS", strategy = GenerationType.SEQUENCE)
	private Long id;

	private Long membershipId;

	private Date requestDate;

	private Date startDate;

	private Date endDate;

	private String reason;

	private String notes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMembershipId() {
		return membershipId;
	}

	public void setMembershipId(Long membershipId) {
		this.membershipId = membershipId;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
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

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "FreezeRequestDetails [id=" + id + ", membershipId=" + membershipId + ", requestDate=" + requestDate
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", reason=" + reason + ", notes=" + notes + "]";
	}

}
