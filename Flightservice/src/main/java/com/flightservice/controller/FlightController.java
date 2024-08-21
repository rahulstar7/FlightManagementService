package com.flightservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	
	@DeleteMapping(value = "/deleteFlight/flightId/{flightId}")
	public String deleteFlight(@PathVariable Integer flightId)
	{
		String adminMsg = userClient.getAdminMsg();
		if(adminMsg.equalsIgnoreCase("Login successfully"))
		{	
		return serviceImpl.deleteFlight(flightId);
		}
		
		else
		{
			throw new AuthenticationException("Authetication failed please login with valid crendentials");
		}	
	}
	
	
    @GetMapping(value = "/flightservice/findbyid/{id}")	
	public Flight findById(@PathVariable Integer id)
	{
		String msg = userClient.getUserMsg();
		
		
		if(msg.equalsIgnoreCase("Login Succesfully"))
		{
			return serviceImpl.findById(id);
		}
		else
		{
			throw new AuthenticationException("Authetication failed please login with valid crendentials");
		}
		
		
	}
	
	
    @PutMapping(value="/flightservice/updateFLight/{id}/{rem_seat}")
    public String updatFlight(@PathVariable Integer id , @PathVariable Integer rem_seat)
    {
    	
    	String msg = userClient.getUserMsg();
    	String messsage;
    	if(msg.equalsIgnoreCase("Login Succesfully"))
    	{
    
    	Flight flight = serviceImpl.findById(id);
    	
    	int rem_seats=flight.getNoofseats_avl()-rem_seat;
    	
    	messsage= serviceImpl.updateFlight(id, rem_seats);
	
      		
    	}	
    	else
    	{
    		throw new AuthenticationException("Authetication failed please login with valid crendentials");
    		
    	}
		return messsage;	
    }
	
    
    
    @PutMapping(value="/flightservice/updateFLightSeat/{id}/{noOfSeat}")
	public String UpdateFlightSeat(@PathVariable Integer id , @PathVariable Integer noOfSeat)
	{
    	String msg = userClient.getUserMsg();
    	String message=null;
    	
    	
    	if(msg.equalsIgnoreCase("Login Succesfully"))
    	{
    		
    		Flight flight = serviceImpl.findById(id);
    		int rem_seat= flight.getNoofseats_avl()+noOfSeat; 
    		message=serviceImpl.updateFlightSeat(id, rem_seat);
    	}	
    	else
    	{
    		throw new AuthenticationException("Authetication failed please login with valid crendentials");
    		
    	}
		return message;		
    	
    	
    			
    	
	}
}
