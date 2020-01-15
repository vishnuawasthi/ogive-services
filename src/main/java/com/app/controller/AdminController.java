package com.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.EmailDetailDTO;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/admin-api")
public class AdminController {

	@ApiOperation(value = "This api suspends an existing user", tags = "Admin operations", response = Long.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Account suspended successfully"),
			@ApiResponse(code = 401, message = "You are not authorized to perform the operation"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	
	@GetMapping(value = "/v1/users/suspend-account", produces = MediaType.APPLICATION_JSON_VALUE)
	public  Object suspendAccount() {
		System.out.println("suspendAccount() - start");

		
		EmailDetailDTO emailDetailDTO = new EmailDetailDTO();
		emailDetailDTO.setSubject("Api call response");
		
		System.out.println("suspendAccount() - end");
		return new ResponseEntity<EmailDetailDTO>(emailDetailDTO, HttpStatus.OK);

	}

}
