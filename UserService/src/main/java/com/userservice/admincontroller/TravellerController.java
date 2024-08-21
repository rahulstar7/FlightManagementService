package com.userservice.admincontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.userservice.model.Traveller;
import com.userservice.service.TravellerService;

@RestController
public class TravellerController {

	
	
	@Autowired
	private TravellerService service;
	
	String msg="Login first";
	@GetMapping(value = "/tavellerservice/user-register/username/{username}/password/{password}")
	public String saveTraveller(@PathVariable String username, @PathVariable String password)
	{
		
		Traveller traveller = new Traveller();
		
		traveller.setName(username);
		traveller.setPassword(password);
		return service.saveTraveller(traveller);
	}
	
	@GetMapping(value = "/tavellerservice/user-login/name/{name}/password/{password}")
	public String login(@PathVariable String name , @PathVariable String password)
	{
		msg=service.login(name, password);
		return msg;
	}
	
	
	@GetMapping(value = "/tavellerservice/getMessage")
	public String getUserMsg()
	{
		
		return msg;
	}
	
	
	
	
	
	
	
	
	
}
