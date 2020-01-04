package com.app.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.UserDetailsDTO;
import com.app.services.LoginService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class LoginController {

	private static final Logger log = Logger.getLogger(LoginController.class);

	@Autowired
	private LoginService loginService;

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

	@ApiOperation(value = "Creates user in the system", response = Long.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Resource created successfully"),
			@ApiResponse(code = 401, message = "You are not authorized to perform the operation"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@PostMapping(value = "api/v1/users", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object saveUserDetails(@RequestBody @Valid UserDetailsDTO userDetailsDTO) {
		log.info("Request Body :  {} " + userDetailsDTO);
		Long Id = loginService.saveUser(userDetailsDTO);
		return new ResponseEntity<Long>(Id, HttpStatus.OK);

	}

}
