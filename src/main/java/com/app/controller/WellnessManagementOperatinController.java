package com.app.controller;

import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ErrorResponseEntity;
import com.app.dto.MemberDetailsResponse;
import com.app.dto.MemberRegistrationRequest;
import com.app.services.EmailService;
import com.app.services.PortalOperationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/api")
public class WellnessManagementOperatinController {

	private static final Logger log = Logger.getLogger(WellnessManagementOperatinController.class);

	@Autowired
	private PortalOperationService loginService;

	@Autowired
	private EmailService emailService;

	/*@ApiOperation(value = "Creates user in the system", tags = "User Operations", response = Long.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Resource created successfully"),
			@ApiResponse(code = 401, message = "You are not authorized to perform the operation"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@PostMapping(value = "/v1/users", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object saveUserDetails(@RequestBody @Valid MemberRegistrationRequest userRegistrationRequest) {
		log.info("Request Body :  {} " + userRegistrationRequest);
		Long Id = loginService.saveUserDetails(userRegistrationRequest);
		return new ResponseEntity<Long>(Id, HttpStatus.OK);
	}
*/
	/*@ApiOperation(value = "Get user by id", tags = "User Operations", response = MemberRegistrationRequest.class)
	@GetMapping(value = "/v1/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getUserById(@PathVariable(required = true, name = "id") Long id) {
		log.info("Path id  :  {} " + id);
		MemberRegistrationRequest userDetailsDTO = loginService.getUserById(id);
		return new ResponseEntity<MemberRegistrationRequest>(userDetailsDTO, HttpStatus.OK);
	}*/

	@GetMapping(value = "/v1/users/accessDenied", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object accessDeniedHandler(@RequestParam("authentication") Authentication authentication) {
		ErrorResponseEntity errorEntity = new ErrorResponseEntity();
		if (Objects.nonNull(authentication)) {
			errorEntity.setDescription(authentication.getName() + " is not allowed to access the resource");
			errorEntity.setStatus("403- Access Denied");
		}
		return new ResponseEntity<ErrorResponseEntity>(errorEntity, HttpStatus.OK);
	}
	
	/**
	 * Membership Api
	 */
	
	@ApiOperation(value = "Enroll for membership", tags = "Membership Operation ", response = Long.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Resource created successfully"),
			@ApiResponse(code = 401, message = "You are not authorized to perform the operation"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@PostMapping(value = "/v1/memberships", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object memberRegistration(@RequestBody @Valid MemberRegistrationRequest memberRegistrationRequest) {
		log.info("memberRegistration ()- start");
		log.info("Request Body :  {} " + memberRegistrationRequest);
		Long id = loginService.saveMembershipDetails(memberRegistrationRequest);
		log.info("memberRegistration ()- end");
		return new ResponseEntity<Long>(id, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get all memberships present in the system", tags = "Membership Operation ", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Fetch completed successfully"),
			@ApiResponse(code = 401, message = "You are not authorized to perform the operation"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden")})
	@GetMapping(value = "/v1/memberships", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getAllMemberships() {
		log.info("getAllMemberships ()- start");
		List<MemberDetailsResponse> allMemberShips = loginService.getAllMemberShips();
		log.info("getAllMemberships ()- stop");
		return new ResponseEntity<List<MemberDetailsResponse>>(allMemberShips, HttpStatus.OK);
	}


}
