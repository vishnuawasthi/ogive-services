package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.MembershipDetailsResponse;
import com.app.dto.PersonalTrainingDetailsResponse;
import com.app.dto.UpdateMemberDetailRequest;
import com.app.services.MemberOperationService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/members-api")
@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
		@ApiResponse(code = 401, message = "You are not authorized to perform the operation"),
		@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
		@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
public class WellnessManagementMemberOperationController {

	private static final Logger log = LoggerFactory.getLogger(WellnessManagementMemberOperationController.class);

	@Autowired
	private MemberOperationService memberOperationService;
	
	@ApiOperation(value = "Get all the membership of a member", tags = "Member Operations - Memberships", response = List.class)
	@GetMapping(value = "/v1/members/{id}/memberships", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getAllMembershipDetailsByMemberId(@PathVariable("id") Long id) {
		
		log.info("getAllMembershipDetailsByMemberId ()- start");
		List<MembershipDetailsResponse> allMemberships = memberOperationService.loadMembershipDetailByMemberId(id);
		log.info("getAllMembershipDetailsByMemberId ()- end");
		return new ResponseEntity<List<MembershipDetailsResponse>>(allMemberships, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get membership detail of a member by member id and membership id", tags = "Member Operations - Memberships", response = List.class)
	@GetMapping(value = "/v1/members/{id}/memberships/{membershipNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getMembershipDetailsByMemberIdAndMembershipNumber(@PathVariable("id") Long id,
			@PathVariable("membershipNumber") Long membershipNumber) {
		log.info("getMembershipDetailsByMemberIdAndMembershipNumber ()- start");
		
		MembershipDetailsResponse membershipDetails = memberOperationService
				.loadMembershipDetailByMemberIdAndMembershipNumber(id, membershipNumber);
		log.info("getMembershipDetailsByMemberIdAndMembershipNumber ()- end");
		return new ResponseEntity<MembershipDetailsResponse>(membershipDetails, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get all the personal trainings of a member", tags = "Member Operations - Personal Trainings", response = PersonalTrainingDetailsResponse.class)
	@GetMapping(value = "/v1/members/{id}/personal-trainings", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getPersonalTraingByMemberId(@PathVariable("id") Long id) {
		log.info("getAllPersonalTraining ()- start");
		
		List<PersonalTrainingDetailsResponse> listOfPersonalTrainings = memberOperationService.getPersonalTrainingsByMemberId(id);
		log.info("getAllPersonalTraining ()- end");
		return new ResponseEntity<List<PersonalTrainingDetailsResponse>>(listOfPersonalTrainings, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get all the personal trainings of a member", tags = "Member Operations - Personal Trainings", response = PersonalTrainingDetailsResponse.class)
	@GetMapping(value = "/v1/members/{id}/personal-trainings/{trainingId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getPersonalTraingByMemberId(@PathVariable("id") Long id,
			@PathVariable("trainingId") Long trainingId) {
		log.info("getPersonalTraingByMemberId ()- start");

		PersonalTrainingDetailsResponse personalTraining = memberOperationService
				.getPersonalTrainingsByMemberIdAndId(id, trainingId);

		log.info("getPersonalTraingByMemberId ()- end");
		return new ResponseEntity<PersonalTrainingDetailsResponse>(personalTraining, HttpStatus.OK);
	}

	@ApiOperation(value = "Update personal information of a member", tags = "Member Operations - Update Personal Information")
	@PutMapping(value = "/v1/members/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object updateMemberDetails(@PathVariable("id") Long id,
			@Valid @RequestBody UpdateMemberDetailRequest request) {
		log.info("updateMemberDetails ()- start");
		memberOperationService.updateMemberDetails(id, request);
		log.info("updateMemberDetails ()- end");
		return new ResponseEntity<>(HttpStatus.OK);
	}

	
}
