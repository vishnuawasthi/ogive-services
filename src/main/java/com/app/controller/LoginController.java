package com.app.controller;

import java.util.HashSet;
import java.util.Set;

import javax.mail.MessagingException;
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

import com.app.dto.EmailDetailDTO;
import com.app.dto.UserDetailsDTO;
import com.app.services.EmailService;
import com.app.services.LoginService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class LoginController {

	private static final Logger log = Logger.getLogger(LoginController.class);

	@Autowired
	private LoginService loginService;

	@Autowired
	private EmailService emailService;

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

		// emailService.sendEmail("Test email", "Hello world",
		// "vishnuawasthi121@gmail.com", "vishnu.awasthi.dev9@gmail.com");

		EmailDetailDTO emailDetailDTO = new EmailDetailDTO();

		emailDetailDTO.setSignature("Vishnu Awasthi");

		Set<String> toEmails = new HashSet<String>();
		toEmails.add("vishnuawasthi121@gmail.com");
		emailDetailDTO.setToEmails(toEmails);

		emailDetailDTO.setSubject("Welcome to team");
		emailDetailDTO.setBodyText(
				"Now we’ll add a table with three rows for our main content–one for the headline, one for the introductory text, and one for the row with two columns. We’ll set the width of this table to 100% rather than using a pixel value because this will help us further down the track if we want to make our email responsive. If you always have pixel widths on everything, you can end up with a lot of values to override with media queries. If your nested table widths are based on percentages, then when you adjust the width of the parent element, everything will adapt accordingly");

		Set<String> ccEmails = new HashSet<String>();
		ccEmails.add("vishnuawasthi121@gmail.com");

		emailDetailDTO.setCcEmails(ccEmails);

		try {
			emailService.sendEmailWithHtmlTemplate(emailDetailDTO);
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		return new ResponseEntity<UserDetailsDTO>(userDetailsDTO, HttpStatus.OK);

	}

	@ApiOperation(value = "Creates user in the system", response = Long.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Resource created successfully"),
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
