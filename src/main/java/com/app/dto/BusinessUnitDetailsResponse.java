package com.app.dto;

public class BusinessUnitDetailsResponse {

	private Long id;

	private String businessUnitCode;

	private String businessUnitName;

	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "BusinessUnitDetailsResponse [id=" + id + ", businessUnitCode=" + businessUnitCode
				+ ", businessUnitName=" + businessUnitName + ", description=" + description + "]";
	}

}
