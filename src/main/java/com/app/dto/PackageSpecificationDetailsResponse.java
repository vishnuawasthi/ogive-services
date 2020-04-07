package com.app.dto;

public class PackageSpecificationDetailsResponse {

	private Long id;

	private String specificationName;

	private Integer periodNumber;

	private Float unit;

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

	@Override
	public String toString() {
		return "PackageSpecificationDetailsResponse [id=" + id + ", specificationName=" + specificationName
				+ ", periodNumber=" + periodNumber + ", unit=" + unit + "]";
	}

}
