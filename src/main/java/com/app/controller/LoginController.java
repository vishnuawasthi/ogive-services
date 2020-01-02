package com.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.UserDetailsDTO;

@RestController
public class LoginController {

	@GetMapping(value = "/")
	public Object hellowWorld() {

		return "Hello world!!!!!!!!!!!!!!!";
	}

	@GetMapping(value = "api/v1/users", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getUserDetails() {

		UserDetailsDTO userDetailsDTO = new UserDetailsDTO();
		userDetailsDTO.setEmail("vishnuawasthi121@gmail.com");
		userDetailsDTO.setPassword("Secrete@12345");
		userDetailsDTO.setUserId(Long.valueOf("12345"));
		userDetailsDTO.setUsername("admin@api.com");

		return new ResponseEntity<UserDetailsDTO>(userDetailsDTO, HttpStatus.OK);

	}

}
