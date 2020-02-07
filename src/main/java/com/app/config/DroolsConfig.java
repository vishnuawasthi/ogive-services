package com.app.config;

import java.io.IOException;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;

@SpringBootConfiguration
public class DroolsConfig {

	@Bean("drlFilesRuleContainer")
	public KieContainer kieContainer() {
		KieContainer kieContainer = KieServices.get().getKieClasspathContainer();
		return kieContainer;
	}

	@Bean("drlFilesRuleSession")
	@DependsOn("drlFilesRuleContainer")
	public KieSession kieSession(@Autowired KieContainer kieContainer) throws IOException {
		KieSession kieSession = kieContainer.newKieSession("drlRulesSession");
		return kieSession;
	}

}
