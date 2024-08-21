package com.ticket.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticket.client.FlightClient;
import com.ticket.client.UserClient;
import com.ticket.exception.AuthenticationException;
import com.ticket.model.Ticket;
import com.ticket.service.TicketService;

@RestController
public class TicketController {

	@Autowired
	private UserClient userClient;

	@Autowired
	private FlightClient flightClient;

	@Autowired
	private TicketService ticketService;

	@GetMapping(value = "/ticketservice/findAllFlights")
	public List<Object> showFlight()

	{

		Object[] object;
		if (userClient.getUserMsg().equalsIgnoreCase("Login Succesfully")) {
			object = flightClient.getAllFlights();
		} else {
			throw new AuthenticationException("Authentication error please login with valid credentials");
		}

		return Arrays.asList(object);
	}

	@PostMapping("/ticketservice/flightid/{flightid}/noOfPass/{no}")
	public String bookTicket(@PathVariable("flightid") Integer flightid, @PathVariable("no") Integer noOfPasseger) {

		String message = null;

		if (userClient.getUserMsg().equalsIgnoreCase("Login Succesfully")) {
			Ticket ticket = flightClient.findById(flightid);

			Ticket ticket2 = new Ticket();

			ticket2.setTicket_id(ticket.getTicket_id());
			ticket2.setFlight_id(ticket.getFlight_id());
			ticket2.setFlight_name(ticket.getFlight_name());
			ticket2.setDestination(ticket.getDestination());
			ticket2.setSource(ticket.getSource());
			ticket2.setDoj(ticket.getDoj());
			ticket2.setTicket_price(ticket.getTicket_price() * noOfPasseger);
			ticket2.setClass_name(ticket.getClass_name());
			ticket2.setTotal_passenger(noOfPasseger);

			message = ticketService.saveTicket(ticket2);
			flightClient.updatFlight(flightid, noOfPasseger);

		} else {
			throw new AuthenticationException("Authentication error please login with valid credentials");
		}
		return message;

	}
	
	@DeleteMapping(value="ticketservice/cancelTicket/ticketId/{ticketId}")
	public String cancelTicket(@PathVariable("ticketId") Integer ticketId)
	{
		String message =null;
		
		if(userClient.getUserMsg().equalsIgnoreCase("Login Succesfully"))
		{
			Integer flight_id = ticketService.findById(ticketId).getFlight_id();
			
			Integer cancel_passenger = ticketService.findById(ticketId).getTotal_passenger();
			
			message=ticketService.deleteTicket(ticketId);
			flightClient.UpdateFlightSeat(flight_id, cancel_passenger);
			
		}
		else {
			throw new AuthenticationException("Authentication error please login with valid credentials");
		}
		return message;
		
	}
	
	

}
