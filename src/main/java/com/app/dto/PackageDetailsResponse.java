package com.app.dto;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class PackageDetailsResponse {

	private Long id;

	private String packageName;

	private String description;

	@ApiModelProperty(required = true)
	private Long companyOrBusinessUnit;

	private List<PackageSpecificationDetailsResponse> packageSpecificationDetails;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getCompanyOrBusinessUnit() {
		return companyOrBusinessUnit;
	}

	public void setCompanyOrBusinessUnit(Long companyOrBusinessUnit) {
		this.companyOrBusinessUnit = companyOrBusinessUnit;
	}

	public List<PackageSpecificationDetailsResponse> getPackageSpecificationDetails() {
		return packageSpecificationDetails;
	}

	public void setPackageSpecificationDetails(List<PackageSpecificationDetailsResponse> packageSpecificationDetails) {
		this.packageSpecificationDetails = packageSpecificationDetails;
	}

}
