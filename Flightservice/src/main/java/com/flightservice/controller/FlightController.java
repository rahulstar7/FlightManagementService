package com.flightservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flightservice.model.Flight;
import com.flightservice.service.FlightServiceImpl;

@RestController
public class FlightController {

	
	
	@Autowired
	private FlightServiceImpl serviceImpl;
	
	@PostMapping(value="/saveFlight")
	public String saveFlight(@RequestBody Flight flight)
	{
		return serviceImpl.saveFlight(flight);
	}
}
