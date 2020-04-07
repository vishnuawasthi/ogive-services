package com.app.dto;

import io.swagger.annotations.ApiModelProperty;

public class StaffDetailsResponse {

	@ApiModelProperty(required = true)
	private Long id;

	@ApiModelProperty(required = true)
	private String staffTypeCode;

	@ApiModelProperty(required = true)
	private String employeeCode;
	
	@ApiModelProperty(required = true)
	private String employeeName;

	private String designation;

	private String joiningDate;

	private Float basicSalary;

	private Float grossSalary;

	private Float ratePerHour;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
		return "StaffDetailsResponse [id=" + id + ", staffTypeCode=" + staffTypeCode + ", employeeCode=" + employeeCode
				+ ", employeeName=" + employeeName + ", designation=" + designation + ", joiningDate=" + joiningDate
				+ ", basicSalary=" + basicSalary + ", grossSalary=" + grossSalary + ", ratePerHour=" + ratePerHour
				+ "]";
	}

}
