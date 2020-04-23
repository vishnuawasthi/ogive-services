package com.app.dto;

import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModelProperty;

public class ResetPasswordRequest {

	@ApiModelProperty(required = true)
	@NotEmpty()
	private String username;

	@ApiModelProperty(required = true)
	@NotEmpty()
	private String password;

	@NotEmpty()
	@ApiModelProperty(required = true)
	private String newPassword;

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

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

}
