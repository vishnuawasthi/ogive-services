package com.app.controller;

import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CreateMemberTransferRequest;
import com.app.dto.CreateMembershipRequest;
import com.app.dto.CreatePaymentRequest;
import com.app.dto.CreatePersonalTrainingDetailRequest;
import com.app.dto.CreateProspectDetailsRequest;
import com.app.dto.ErrorResponseEntity;
import com.app.dto.MembershipPaymentDetailResponse;
import com.app.dto.MembershipResponse;
import com.app.dto.PersonalTrainingDetailsResponse;
import com.app.dto.ProspectDetailsResponse;
import com.app.services.EmailService;
import com.app.services.PaymentService;
import com.app.services.PortalAdminOperationService;
import com.app.services.PortalUserOperationService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/api")
@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
		@ApiResponse(code = 401, message = "You are not authorized to perform the operation"),
		@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
		@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
public class WellnessManagementUserOperationController {

	private static final Logger log = LoggerFactory.getLogger(WellnessManagementUserOperationController.class);

	@Autowired
	private PortalAdminOperationService loginService;

	@Autowired
	private EmailService emailService;
	
	@Autowired
	private PortalUserOperationService portalUserOperationService;
	
	@Autowired
	private PaymentService paymentService;

	@GetMapping(value = "/v1/users/accessDenied", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object accessDeniedHandler(@RequestParam("authentication") Authentication authentication) {
		ErrorResponseEntity errorEntity = new ErrorResponseEntity();
		if (Objects.nonNull(authentication)) {
			errorEntity.setDescription(authentication.getName() + " is not allowed to access the resource");
			errorEntity.setStatus("403- Access Denied");
		}
		return new ResponseEntity<ErrorResponseEntity>(errorEntity, HttpStatus.OK);
	}
	
	/** ##################### PROSPECT SERVICES ####################################### */
	
	@ApiOperation(value = "This api allow to create prospect.", tags = "User Operations - Prospect", response = Long.class)
	@PostMapping(value = "/v1/prospects", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object createProspects(@RequestBody @Valid CreateProspectDetailsRequest createProspectDetailsRequest) {
		log.info("createProspects ()- start");
		log.info("Request Body :  {} " + createProspectDetailsRequest);
		Long id = portalUserOperationService.createProspectDetails(createProspectDetailsRequest);
		log.info("createProspects ()- end");
		return new ResponseEntity<Long>(id, HttpStatus.OK);
	}
	
	@ApiOperation(value = "This api gives all the prospect available in the system", tags = "User Operations - Prospect", response = List.class)
	@GetMapping(value = "/v1/prospects", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getAllProspects() {
		log.info("getAllProspects ()- start");
		List<ProspectDetailsResponse> allProspects = portalUserOperationService.getAllProspects();
		log.info("getAllProspects ()- end");
		return new ResponseEntity<List<ProspectDetailsResponse>>(allProspects, HttpStatus.OK);
	}
	
	@ApiOperation(value = "This api give prospect by id", tags = "User Operations - Prospect", response = ProspectDetailsResponse.class)
	@GetMapping(value = "/v1/prospects/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getProspectById(@PathVariable("id") Long id) {
		log.info("getProspectById ()- start");
		ProspectDetailsResponse responseObject = portalUserOperationService.getProspectById(id);
		log.info("getProspectById ()- end");
		return new ResponseEntity<ProspectDetailsResponse>(responseObject, HttpStatus.OK);
	}
	
	
	
	/** *#################### MEMBERSHIP OPERATION ################################### */
	@ApiOperation(value = "Enroll for membership.", tags = "User Operations - Membershp", response = Long.class)
	@PostMapping(value = "/v1/memberships", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object createMembership(@RequestBody @Valid CreateMembershipRequest createMembershipRequest) {
		log.info("createMembership ()- start");
		log.info("Request Body :  {} " + createMembershipRequest);
		Long id = portalUserOperationService.createMembership(createMembershipRequest);
		log.info("createMembership ()- end");
		return new ResponseEntity<Long>(id, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get membership details by member id.", tags = "User Operations - Membershp", response = MembershipResponse.class)
	@GetMapping(value = "/v1/memberships/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getMembershipDetailsById(@PathVariable("id") Long id) {
		log.info("getMembershipDetailsById ()- start");
		log.info("id :  {} " + id);

		MembershipResponse responseObject = portalUserOperationService.getMembershipDetailsById(id);
		log.info("getMembershipDetailsById ()- end");
		return new ResponseEntity<MembershipResponse>(responseObject, HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "Get all membership availabe in the system", tags = "User Operations - Membershp", response = List.class)
	@GetMapping(value = "/v1/memberships", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getAllMembershipDetails() {
		log.info("getAllMembershipDetails ()- start");
		List<MembershipResponse> allMemberships = portalUserOperationService.getAllMembershipDetails();
		log.info("getAllMembershipDetails ()- end");
		return new ResponseEntity<List<MembershipResponse>>(allMemberships, HttpStatus.OK);
	}
	
	/** ################# PERSONAL TRAINING  DETAILS ##########################*/
	
	
	@ApiOperation(value = "This api creates Personal training.", tags = "User Operations - Personal Trainings", response = Long.class)
	@PostMapping(value = "/v1/personal-trainings", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object createPersonalTraing(@RequestBody @Valid CreatePersonalTrainingDetailRequest createPersonalTrainingDetailsRequest) {
		log.info("createPersonalTraingDetails ()- start");
		log.info("Request Body :  {} " + createPersonalTrainingDetailsRequest);
		Long id = portalUserOperationService.createPersonalTrainingDetails(createPersonalTrainingDetailsRequest);
		log.info("createPersonalTraingDetails ()- end");
		return new ResponseEntity<Long>(id, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get all personal trainings availabe in the system", tags = "User Operations - Personal Trainings", response = List.class)
	@GetMapping(value = "/v1/personal-trainings", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getAllPersonalTraining() {
		log.info("getAllPersonalTraining ()- start");
		List<PersonalTrainingDetailsResponse> allTrainings = portalUserOperationService.getAllPersonalTrainingDetails();
		log.info("getAllPersonalTraining ()- end");
		return new ResponseEntity<List<PersonalTrainingDetailsResponse>>(allTrainings, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get personal training details by id", tags = "User Operations - Personal Trainings", response = PersonalTrainingDetailsResponse.class)
	@GetMapping(value = "/v1/personal-trainings/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getPersonalTraingById(@PathVariable("id") Long id) {
		log.info("getAllPersonalTraining ()- start");
		PersonalTrainingDetailsResponse personalTraining = portalUserOperationService
				.getPersonalTrainingDetailsById(id);
		
		log.info("getAllPersonalTraining ()- end");
		return new ResponseEntity<PersonalTrainingDetailsResponse>(personalTraining, HttpStatus.OK);
	}
	
	/** #################### MEMBER TRASNSFER SERVICE ############################# */
	
	@ApiOperation(value = "This api is to transfer a member from one business unit to another.It gives transfer reference number back", tags = "User Operations - Member Transfer", response = Long.class)
	@PostMapping(value = "/v1/member-transfer", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object createMemberTransfer(@RequestBody @Valid CreateMemberTransferRequest createMemberTransferRequest) {
		log.info("createMemberTransfer ()- start");
		log.info("Request Body :  {} " + createMemberTransferRequest);
		Long id = portalUserOperationService.createMemberTransfer(createMemberTransferRequest);
		log.info("createMemberTransfer ()- end");
		return new ResponseEntity<Long>(id, HttpStatus.OK);
	}
	
	/** #################### CREATE FREEZE REQUEST SERVICE ########################## */
	

	/** #################### PULL PENDING PAYMENTS SERVICE - START ########################## */
	
	@ApiOperation(value = "This api allow to create payment entries into database.", tags = "User Operations - Payment")
	@PostMapping(value = "/v1/membership-payments", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object savePaymentDetails(@RequestBody @Valid CreatePaymentRequest createPaymentRequest) {
		log.info("savePaymentDetails ()- start");
		paymentService.savePaymentDetails(createPaymentRequest);
		log.info("savePaymentDetails ()- end");
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/** #################### PULL PENDING PAYMENTS SERVICE -END ########################## */
	
	@ApiOperation(value = "Get payment details against an membership", tags = "User Operations - Payment", response = MembershipPaymentDetailResponse.class)
	@GetMapping(value = "/v1/membership-payments/{membershipId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getPaymentDetailsById(@PathVariable("membershipId") Long membershipId) {
		log.info("getPaymentDetailsById() - start");
		MembershipPaymentDetailResponse responseObject = paymentService.fetchPaymentDetails(membershipId);

		log.info("getPaymentDetailsById() - end");
		return new ResponseEntity<MembershipPaymentDetailResponse>(responseObject, HttpStatus.OK);
	}
}
