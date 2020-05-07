package com.app.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.app.constants.StaffType;

@Entity
@Table(name = "STAFF_DETAILS")
@SequenceGenerator(sequenceName = "SEQ_STAFF_DETAILS", initialValue = 1, allocationSize = 1, name = "SEQ_STAFF_DETAILS")
public class StaffDetails {

	@Id
	@GeneratedValue(generator = "SEQ_STAFF_DETAILS", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(length = 32)
	private String firstName;;

	@Column(length = 32)
	private String lastName;

	@Column(length = 32)
	private String middleName;

	@Column(length = 15)
	private String mobileNumber;

	@Column(length = 60)
	private String email;

	@Column
	private Date joiningDate;

	@Enumerated(EnumType.STRING)
	@Column(name = "staff_type", length = 32)
	private StaffType staffType;

	@OneToOne
	@JoinColumn(name = "BUSINESS_UNIT_DTLS_ID", referencedColumnName = "ID")
	private BusinessUnitDetails businessUnitDetails;

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

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public BusinessUnitDetails getBusinessUnitDetails() {
		return businessUnitDetails;
	}

	public void setBusinessUnitDetails(BusinessUnitDetails businessUnitDetails) {
		this.businessUnitDetails = businessUnitDetails;
	}

	@Override
	public String toString() {
		return "StaffDetails [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", middleName="
				+ middleName + ", mobileNumber=" + mobileNumber + ", email=" + email + ", joiningDate=" + joiningDate
				+ ", staffType=" + staffType + ", businessUnitDetails=" + businessUnitDetails + "]";
	}

}
