package com.app.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PKG_SPEC_DTLS")
@SequenceGenerator(sequenceName = "SEQ_PKG_SPEC_DTLS", initialValue = 1, allocationSize = 1, name = "SEQ_PKG_SPEC_DTLS")
public class PackageSpecificationDetails {

	@Id
	@GeneratedValue(generator = "SEQ_PKG_SPEC_DTLS", strategy = GenerationType.SEQUENCE)
	private Long id;

	private String specificationName;

	private Integer periodNumber;

	private Float unit;

	@ManyToOne()
	@JoinColumn(name = "MBR_PKG_DTLS_ID")
	private MembershipPackageDetails membershipPackageDetails;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSpecificationName() {
		return specificationName;
	}

	public void setSpecificationName(String specificationName) {
		this.specificationName = specificationName;
	}

	public Integer getPeriodNumber() {
		return periodNumber;
	}

	public void setPeriodNumber(Integer periodNumber) {
		this.periodNumber = periodNumber;
	}

	public Float getUnit() {
		return unit;
	}

	public void setUnit(Float unit) {
		this.unit = unit;
	}

	public MembershipPackageDetails getMembershipPackageDetails() {
		return membershipPackageDetails;
	}

	public void setMembershipPackageDetails(MembershipPackageDetails membershipPackageDetails) {
		this.membershipPackageDetails = membershipPackageDetails;
	}

	@Override
	public String toString() {
		return "PackageSpecificationDetails [id=" + id + ", specificationName=" + specificationName + ", periodNumber="
				+ periodNumber + ", unit=" + unit + ", membershipPackageDetails=" + membershipPackageDetails + "]";
	}

}
