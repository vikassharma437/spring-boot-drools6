package com.pheonix.drools.configuration;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.pheonix.drools"})
public class DroolsConfiguration {

	@Autowired
	KieContainer kieContainer;

	@Bean
	public KieContainer kieContainer() {
		return KieServices.Factory.get().getKieClasspathContainer();
	}

	@Bean
	public KieSession kieSession() {
		return kieContainer.newKieSession("ksession-rules");
	}

}
