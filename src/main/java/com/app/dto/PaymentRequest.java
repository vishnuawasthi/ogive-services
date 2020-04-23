package com.app.dto;

import java.util.Date;

import com.app.constants.PaymentTypes;
import com.sun.istack.NotNull;

import io.swagger.annotations.ApiModelProperty;

public class PaymentRequest {

	@NotNull
	@ApiModelProperty(required = true, example = "CARD,CASH,CHECK")
	private PaymentTypes paymentType;

	private Float paidAmount;

	private Float dueAmount;

	// Check Details
	private String checkNumber;

	private Date checkDate;

	private String bank;

	// Card Details
	private String cardNumber;

	// Common for all
	private Float amount;

	public PaymentTypes getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentTypes paymentType) {
		this.paymentType = paymentType;
	}

	public Float getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(Float paidAmount) {
		this.paidAmount = paidAmount;
	}

	public Float getDueAmount() {
		return dueAmount;
	}

	public void setDueAmount(Float dueAmount) {
		this.dueAmount = dueAmount;
	}

	public String getCheckNumber() {
		return checkNumber;
	}

	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}

	public Date getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

}
