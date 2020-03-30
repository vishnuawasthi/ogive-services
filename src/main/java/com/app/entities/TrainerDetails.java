package com.app.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TRAINER_DETAILS")
@SequenceGenerator(sequenceName = "SEQ_TRAINER_DETAILS", initialValue = 1, allocationSize = 1, name = "SEQ_TRAINER_DETAILS")
public class TrainerDetails {

	@Id
	@GeneratedValue(generator = "SEQ_TRAINER_DETAILS", strategy = GenerationType.SEQUENCE)
	private Long id;

	private String trainerCode;

	private String trainerName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTrainerCode() {
		return trainerCode;
	}

	public void setTrainerCode(String trainerCode) {
		this.trainerCode = trainerCode;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	@Override
	public String toString() {
		return "TrainerDetails [id=" + id + ", trainerCode=" + trainerCode + ", trainerName=" + trainerName + "]";
	}

}
