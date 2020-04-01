package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.EmailDetailDTO;
import com.app.dto.PortalUserDetailsRequest;
import com.app.dto.PortalUserDetailsResponse;
import com.app.services.PortalOperationService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/admin-api")
public class WellnessManagementAdminController {

	private static final Logger log = Logger.getLogger(WellnessManagementAdminController.class);

	@Autowired
	private PortalOperationService portalOperationService;

	@ApiOperation(value = "This service suspends an existing user", tags = "Admin operations", response = Long.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Account suspended successfully"),
			@ApiResponse(code = 401, message = "You are not authorized to perform the operation"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@GetMapping(value = "/v1/users/suspend-account", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object suspendAccount() {
		System.out.println("suspendAccount() - start");

		EmailDetailDTO emailDetailDTO = new EmailDetailDTO();
		emailDetailDTO.setSubject("Api call response");

		System.out.println("suspendAccount() - end");
		return new ResponseEntity<EmailDetailDTO>(emailDetailDTO, HttpStatus.OK);

	}

	/***************** PORTAL USER SERVICES **********************/

	@ApiOperation(value = "Create a user in the system", tags = "Admin operations")
	@PostMapping(value = "/v1/portal-users", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object regiserPortalUSer(@RequestBody @Valid PortalUserDetailsRequest portalUserDetailsRequest) {
		log.info("regiserPortalUSer ()- start");
		log.info("Request Body :  {} " + portalUserDetailsRequest);
		Long id = portalOperationService.savePortalUserDetails(portalUserDetailsRequest);
		log.info("memberRegistration ()- end");
		return new ResponseEntity<Long>(id, HttpStatus.OK);
	}

	@ApiOperation(value = "This service used to update the details of an existing user. It accept updatable fields in body and those are firestname, lastname, email, contactNumber", tags = "Admin operations", response = PortalUserDetailsResponse.class)
	@PutMapping(value = "/v1/portal-users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object updatePortalUserDetails(@PathVariable("id") Long id,
			@RequestBody @Valid PortalUserDetailsRequest portalUserDetailsRequest) {
		log.info("updatePortalUserDetails ()- start");
		log.info("Request Body :  {} " + portalUserDetailsRequest);
		PortalUserDetailsResponse portalUserDetailsResponse = portalOperationService.updatePortalUserDetails(id,
				portalUserDetailsRequest);
		log.info("updatePortalUserDetails ()- end");
		return new ResponseEntity<PortalUserDetailsResponse>(portalUserDetailsResponse, HttpStatus.OK);
	}

	@ApiOperation(value = "Get all the portal users.It will give all the existing users,It only fetches active users. for active users isEnabled should be Y", tags = "Admin operations", response = List.class)
	@GetMapping(value = "/v1/portal-users", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getAllPortalUsers() {
		log.info("getAllPortalUsers ()- start");
		List<PortalUserDetailsResponse> portalUserDetailsList = portalOperationService.getAllPortalUsers();
		log.info("getAllPortalUsers ()- end");
		return new ResponseEntity<List<PortalUserDetailsResponse>>(portalUserDetailsList, HttpStatus.OK);
	}

	@ApiOperation(value = "Get portal user by id", tags = "Admin operations", response = PortalUserDetailsResponse.class)
	@GetMapping(value = "/v1/portal-users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getPortalUsersById(@PathVariable(name = "id") Long id) {
		log.info("getPortalUsersById ()- start");
		PortalUserDetailsResponse responseObject = portalOperationService.getPortalUserById(id);
		log.info("getPortalUsersById ()- end");
		return new ResponseEntity<PortalUserDetailsResponse>(responseObject, HttpStatus.OK);
	}

}
