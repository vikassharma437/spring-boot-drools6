package com.pheonix.drools.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pheonix.drools.error.CustomMessages;
import com.pheonix.drools.model.Account;
import com.pheonix.drools.service.DroolsService;

@RestController
@RequestMapping("/")
public class DroolsController {

	@Autowired
	DroolsService droolsService;

	@RequestMapping(value = "validateAccount", method = RequestMethod.POST, consumes = "Application/json", produces = "Application/json")
	public @ResponseBody CustomMessages validateAccount(@RequestBody Account account) {
		return droolsService.triggerRules(account);
	}
}
