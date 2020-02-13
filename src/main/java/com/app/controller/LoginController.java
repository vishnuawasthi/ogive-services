package com.app.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.UserDetailsDTO;
import com.app.services.EmailService;
import com.app.services.LoginService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/api")
public class LoginController {

	private static final Logger log = Logger.getLogger(LoginController.class);

	@Autowired
	private LoginService loginService;

	@Autowired
	private EmailService emailService;
	

	@ApiOperation(value = "Creates user in the system", tags="User Operations",response = Long.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Resource created successfully"),
			@ApiResponse(code = 401, message = "You are not authorized to perform the operation"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@PostMapping(value = "/v1/users", produces = MediaType.APPLICATION_JSON_VALUE)
	public  Object saveUserDetails(@RequestBody @Valid UserDetailsDTO userRegistrationRequest) {
		log.info("Request Body :  {} " + userRegistrationRequest);
		Long Id = loginService.saveUserDetails(userRegistrationRequest);
		return new ResponseEntity<Long>(Id, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get user by id", tags="User Operations",response = UserDetailsDTO.class)
	@GetMapping(value = "/v1/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public  Object getUserById(@PathVariable(required=true,name="id") Long id) {
		log.info("Path id  :  {} " + id);
		UserDetailsDTO  	userDetailsDTO = loginService.getUserById(id);
		return new ResponseEntity<UserDetailsDTO>(userDetailsDTO, HttpStatus.OK);
	}


}
