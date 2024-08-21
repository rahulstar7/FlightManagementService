package com.ticket.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.ticket.model.Ticket;

@FeignClient(name = "Flightservice",url = "localhost:9999")
public interface FlightClient {

	
	@GetMapping(value = "/getAllFlights")
	public Object[] getAllFlights();
	
	@GetMapping(value = "/flightservice/findbyid/{id}")	
	public Ticket findById(@PathVariable Integer id);
	
	@PutMapping(value="/flightservice/updateFLight/{id}/{rem_seat}")
    public String updatFlight(@PathVariable Integer id , @PathVariable Integer rem_seat);
	
	@PutMapping(value="/flightservice/updateFLightSeat/{id}/{noOfSeat}")
	public String UpdateFlightSeat(@PathVariable Integer id , @PathVariable Integer noOfSeat);
}
