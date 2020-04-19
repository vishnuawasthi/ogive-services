package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.constants.Authorities;
import com.app.dto.BusinessUnitDetailsResponse;
import com.app.dto.CountryDetailsResponse;
import com.app.dto.CreateBusinessUnitDetailsRequest;
import com.app.dto.CreateCountryDetailsRequest;
import com.app.dto.CreatePackageDetailsRequest;
import com.app.dto.CreateMembershipTypeRequest;
import com.app.dto.CreatePersonalTrainingTypeRequest;
import com.app.dto.CreatePortalUserDetailsRequest;
import com.app.dto.CreateSourceDetailsRequest;
import com.app.dto.CreateStaffDetailsRequest;
import com.app.dto.PackageDetailsResponse;
import com.app.dto.MembershipTypeResponse;
import com.app.dto.PersonalTrainingTypeResponse;
import com.app.dto.PortalUserDetailsResponse;
import com.app.dto.SourceDetailsResponse;
import com.app.dto.StaffDetailsResponse;
import com.app.exception.RecordNotFoundException;
import com.app.services.MembershipService;
import com.app.services.PortalAdminOperationService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/admin-api")
@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
		@ApiResponse(code = 401, message = "You are not authorized to perform the operation"),
		@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
		@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
public class WellnessManagementAdminController {

	private static final Logger log =LoggerFactory.getLogger(WellnessManagementAdminController.class);

	@Autowired
	private PortalAdminOperationService portalOperationService;

	@Autowired
	private MembershipService membershipService;
	
	/*##################### PORTAL USER OPERATIONS ################## */ 
	
