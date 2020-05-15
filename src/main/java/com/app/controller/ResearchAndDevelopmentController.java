package com.app.controller;

import java.util.HashSet;
import java.util.Set;

import javax.mail.MessagingException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.EmailDetailDTO;
import com.app.services.EmailService;
import com.app.services.PortalAdminOperationService;
import com.app.services.SMSService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
public class ResearchAndDevelopmentController {

	private static final Logger log = Logger.getLogger(ResearchAndDevelopmentController.class);

	@Autowired
	private PortalAdminOperationService loginService;

	@Autowired
	private EmailService emailService;
	
	@Autowired
	private SMSService smsService;

	@ApiOperation(value="Print Hello", tags = "Research And Development")
	@GetMapping(value = "/v1/hello")
	public Object hellowWorld() {
		return "Hello world!!!!!!!!!!!!!!!";
	}

	@ApiOperation(value="Send Email", tags = "Research And Development")
	@GetMapping(value = "/v1/users/send-email", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getUserDetails() {

		EmailDetailDTO emailDetailDTO = new EmailDetailDTO();

		emailDetailDTO.setSignature("Vishnu Awasthi");

		Set<String> toEmails = new HashSet<String>();
		toEmails.add("vishnuawasthi121@gmail.com");
		emailDetailDTO.setToEmails(toEmails);

		emailDetailDTO.setSubject("Welcome to team");

		emailDetailDTO.setBodyText("Now we’ll add a table with three rows for our main content–one for the headline, "
				+ " one for the introductory text, and one for the row with two columns. "
				+ " We’ll set the width of this table to 100% rather than using a pixel "
				+ " value because this will help us further down the track if we want to make our email responsive."
				+ " If you always have pixel widths on everything,"
				+ " you can end up with a lot of values to override with media queries."
				+ " If your nested table widths are based on percentages, then when you adjust the width of the parent element, "
				+ "everything will adapt accordingly");

		Set<String> ccEmails = new HashSet<String>();
		ccEmails.add("vishnuawasthi121@gmail.com");

		emailDetailDTO.setCcEmails(ccEmails);

		try {
			emailService.sendEmailWithHtmlTemplate(emailDetailDTO);
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		return new ResponseEntity<String>("Email send successfully", HttpStatus.OK);

	}
	
	@ApiOperation(value = "Send Message", tags = "Research And Development")
	@GetMapping(value = "/v1/messages", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object sendMessage(
			@RequestParam(required = true, name = "message") String message,
			@RequestParam(required = true, name = "number") String number) {
		String responseBody = smsService.sendSMS(number, message);
		return new ResponseEntity<String>(responseBody, HttpStatus.OK);

	}
	
}
