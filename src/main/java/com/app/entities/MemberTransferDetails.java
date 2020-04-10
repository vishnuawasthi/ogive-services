package com.app.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "MBR_TRANS_DTLS")
@SequenceGenerator(sequenceName = "SEQ_MBR_TRANS_DTLS", initialValue = 1, allocationSize = 1, name = "SEQ_MBR_TRANS_DTLS")
public class MemberTransferDetails {

	@Id
	@GeneratedValue(generator = "SEQ_MBR_TRANS_DTLS", strategy = GenerationType.SEQUENCE)
	private Long id;

	private Long memberNumber;

	private Long fromCompanyOrBusinessUnit;

	private Long toCompanyOrBusinessUnit;

	private String reasonForTransfer;

	private Date transferDate;

	private Long transferFromMembership;

	private Long transferToMembership;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(Long memberNumber) {
		this.memberNumber = memberNumber;
	}

	public String getReasonForTransfer() {
		return reasonForTransfer;
	}

	public void setReasonForTransfer(String reasonForTransfer) {
		this.reasonForTransfer = reasonForTransfer;
	}

	public Long getFromCompanyOrBusinessUnit() {
		return fromCompanyOrBusinessUnit;
	}

	public void setFromCompanyOrBusinessUnit(Long fromCompanyOrBusinessUnit) {
		this.fromCompanyOrBusinessUnit = fromCompanyOrBusinessUnit;
	}

	public Long getToCompanyOrBusinessUnit() {
		return toCompanyOrBusinessUnit;
	}

	public void setToCompanyOrBusinessUnit(Long toCompanyOrBusinessUnit) {
		this.toCompanyOrBusinessUnit = toCompanyOrBusinessUnit;
	}

	public Date getTransferDate() {
		return transferDate;
	}

	public void setTransferDate(Date transferDate) {
		this.transferDate = transferDate;
	}

	public Long getTransferToMembership() {
		return transferToMembership;
	}

	public void setTransferToMembership(Long transferToMembership) {
		this.transferToMembership = transferToMembership;
	}

	public Long getTransferFromMembership() {
		return transferFromMembership;
	}

	public void setTransferFromMembership(Long transferFromMembership) {
		this.transferFromMembership = transferFromMembership;
	}

	@Override
	public String toString() {
		return "MemberTransferDetails [id=" + id + ", memberNumber=" + memberNumber + ", fromCompanyOrBusinessUnit="
				+ fromCompanyOrBusinessUnit + ", toCompanyOrBusinessUnit=" + toCompanyOrBusinessUnit
				+ ", reasonForTransfer=" + reasonForTransfer + ", transferDate=" + transferDate
				+ ", transferFromMembership=" + transferFromMembership + ", transferToMembership="
				+ transferToMembership + "]";
	}

}
