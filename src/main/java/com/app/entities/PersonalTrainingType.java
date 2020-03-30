package com.app.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PERSONAL_TRAINING_TYPES")
@SequenceGenerator(sequenceName = "SEQ_PERSONAL_TRAINING_TYPES", initialValue = 1, allocationSize = 1, name = "SEQ_PERSONAL_TRAINING_TYPES")
public class PersonalTrainingType {

	@Id
	@GeneratedValue(generator = "SEQ_PERSONAL_TRAINING_TYPES", strategy = GenerationType.SEQUENCE)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

	
}
