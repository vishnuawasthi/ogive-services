package com.app.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.OrderDetailsData;
import com.app.services.RuleService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
public class DroolsRuleController {

	private static final Logger log = Logger.getLogger(LoginController.class);

	@Autowired
	private RuleService ruleService;

	@ApiOperation(value = "Validate Order details against drools rule", tags="Drools rule",response = Long.class)
	@PostMapping(value = "/v1/rule-validate", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object saveUserDetails(@RequestBody  OrderDetailsData orderDetailsData) {
		log.info("Request Body :  {} " + orderDetailsData);
		
		ruleService.fileRules(orderDetailsData);
		
		
		log.info("Request Body after rules execution :  {} " + orderDetailsData);
		
		return new ResponseEntity<OrderDetailsData>(orderDetailsData, HttpStatus.OK);

	}
	
	
	@PostMapping(value = "/v1/orders", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object orderRules(@RequestBody OrderDetailsData orderDetailsData) {
		 //OrderDetailsData orderDetailsData = new OrderDetailsData();
		 
		log.info("Request Body :  {} " + orderDetailsData);
		
		ruleService.fileRules(orderDetailsData);
		
		
		log.info("Request Body after rules execution :  {} " + orderDetailsData);
		
		return new ResponseEntity<OrderDetailsData>(orderDetailsData, HttpStatus.OK);

	}
	
	
	
}

