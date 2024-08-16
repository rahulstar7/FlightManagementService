package com.flightservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flightservice.client.UserFeignClient;
import com.flightservice.exception.AuthenticationException;
import com.flightservice.model.Flight;
import com.flightservice.service.FlightServiceImpl;

@RestController
public class FlightController {

	
	
	@Autowired
	private FlightServiceImpl serviceImpl;
	
	@Autowired
	private UserFeignClient userClient;
	
	@PostMapping(value = "/saveFlight")
	public String saveFlight(@RequestBody Flight flight) {
		String message = null;
		String msg = userClient.getAdminMsg();
	
		if (msg.equalsIgnoreCase("Login successfully")) {
			message = serviceImpl.saveFlight(flight);
		}
		else
		{
			throw new AuthenticationException("Authetication failed please login with valid crendentials");
		}
		return message;
	}
	
	@PutMapping(value="/updateFlight/flightid/{flightid}")
	public String updateFlight(@PathVariable("flightid") Integer flightid, @RequestBody Flight flight)
	{
		String msg = userClient.getAdminMsg();
		
		if(msg.equalsIgnoreCase("Login successfully"))
		{
		
		 return  serviceImpl.updateFLight(flightid, flight);
		}
		else
		{
			throw new AuthenticationException("Authetication failed please login with valid crendentials");
		}
		
	}
	
	@GetMapping(value = "/getAllFlights")
	public List<Flight> getAllFlights()
	{
		String msg = userClient.getAdminMsg();
		List<Flight> list;
		if(msg.equalsIgnoreCase("Login successfully"))
		{
			list= serviceImpl.getAllFlight();
		}
		else
		{
			throw new AuthenticationException("Authetication failed please login with valid crendentials");
		}
		return list;
	}
}
