package com.app.dto;

import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModelProperty;

public class CreateCountryDetailsRequest {

	@ApiModelProperty(required = true)
	@NotEmpty
	private String countryName;

	@ApiModelProperty(required = true)
	@NotEmpty
	private String countryCode;

	@ApiModelProperty(required = true)
	@NotEmpty
	private String nationality;

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	@Override
	public String toString() {
		return "CreateCountryDetailsRequest [countryName=" + countryName + ", countryCode=" + countryCode
				+ ", nationality=" + nationality + "]";
	}

}
