package com.app.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PACKAGE_DTLS")
@SequenceGenerator(sequenceName = "SEQ_PACKAGE_DTLS", initialValue = 10, allocationSize = 1,name = "SEQ_PACKAGE_DTLS")
public class PackageDetails {

	@Id
	@GeneratedValue(generator = "SEQ_PACKAGE_DTLS", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private String description;
	
	@Column(length=250)
	private String packageName;

	@OneToOne
	@JoinColumn(name = "BUSINESS_UNIT_ID", referencedColumnName = "ID")
	private BusinessUnitDetails businessUnitDetails;

	@OneToMany(mappedBy = "membershipPackageDetails", fetch = FetchType.EAGER)
	Set<PackageSpecificationDetails> packageSpecificationDetails = new HashSet<PackageSpecificationDetails>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<PackageSpecificationDetails> getPackageSpecificationDetails() {
		return packageSpecificationDetails;
	}

	public void setPackageSpecificationDetails(Set<PackageSpecificationDetails> packageSpecificationDetails) {
		this.packageSpecificationDetails = packageSpecificationDetails;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public BusinessUnitDetails getBusinessUnitDetails() {
		return businessUnitDetails;
	}

	public void setBusinessUnitDetails(BusinessUnitDetails businessUnitDetails) {
		this.businessUnitDetails = businessUnitDetails;
	}

}
