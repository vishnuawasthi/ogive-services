package com.app.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "MBR_PKG_DTLS")
@SequenceGenerator(sequenceName = "SEQ_MBR_PKG_DTLS", initialValue = 1, allocationSize = 1, name = "SEQ_MBR_PKG_DTLS")
public class MembershipPackageDetails {

	@Id
	@GeneratedValue(generator = "SEQ_MBR_PKG_DTLS", strategy = GenerationType.SEQUENCE)
	private Long id;

	private String packageCode;

	private String description;

	private String companyOrBusinessUnitCode;

	@OneToMany(mappedBy="membershipPackageDetails",fetch = FetchType.EAGER)
	Set<PackageSpecificationDetails> packageSpecificationDetails = new HashSet<PackageSpecificationDetails>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPackageCode() {
		return packageCode;
	}

	public void setPackageCode(String packageCode) {
		this.packageCode = packageCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCompanyOrBusinessUnitCode() {
		return companyOrBusinessUnitCode;
	}

	public void setCompanyOrBusinessUnitCode(String companyOrBusinessUnitCode) {
		this.companyOrBusinessUnitCode = companyOrBusinessUnitCode;
	}

	public Set<PackageSpecificationDetails> getPackageSpecificationDetails() {
		return packageSpecificationDetails;
	}

	public void setPackageSpecificationDetails(Set<PackageSpecificationDetails> packageSpecificationDetails) {
		this.packageSpecificationDetails = packageSpecificationDetails;
	}

	@Override
	public String toString() {
		return "MembershipPackageDetails [id=" + id + ", packageCode=" + packageCode + ", description=" + description
				+ ", companyOrBusinessUnitCode=" + companyOrBusinessUnitCode + ", packageSpecificationDetails="
				+ packageSpecificationDetails + "]";
	}

}
