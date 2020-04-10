package com.app.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class CreateMemberTransferRequest {

	@NotNull
	@ApiModelProperty(required = true)
	private Long memberNumber;

	@NotNull
	@ApiModelProperty(required = true)
	private Long fromCompanyOrBusinessUnit;

	@NotNull
	@ApiModelProperty(required = true)
	private Long toCompanyOrBusinessUnit;

	@NotNull
	@ApiModelProperty(required = true)
	private String reasonForTransfer;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@ApiModelProperty(required = true, example = "yyyy-MM-dd")
	private Date transferDate;

	// private Long transferToMembership;

	public Long getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(Long memberNumber) {
		this.memberNumber = memberNumber;
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

	public String getReasonForTransfer() {
		return reasonForTransfer;
	}

	public void setReasonForTransfer(String reasonForTransfer) {
		this.reasonForTransfer = reasonForTransfer;
	}

	public Date getTransferDate() {
		return transferDate;
	}

	public void setTransferDate(Date transferDate) {
		this.transferDate = transferDate;
	}

	@Override
	public String toString() {
		return "CreateMemberTransferRequest [memberNumber=" + memberNumber + ", fromCompanyOrBusinessUnit="
				+ fromCompanyOrBusinessUnit + ", toCompanyOrBusinessUnit=" + toCompanyOrBusinessUnit
				+ ", reasonForTransfer=" + reasonForTransfer + ", transferDate=" + transferDate + "]";
	}

}
