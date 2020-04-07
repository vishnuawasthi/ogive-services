package com.app.dto;

import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModelProperty;

public class CreateStaffDetailsRequest {

	@NotEmpty
	@ApiModelProperty(required = true)
	private String staffTypeCode;

	@NotEmpty
	@ApiModelProperty(required = true)
	private String employeeCode;

	@NotEmpty
	@ApiModelProperty(required = true)
	private String employeeName;

	private String designation;

	private String joiningDate;

	private Float basicSalary;

	private Float grossSalary;

	private Float ratePerHour;

	public String getStaffTypeCode() {
		return staffTypeCode;
	}

	public void setStaffTypeCode(String staffTypeCode) {
		this.staffTypeCode = staffTypeCode;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}

	public Float getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(Float basicSalary) {
		this.basicSalary = basicSalary;
	}

	public Float getGrossSalary() {
		return grossSalary;
	}

	public void setGrossSalary(Float grossSalary) {
		this.grossSalary = grossSalary;
	}

	public Float getRatePerHour() {
		return ratePerHour;
	}

	public void setRatePerHour(Float ratePerHour) {
		this.ratePerHour = ratePerHour;
	}

	@Override
	public String toString() {
		return "CreateStaffDetailsRequest [staffTypeCode=" + staffTypeCode + ", employeeCode=" + employeeCode
				+ ", employeeName=" + employeeName + ", designation=" + designation + ", joiningDate=" + joiningDate
				+ ", basicSalary=" + basicSalary + ", grossSalary=" + grossSalary + ", ratePerHour=" + ratePerHour
				+ "]";
	}

}
