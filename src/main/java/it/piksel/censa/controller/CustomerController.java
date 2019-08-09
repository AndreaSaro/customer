package it.piksel.censa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.piksel.censa.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value = "/jwtInfo", method = RequestMethod.GET)
	public String getJwtInfo(@RequestParam String jwtUsername) {
		return jwtUsername;
	}

}
