package com.pheonix.drools.service;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pheonix.drools.error.CustomMessages;
import com.pheonix.drools.model.Account;

@Service
public class DroolsService {

	@Autowired
	KieSession kieSession;

	public CustomMessages triggerRules(Account account) {

		CustomMessages messages = new CustomMessages();
		addGlobalObjectsToSession(kieSession, messages);
		kieSession.insert(account);
		kieSession.fireAllRules();
		if (!messages.hasErrors())
			messages.addMessage("Success", "Account Validation Successfull!!!");
		return messages;
	}

	private void addGlobalObjectsToSession(KieSession kieSession, CustomMessages messages) {
		kieSession.setGlobal("messages", messages);
	}

}
