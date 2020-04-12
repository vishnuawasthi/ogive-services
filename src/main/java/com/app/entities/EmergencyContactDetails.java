package com.app.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "EMERG_CTC_DTLS")
@SequenceGenerator(sequenceName = "SEQ_EMERG_CTC_DTLS", initialValue = 1, allocationSize = 1, name = "SEQ_EMERG_CTC_DTLS")
public class EmergencyContactDetails {

	@Id
	@GeneratedValue(generator = "SEQ_EMERG_CTC_DTLS", strategy = GenerationType.SEQUENCE)
	private Long id;

	private String contactName;

	private String address;

	private String relationship;

	private String contactNumber;
	
	@OneToOne(mappedBy = "emergencyContactDetails")
	private MemberDetails memberDetails;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public MemberDetails getMemberDetails() {
		return memberDetails;
	}

	public void setMemberDetails(MemberDetails memberDetails) {
		this.memberDetails = memberDetails;
	}

	@Override
	public String toString() {
		return "EmergencyContactDetails [id=" + id + ", contactName=" + contactName + ", address=" + address
				+ ", relationship=" + relationship + ", contactNumber=" + contactNumber + ", memberDetails="
				+ memberDetails + "]";
	}
	
	

}
