package com.app.dto;

public class OrderDetailsData {

	private Long id;

	private String orderType;

	private Double totalAmount;

	private Double discountRate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Double getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(Double discountRate) {
		this.discountRate = discountRate;
	}

	@Override
	public String toString() {
		return "OrderDetailsData [id=" + id + ", orderType=" + orderType + ", totalAmount=" + totalAmount
				+ ", discountRate=" + discountRate + "]";
	}

	
	
}
