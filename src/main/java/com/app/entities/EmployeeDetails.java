package com.app.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE_DETAILS")
@SequenceGenerator(sequenceName = "SEQ_EMPLOYEE_DETAILS", initialValue = 1, allocationSize = 1, name = "SEQ_EMPLOYEE_DETAILS")
public class EmployeeDetails {

	@Id
	@GeneratedValue(generator = "SEQ_EMPLOYEE_DETAILS", strategy = GenerationType.SEQUENCE)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
