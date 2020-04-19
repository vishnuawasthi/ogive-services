package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "SOURCE_DETAILS")
@SequenceGenerator(sequenceName = "SEQ_SOURCE_DETAILS", initialValue = 10, allocationSize = 1, name = "SEQ_SOURCE_DETAILS")
public class SourceDetails {

	@Id
	@GenericGenerator(name = "SOURCE_ID", strategy = "com.app.id.generator.SourceDetailsIdGenerator")
	@GeneratedValue(generator = "SOURCE_ID")
	@Column(name = "ID")
	private String id;

	private String description;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
