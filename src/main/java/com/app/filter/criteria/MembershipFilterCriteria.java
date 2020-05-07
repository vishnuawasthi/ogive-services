package com.app.filter.criteria;

public class MembershipFilterCriteria {

	private Long memberId;
	private Long membershipId;
	private String firstName;
	private String lastName;
	private String fieldName;
	private String sortOrder;

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public Long getMembershipId() {
		return membershipId;
	}

	public void setMembershipId(Long membershipId) {
		this.membershipId = membershipId;
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

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

	public MembershipFilterCriteria(Long memberId, Long membershipId, String firstName, String lastName,
			String fieldName, String sortOrder) {
		super();
		this.memberId = memberId;
		this.membershipId = membershipId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.fieldName = fieldName;
		this.sortOrder = sortOrder;
	}

}
