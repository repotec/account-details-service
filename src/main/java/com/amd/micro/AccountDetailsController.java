package com.amd.micro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountDetailsController {

	@Autowired
	ConfigProperties configProperties;
	
	@Autowired
	Environment environment;
	
	@RequestMapping(path="/account", method=RequestMethod.GET)
	public AccountDetail getAccountDetail() {
		return new AccountDetail(configProperties.getAccountNumber(), 
								  configProperties.getFirstName(),
								  configProperties.getLastName(),
								  configProperties.getSsn(),
								  Integer.parseInt(environment.getProperty("local.server.port")),
								  configProperties.getUuid());
	}
}
