package com.app.dto;

public class PackageSpecificationDetailsRequest {

	private String specificationName;

	private Integer periodNumber;

	private Float unit;

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
		return "PackageSpecificationDetailsRequest [specificationName=" + specificationName + ", periodNumber="
				+ periodNumber + ", unit=" + unit + "]";
	}

}
