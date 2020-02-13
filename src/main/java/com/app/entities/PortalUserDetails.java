package com.app.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "IS_ACCOUNT_LOCKED", length = 1, nullable = false)
	private String isAcccountLocked = "N";

	@Column(name = "IS_ENABLED", length = 1, nullable = false)
	private String isEnabled = "N";

	@Column(name = "FIRST_NAME")
	private String firstname;

	@Column(name = "LAST_NAME")
	private String lastname;

	@Column(name = "MIDDLE_NAME")
	private String middlename;

	@Column(name = "GENDER")
	private String gender;

	@Column(name = "DATE_OF_BIRTH")
	private Date dateOfBirth;

	@Column(name = "CONTACT_NO")
	private String contactNumber;

	@Column(name = "ALT_CONTACT_NO")
	private String alternateContactNumber;

	/**
	 * TODO - Need to explore on it as got below error 2020-01-13 10:20:11 -
	 * o.a.c.c.C.[.[.[.[dispatcherServlet] - Servlet.service() for servlet
	 * [dispatcherServlet] in context with path [] threw exception
	 * org.hibernate.LazyInitializationException: failed to lazily initialize a
	 * collection of role: com.app.entities.PortalUserDetails.authorities, could not
	 * initialize proxy - no Session at
	 * org.hibernate.collection.internal.AbstractPersistentCollection.throwLazyInitializationException(AbstractPersistentCollection.java:606)
	 * at
	 * org.hibernate.collection.internal.AbstractPersistentCollection.withTemporarySessionIfNeeded(AbstractPersistentCollection.java:218)
	 * at
	 * org.hibernate.collection.internal.AbstractPersistentCollection.initialize(AbstractPersistentCollection.java:585)
	 * at
	 * org.hibernate.collection.internal.AbstractPersistentCollection.read(AbstractPersistentCollection.java:149)
	 * at org.hibernate.c
	 */
	@OneToMany(mappedBy = "portalUserDetails", fetch = FetchType.EAGER)
	Set<UserAuthority> authorities = new HashSet<UserAuthority>();

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

	public Set<UserAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<UserAuthority> authorities) {
		this.authorities = authorities;
	}

	public String getIsAcccountLocked() {
		return isAcccountLocked;
	}

	public void setIsAcccountLocked(String isAcccountLocked) {
		this.isAcccountLocked = isAcccountLocked;
	}

	public String getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(String isEnabled) {
		this.isEnabled = isEnabled;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getAlternateContactNumber() {
		return alternateContactNumber;
	}

	public void setAlternateContactNumber(String alternateContactNumber) {
		this.alternateContactNumber = alternateContactNumber;
	}

	@Override
	public String toString() {
		return "PortalUserDetails [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", isAcccountLocked=" + isAcccountLocked + ", isEnabled=" + isEnabled + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", middlename=" + middlename + ", gender=" + gender + ", dateOfBirth="
				+ dateOfBirth + ", contactNumber=" + contactNumber + ", alternateContactNumber="
				+ alternateContactNumber + ", authorities=" + authorities + ", getId()=" + getId() + ", getUsername()="
				+ getUsername() + ", getPassword()=" + getPassword() + ", getAuthorities()=" + getAuthorities()
				+ ", getIsAcccountLocked()=" + getIsAcccountLocked() + ", getIsEnabled()=" + getIsEnabled()
				+ ", getEmail()=" + getEmail() + ", getFirstname()=" + getFirstname() + ", getLastname()="
				+ getLastname() + ", getMiddlename()=" + getMiddlename() + ", getGender()=" + getGender()
				+ ", getDateOfBirth()=" + getDateOfBirth() + ", getContactNumber()=" + getContactNumber()
				+ ", getAlternateContactNumber()=" + getAlternateContactNumber() + ", getCreatedBy()=" + getCreatedBy()
				+ ", getUpdatedBy()=" + getUpdatedBy() + ", getCreatedDate()=" + getCreatedDate() + ", getUpatedDate()="
				+ getUpatedDate() + ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + "]";
	}

}
