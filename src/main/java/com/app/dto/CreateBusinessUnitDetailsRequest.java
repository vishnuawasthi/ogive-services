package com.app.dto;

import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModelProperty;

public class CreateBusinessUnitDetailsRequest {

	private String businessUnitCode;

	@NotEmpty
	@ApiModelProperty(required = true)
	private String businessUnitName;

	private String addressLine1;

	private String addressLine2;

	@NotEmpty
	@ApiModelProperty(required = true)
	private String postOfficeBox;

	@NotEmpty
	@ApiModelProperty(required = true)
	private String city;

	@NotEmpty
	@ApiModelProperty(required = true)
	private String state;

	@NotEmpty
	@ApiModelProperty(required = true)
	private String countryCode;

	public String getBusinessUnitCode() {
		return businessUnitCode;
	}

	public void setBusinessUnitCode(String businessUnitCode) {
		this.businessUnitCode = businessUnitCode;
	}

	public String getBusinessUnitName() {
		return businessUnitName;
	}

	public void setBusinessUnitName(String businessUnitName) {
		this.businessUnitName = businessUnitName;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getPostOfficeBox() {
		return postOfficeBox;
	}

	public void setPostOfficeBox(String postOfficeBox) {
		this.postOfficeBox = postOfficeBox;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

}
