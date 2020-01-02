package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "USER_DETAILS")
@SequenceGenerator(sequenceName = "SEQ_USER_DETAILS", initialValue = 1, allocationSize = 1, name = "SEQ_USER_DETAILS")
public class PortalUserDetails extends AuditDetails {

	@Id
	@GeneratedValue(generator = "SEQ_USER_DETAILS", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "USER_NAME")
	private String username;

	@Column(name = "PASSWORD")
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
