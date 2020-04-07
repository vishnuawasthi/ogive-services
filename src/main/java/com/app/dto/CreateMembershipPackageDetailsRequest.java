package com.app.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MembershipPackageDetails")
public class CreateMembershipPackageDetailsRequest {

	@NotEmpty
	@ApiModelProperty(required = true)
	private String packageCode;

	private String description;

	@NotEmpty
	@ApiModelProperty(required = true)
	private String companyOrBusinessUnitCode;

	private List<PackageSpecificationDetailsRequest> packageSpecificationDetails;

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

	public List<PackageSpecificationDetailsRequest> getPackageSpecificationDetails() {
		return packageSpecificationDetails;
	}

	public void setPackageSpecificationDetails(List<PackageSpecificationDetailsRequest> packageSpecificationDetails) {
		this.packageSpecificationDetails = packageSpecificationDetails;
	}

	@Override
	public String toString() {
		return "CreateMembershipPackageDetailsRequest [packageCode=" + packageCode + ", description=" + description
				+ ", companyOrBusinessUnitCode=" + companyOrBusinessUnitCode + ", packageSpecificationDetails="
				+ packageSpecificationDetails + "]";
	}

}