	@ApiOperation(value = "This service suspends an existing user", tags = "Admin operations - Users", response = Long.class)
	@PostMapping(value = "/v1/portal-users/{id}/suspend-account", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object suspendAccount(@PathVariable("id") Long id) {
		log.info("suspendAccount() - start");
		portalOperationService.suspendAcccount(id);
		log.info("suspendAccount() - end");
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@ApiOperation(value = "This service enable  an suspended account", tags = "Admin operations - Users", response = Long.class)
	@PostMapping(value = "/v1/portal-users/{id}/enable-account", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object enableAccount(@PathVariable("id") Long id) {
		log.info("enableAccount() - start");
		portalOperationService.enableAcccount(id);
		log.info("enableAccount() - end");
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@ApiOperation(value = "Add user authorities", tags = "Admin operations - Users authorities")
	@PostMapping(value = "/v1/portal-users/{id}/authorities", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object updateAuthorities(@PathVariable("id") Long id, @RequestBody List<Authorities> authrorities) {
		log.info("updateAuthorities ()- start");
		log.info("Request Body :  {} " + authrorities);
		portalOperationService.updateAuthorities(id, authrorities);
		log.info("updateAuthorities ()- end");
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@ApiOperation(value = "Delete user authorities", tags = "Admin operations - Users authorities")
	@DeleteMapping(value = "/v1/portal-users/{id}/authorities", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object deleteAuthorities(@PathVariable("id") Long id, @RequestBody List<Authorities> authrorities) {
		log.info("deleteAuthorities ()- start");
		log.info("Request Body :  {} " + authrorities);
		portalOperationService.updateAuthorities(id, authrorities);
		log.info("deleteAuthorities ()- end");
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@ApiOperation(value = "Create a user in the system", tags = "Admin operations - Users")
	@PostMapping(value = "/v1/portal-users", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object regiserPortalUSer(@RequestBody @Valid CreatePortalUserDetailsRequest portalUserDetailsRequest) {
		log.info("regiserPortalUSer ()- start");
		log.info("Request Body :  {} " + portalUserDetailsRequest);
		Long id = portalOperationService.savePortalUserDetails(portalUserDetailsRequest);
		log.info("memberRegistration ()- end");
		return new ResponseEntity<Long>(id, HttpStatus.OK);
	}

	@ApiOperation(value = "This service used to update the details of an existing user.It accept updatable fields in body and those are firestname, lastname, "
			+ "email, contactNumber", tags = "Admin operations - Users", response = PortalUserDetailsResponse.class)
	@PutMapping(value = "/v1/portal-users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object updatePortalUserDetails(@PathVariable("id") Long id,
			@RequestBody @Valid CreatePortalUserDetailsRequest portalUserDetailsRequest) throws RecordNotFoundException {
		log.info("updatePortalUserDetails ()- start");
		log.info("Request Body :  {} " + portalUserDetailsRequest);
		PortalUserDetailsResponse portalUserDetailsResponse = portalOperationService.updatePortalUserDetails(id,
				portalUserDetailsRequest);
		log.info("updatePortalUserDetails ()- end");
		return new ResponseEntity<PortalUserDetailsResponse>(portalUserDetailsResponse, HttpStatus.OK);
	}

	@ApiOperation(value = "Get all the portal users.It will give all the existing users,It only fetches active users. for active users isEnabled should be Y", tags = "Admin operations - Users", response = List.class)
	@GetMapping(value = "/v1/portal-users", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getAllPortalUsers() {
		log.info("getAllPortalUsers ()- start");
		List<PortalUserDetailsResponse> portalUserDetailsList = portalOperationService.getAllPortalUsers();
		log.info("getAllPortalUsers ()- end");
		return new ResponseEntity<List<PortalUserDetailsResponse>>(portalUserDetailsList, HttpStatus.OK);
	}

	@ApiOperation(value = "Get portal user by id", tags = "Admin operations - Users", response = PortalUserDetailsResponse.class)
	@GetMapping(value = "/v1/portal-users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getPortalUsersById(@PathVariable(name = "id") Long id) {
		log.info("getPortalUsersById ()- start");
		PortalUserDetailsResponse responseObject = portalOperationService.getPortalUserById(id);
		log.info("getPortalUsersById ()- end");
		return new ResponseEntity<PortalUserDetailsResponse>(responseObject, HttpStatus.OK);
	}

	/**
	 * #################### MEMBERSHIP TYPE  #############################
	 */

	@ApiOperation(value = "This api allow to update membership type", response = Long.class, tags = "Admin operations - Membership Type")
	@PostMapping(value = "/v1/membership-type", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object createMembershipType(@RequestBody @Valid CreateMembershipTypeRequest createMembershipTypeRequest) {
		log.info("createMembershipType ()- start");
		log.info("Request Body :  {} " + createMembershipTypeRequest);
		Long id = membershipService.createMembershipType(createMembershipTypeRequest);
		log.info("createMembershipType ()- end");
		return new ResponseEntity<Long>(id, HttpStatus.OK);
	}

/*	@ApiOperation(value = "This api allow to create membership type", tags = "Admin operations - Membership Type")
	@PutMapping(value = "/v1/membership-type/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object updateMembershipType(@PathVariable("id") Long id,
			@RequestBody @Valid CreateMembershipTypeRequest createMembershipTypeRequest) {
		log.info("createMembershipType ()- start");
		log.info("Request Body :  {} " + createMembershipTypeRequest);
		MembershipTypeResponse responseObject = null;
		log.info("createMembershipType ()- end");
		return new ResponseEntity<MembershipTypeResponse>(responseObject, HttpStatus.OK);
	}*/

	@ApiOperation(value = "This api gives membership type queried against the id", response = MembershipTypeResponse.class, tags = "Admin operations - Membership Type")
	@GetMapping(value = "/v1/membership-type/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getMembershipTypeById(@PathVariable("id") Long id) {
		log.info("getMembershipTypeById ()- start");
		MembershipTypeResponse responseObject = membershipService.getMembershipTypeById(id);
		log.info("getMembershipTypeById ()- end");
		return new ResponseEntity<MembershipTypeResponse>(responseObject, HttpStatus.OK);
	}

	@ApiOperation(value = "This api gives pageable list of all the membership type available in the system"
			/*+ "Some Examples -: "
			+ "/v1/membership-type?pageSize=5\r\n" + 
			"/v1/membership-type?pageSize=5&pageNo=1\r\n" + 
			"/v1/membership-type?pageSize=5&pageNo=2\r\n" + 
			"/v1/membership-type?pageSize=5&pageNo=1&sortBy=email\r\n" + 
			"/v1/membership-type?pageSize=5&pageNo=1&sortBy=firstName"*/
			+ "", response = List.class, tags = "Admin operations - Membership Type")
	@GetMapping(value = "/v1/membership-type", produces = MediaType.APPLICATION_JSON_VALUE)
	public HttpEntity<Page<MembershipTypeResponse>> getAllMembershipTypesAsPageable(Pageable pageRequest) {
		log.info("getAllMembershipTgetAllMembershipTypesAsPageableypes ()- start");
		Page<MembershipTypeResponse> getAllMembershipTypes = membershipService.getAllMembershipTypesAsPageable(pageRequest);
		log.info("getAllMembershipTypesAsPageable ()- end");
		return new ResponseEntity<Page<MembershipTypeResponse>>(getAllMembershipTypes, HttpStatus.OK);
	}

	/** #################### BUSINESS UNIT ########################### */
	
	@ApiOperation(value = "Give api allow to create Business Unit details", tags = "Admin operations - Comapny Or Business Unit", response = Long.class)
	@PostMapping(value = "/v1/business-units", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object createCompanyOrBusinessUnit(@RequestBody @Valid CreateBusinessUnitDetailsRequest createBusinessUnitDetailsRequest) {
		log.info("companyOrBusinessUnit ()- start");
		Long id = membershipService.createCompanyOrBusinessUnit(createBusinessUnitDetailsRequest);
		log.info("companyOrBusinessUnit ()- end");
		return new ResponseEntity<Long>(id, HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "Give api allow to update Business Unit details", tags = "Admin operations - Comapny Or Business Unit", response = Long.class)
	@PutMapping(value = "/v1/business-units/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object updateCompanyOrBusinessUnit(@PathVariable("id") Long id,@RequestBody @Valid CreateBusinessUnitDetailsRequest createBusinessUnitDetailsRequest) {
		log.info("updateCompanyOrBusinessUnit ()- start");
		BusinessUnitDetailsResponse responseObject = membershipService.updateCompanyOrBusinessUnit(id,createBusinessUnitDetailsRequest);
		log.info("updateCompanyOrBusinessUnit ()- end");
		return new ResponseEntity<BusinessUnitDetailsResponse>(responseObject, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Give all the Business Unit details", tags = "Admin operations - Comapny Or Business Unit", response = List.class)
	@GetMapping(value = "/v1/business-units", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getAllCompanyOrBusinessUnits() {
		log.info("getAllCompanyOrBusinessUnits ()- start");
		List<BusinessUnitDetailsResponse> responseObject = membershipService.getAllCompanyOrBusinessUnits();
		log.info("getAllCompanyOrBusinessUnits ()- end");
		return new ResponseEntity<List<BusinessUnitDetailsResponse>>(responseObject, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Give the Business Unit details by id", tags = "Admin operations - Comapny Or Business Unit", response = BusinessUnitDetailsResponse.class)
	@GetMapping(value = "/v1/business-units/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getCompanyOrBusinessUnitById(@PathVariable("id") Long id) {
		log.info("getCompanyOrBusinessUnitById ()- start");
		BusinessUnitDetailsResponse responseObject = membershipService.getBusinessUnitDetailsById(id);
		log.info("getAllCompanyOrBusinessUnits ()- end");
		return new ResponseEntity<BusinessUnitDetailsResponse>(responseObject, HttpStatus.OK);
	}
	
	/**################## PERSONAL TRAINING TYPE ####################### */
	
	@ApiOperation(value = "This api allow to create Personal Training Type", response = Long.class, tags = "Admin operations - Personal Training Type")
	@PostMapping(value = "/v1/personal-training-types", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object createPersonalTrainingType(@RequestBody @Valid CreatePersonalTrainingTypeRequest createPersonalTrainingTypeRequest) {
		log.info("createPersonalTrainingType ()- start");
		log.info("Request Body :  {} " + createPersonalTrainingTypeRequest);
		Long id = membershipService.createPersonalTrainingType(createPersonalTrainingTypeRequest);
		log.info("createPersonalTrainingType ()- end");
		return new ResponseEntity<Long>(id, HttpStatus.OK);
	}

	
	@ApiOperation(value = "This api allow to update Personal Training Type.These fields are duration,extraSessions,allowedSessions,validityInDays,effectiveDate,joiningFees,subscriptionFees,subscriptionFees,allowableDiscount", response = Long.class, tags = "Admin operations - Personal Training Type")
	@PutMapping(value = "/v1/personal-training-types/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object updatePersonalTrainingType(@PathVariable("id") Long id,@RequestBody @Valid CreatePersonalTrainingTypeRequest createPersonalTrainingTypeRequest) {
		log.info("createPersonalTrainingType ()- start");
		log.info("Request Body :  {} " + createPersonalTrainingTypeRequest);
		PersonalTrainingTypeResponse responseObject = membershipService.updatePersonalTrainingType(id,createPersonalTrainingTypeRequest);
		log.info("createPersonalTrainingType ()- end");
		return new ResponseEntity<PersonalTrainingTypeResponse>(responseObject, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Thi api gives the Personal Training Type details by id",tags = "Admin operations - Personal Training Type", response = PersonalTrainingTypeResponse.class)
	@GetMapping(value = "/v1/personal-training-types/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getPersonalTrainingTypeById(@PathVariable("id") Long id) {
		log.info("getPersonalTrainingTypeById ()- start");
		PersonalTrainingTypeResponse responseObject = membershipService.getPersonalTrainingTypeById(id);
		log.info("getPersonalTrainingTypeById ()- end");
		return new ResponseEntity<PersonalTrainingTypeResponse>(responseObject, HttpStatus.OK);
	}
	
	@ApiOperation(value = "This api gives all the personal Training Type details available in the system", tags = "Admin operations - Personal Training Type", response = List.class)
	@GetMapping(value = "/v1/personal-training-types", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getAllPersonalTrainingType() {
		log.info("getAllPersonalTrainingType ()- start");
		List<PersonalTrainingTypeResponse> responseObject = membershipService.getAllPersonalTrainingType();
		log.info("getAllPersonalTrainingType ()- end");
		return new ResponseEntity<List<PersonalTrainingTypeResponse>>(responseObject, HttpStatus.OK);
	}
	
	/*######################## STAFF TYPE #########################*/
	
	@ApiOperation(value = "This api allow to create Staff Details", response = Long.class, tags = "Admin operations - Staff Details")
	@PostMapping(value = "/v1/staff-details", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object createStaffDetails(@RequestBody @Valid CreateStaffDetailsRequest createStaffDetailsRequest) {
		log.info("createStaffDetails ()- start");
		log.info("Request Body :  {} " + createStaffDetailsRequest);
		Long id = membershipService.createStaffDetails(createStaffDetailsRequest);
		log.info("createStaffDetails ()- end");
		return new ResponseEntity<Long>(id, HttpStatus.OK);
	}
	
	@ApiOperation(value = "This api allow to create Staff Details", response = Long.class, tags = "Admin operations - Staff Details")
	@PutMapping(value = "/v1/staff-details/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object createStaffDetails(@PathVariable("id") Long id, @RequestBody @Valid CreateStaffDetailsRequest createStaffDetailsRequest) {
		log.info("createStaffDetails ()- start");
		log.info("Request Body :  {} " + createStaffDetailsRequest);
		StaffDetailsResponse responseObject = membershipService.updateStaffDetails(id, createStaffDetailsRequest);
		log.info("createStaffDetails ()- end");
		return new ResponseEntity<StaffDetailsResponse>(responseObject, HttpStatus.OK);
	}
	
	@ApiOperation(value = "This api give list of all the staff details available in the system", response = List.class, tags = "Admin operations - Staff Details")
	@GetMapping(value = "/v1/staff-details", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getAllStaffDetails() {
		log.info("getAllStaffDetails ()- start");
		List<StaffDetailsResponse> responseObject = membershipService.getAllStaffDetails();
		log.info("getAllStaffDetails ()- end");
		return new ResponseEntity<List<StaffDetailsResponse>>(responseObject, HttpStatus.OK);
	}
	
	@ApiOperation(value = "This api give staff details available in the system against supplied id", response = List.class, tags = "Admin operations - Staff Details")
	@GetMapping(value = "/v1/staff-details/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getStaffDetailsById(@PathVariable("id") Long id) {
		log.info("getStaffDetailsById ()- start");
		StaffDetailsResponse responseObject = membershipService.getStaffDetailsById(id);
		log.info("getStaffDetailsById ()- end");
		return new ResponseEntity<StaffDetailsResponse>(responseObject, HttpStatus.OK);
	}
	
	/*######################## MEMBERSHIP PACKAGE DETAILS #########################*/
	
	@ApiResponse(response=Long.class, code=200,message ="Return ID of the created package.")
	@ApiOperation(value = "This api allow to create membership package details", response = Long.class, tags = "Admin operations - Membership Package Details")
	@PostMapping(value = "/v1/membership-pkg-details", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object createMembershipPkgDtls(@RequestBody @Valid CreatePackageDetailsRequest createMembershipPackageDetailsRequest) {
		log.info("createMembershipPkgDtls ()- start");
		log.info("Request Body :  {} " + createMembershipPackageDetailsRequest);
		Long id = membershipService.createMembershipPackageDetails(createMembershipPackageDetailsRequest);
		log.info("createMembershipPkgDtls ()- end");
		return new ResponseEntity<Long>(id, HttpStatus.OK);
	}
	
	@ApiOperation(value = "This api give package details against supplied id", response = Long.class, tags = "Admin operations - Membership Package Details")
	@GetMapping(value = "/v1/membership-pkg-details/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getMembershipPkgDtlsById(@PathVariable("id") Long id) {
		log.info("getMembershipPkgDtlsById ()- start");
		log.info("Request Param :  {} " + id);
		PackageDetailsResponse responseObject = membershipService.getMembershipPackageDetailsById(id);
		log.info("getMembershipPkgDtlsById ()- end");
		return new ResponseEntity<PackageDetailsResponse>(responseObject, HttpStatus.OK);
	}
	
	@ApiOperation(value = "This api allow to create membership package details", response = List.class, tags = "Admin operations - Membership Package Details")
	@GetMapping(value = "/v1/membership-pkg-details", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getAllMembershipPkgDtls() {
		log.info("getAllMembershipPkgDtls ()- start");
		List<PackageDetailsResponse> responseObject = membershipService.getAllPackageDetails();
		log.info("getAllMembershipPkgDtls ()- end");
		return new ResponseEntity<List<PackageDetailsResponse>>(responseObject, HttpStatus.OK);
	}
	
	/*######################## COUNTRY DETAILS #########################*/
	
	@ApiOperation(value = "This api allow to create country details", response = Long.class, tags = "Admin operations - Country Details")
	@PostMapping(value = "/v1/country-details", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object addCountryDetails(@RequestBody @Valid CreateCountryDetailsRequest createCountryDetailsRequest) {
		log.info("addCountryDetails ()- start");
		log.info("Request Body :  {} " + createCountryDetailsRequest);
		Long id = portalOperationService.addCountryDetails(createCountryDetailsRequest);
		log.info("addCountryDetails ()- end");
		return new ResponseEntity<Long>(id, HttpStatus.OK);
	}
	
	@ApiOperation(value = "This api give country details by id", response = CountryDetailsResponse.class, tags = "Admin operations - Country Details")
	@GetMapping(value = "/v1/country-details/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getCountryById(@PathVariable("id") Long id) {
		log.info("getCountryById ()- start");
		CountryDetailsResponse responseObject = portalOperationService.getCountryDetailsById(id);
		log.info("getCountryById ()- end");
		return new ResponseEntity<CountryDetailsResponse>(responseObject, HttpStatus.OK);
	}

	@ApiOperation(value = "This api give country details by country code", response = CountryDetailsResponse.class, tags = "Admin operations - Country Details")
	@GetMapping(value = "/v1/country-details/country-code/{countryCode}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getCountryByCode(@PathVariable("countryCode") String countryCode) {
		log.info("getCountryById ()- 	CountryDetailsResponse start");
		CountryDetailsResponse responseObject = portalOperationService.getCountryDetailsByCode(countryCode);
		log.info("getCountryById ()- end");
		return new ResponseEntity<CountryDetailsResponse>(responseObject, HttpStatus.OK);
	}

	@ApiOperation(value = "This api gives all the countries detail", response = List.class, tags = "Admin operations - Country Details")
	@GetMapping(value = "/v1/country-details", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getAllCountryDetails() {
		log.info("getAllCountryDetails ()- start");
		List<CountryDetailsResponse> objectList = portalOperationService.getAllCountryDetails();
		log.info("getAllCountryDetails ()- end");
		return new ResponseEntity<List<CountryDetailsResponse>>(objectList, HttpStatus.OK);
	}
	
	/**############################# SOURCE DETAILS ######################################## */
	
	@ApiOperation(value = "This api allow to create source details", response = String.class, tags = "Admin operations - Source Details")
	@PostMapping(value = "/v1/source-details", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object createSourceDetails(@RequestBody @Valid CreateSourceDetailsRequest createSourceDetailsRequest) {
		log.info("createSourceDetails ()- start");
		log.info("Request Body :  {} " + createSourceDetailsRequest);
		String id = portalOperationService.createSourceDetails(createSourceDetailsRequest);
		log.info("createSourceDetails ()- end");
		return new ResponseEntity<String>(id, HttpStatus.OK);
	}

	@ApiOperation(value = "This api gives all the sources available in database", response = List.class, tags = "Admin operations - Source Details")
	@GetMapping(value = "/v1/source-details", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object getAllSourcesDetails() {
		log.info("getAllSourcesDetails ()- start");
		List<SourceDetailsResponse> objectList = portalOperationService.getAllSourcesDetails();
		log.info("getAllSourcesDetails ()- end");
		return new ResponseEntity<List<SourceDetailsResponse>>(objectList, HttpStatus.OK);
	}

	@ApiOperation(value = "This api delete source by id", response = List.class, tags = "Admin operations - Source Details")
	@DeleteMapping(value = "/v1/source-details/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object deleteSourceDetails(@PathVariable("id") String id) {
		log.info("deleteSourceDetails ()- start");
		portalOperationService.deleteSource(id);
		log.info("deleteSourceDetails ()- end");
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
