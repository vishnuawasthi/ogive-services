package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.app.constants.Authorities;

@Entity
@Table(name = "USER_AUTHORITY")
@SequenceGenerator(sequenceName = "SEQ_USER_AUTHORITY", initialValue = 1, allocationSize = 1, name = "SEQ_USER_AUTHORITY")
public class UserAuthority {

	@Id
	@GeneratedValue(generator = "SEQ_USER_AUTHORITY", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "AUTHORITY_NAME")
	@Enumerated(EnumType.STRING)
	private Authorities authority;

	@Column(name = "DESCRIPTION")
	private String description;

	@ManyToOne()
	@JoinColumn(name = "USER_DETAILS_SEQ_NO")
	private PortalUserDetails portalUserDetails;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Authorities getAuthority() {
		return authority;
	}

	public void setAuthority(Authorities authority) {
		this.authority = authority;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
