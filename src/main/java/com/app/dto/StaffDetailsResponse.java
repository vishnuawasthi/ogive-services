package com.app.dto;

import java.util.Date;

import com.app.constants.StaffType;
import com.fasterxml.jackson.annotation.JsonFormat;

public class StaffDetailsResponse {

	private Long id;
	private String firstName;

	private String lastName;

	private String middleName;

	private String email;

	private String mobileNumber;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date joiningDate;

	private StaffType staffType;

	private Long companyOrBusinessUnit;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public StaffType getStaffType() {
		return staffType;
	}

	public void setStaffType(StaffType staffType) {
		this.staffType = staffType;
	}

	public Long getCompanyOrBusinessUnit() {
		return companyOrBusinessUnit;
	}

	public void setCompanyOrBusinessUnit(Long companyOrBusinessUnit) {
		this.companyOrBusinessUnit = companyOrBusinessUnit;
	}

	@Override
	public String toString() {
		return "StaffDetailsResponse [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", middleName=" + middleName + ", email=" + email + ", mobileNumber=" + mobileNumber
				+ ", joiningDate=" + joiningDate + ", staffType=" + staffType + ", companyOrBusinessUnit="
				+ companyOrBusinessUnit + "]";
	}

}
