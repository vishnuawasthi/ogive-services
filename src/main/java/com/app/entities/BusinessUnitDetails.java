package com.app.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "BUSINESS_UNIT_DETAILS")
@SequenceGenerator(sequenceName = "SEQ_BUSINESS_UNIT_DETAILS", initialValue = 1, allocationSize = 1, name = "SEQ_BUSINESS_UNIT_DETAILS")
public class BusinessUnitDetails {

	@Id
	@GeneratedValue(generator = "SEQ_BUSINESS_UNIT_DETAILS", strategy = GenerationType.SEQUENCE)
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

	
}
