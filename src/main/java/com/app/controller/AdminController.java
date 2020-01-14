package com.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin-api")
public class AdminController {

	@GetMapping(value = "/v1/users/suspend-account", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object suspendAccount() {
		System.out.println("suspendAccount() - start");

		
		System.out.println("suspendAccount() - end");
		return new ResponseEntity<String>("Acccount has been suspended successfully", HttpStatus.OK);

	}

}
