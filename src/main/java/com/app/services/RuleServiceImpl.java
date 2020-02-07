package com.app.services;

import org.kie.api.event.rule.DefaultAgendaEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.app.dto.OrderDetailsData;

@Service
public class RuleServiceImpl implements RuleService {


	@Qualifier("drlFilesRuleSession")
	@Autowired
	private KieSession kieSession;

	@Override
	public void fileRules(OrderDetailsData orderDetailsData) {
		kieSession.insert(orderDetailsData); // which object to validate
		kieSession.fireAllRules();
		System.out.println("orderDetailsData  -> " + orderDetailsData);

	}

}
