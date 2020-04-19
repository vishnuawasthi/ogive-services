package com.app.dto;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MembershipPackageDetails")
public class CreatePackageDetailsRequest {

	@NotEmpty
	@ApiModelProperty(required = true)
	private String packageName;

	private String description;

	@NotNull
	@ApiModelProperty(required = true)
	private Long companyOrBusinessUnit;

	@Valid
	private List<PackageSpecificationDetailsRequest> packageSpecificationDetails;

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

	public List<PackageSpecificationDetailsRequest> getPackageSpecificationDetails() {
		return packageSpecificationDetails;
	}

	public void setPackageSpecificationDetails(List<PackageSpecificationDetailsRequest> packageSpecificationDetails) {
		this.packageSpecificationDetails = packageSpecificationDetails;
	}

}
