package com.app.config;

import org.kie.api.event.rule.AfterMatchFiredEvent;
import org.kie.api.event.rule.DefaultAgendaEventListener;
import org.springframework.stereotype.Component;

@Component
public class AppDefaultAgendaEventListener  extends  DefaultAgendaEventListener{

	@Override
	public void afterMatchFired(AfterMatchFiredEvent event) {
		System.out.println("Rule fired :"+event.getMatch().getRule().getName());
	}

	
	
}
