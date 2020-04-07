package com.app.dto;

import java.util.List;

public class MembershipPackageDetailsResponse {

	private Long id;
	private String packageCode;

	private String description;

	private String companyOrBusinessUnitCode;

	List<PackageSpecificationDetailsResponse> packageSpecificationDetails;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPackageCode() {
		return packageCode;
	}

	public void setPackageCode(String packageCode) {
		this.packageCode = packageCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCompanyOrBusinessUnitCode() {
		return companyOrBusinessUnitCode;
	}

	public void setCompanyOrBusinessUnitCode(String companyOrBusinessUnitCode) {
		this.companyOrBusinessUnitCode = companyOrBusinessUnitCode;
	}

	public List<PackageSpecificationDetailsResponse> getPackageSpecificationDetails() {
		return packageSpecificationDetails;
	}

	public void setPackageSpecificationDetails(List<PackageSpecificationDetailsResponse> packageSpecificationDetails) {
		this.packageSpecificationDetails = packageSpecificationDetails;
	}

}
