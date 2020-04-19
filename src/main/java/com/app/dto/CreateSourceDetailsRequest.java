package com.app.dto;

import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModelProperty;

public class CreateSourceDetailsRequest {

	@NotEmpty
	@ApiModelProperty(required = true)
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
