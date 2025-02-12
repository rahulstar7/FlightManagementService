package com.flightservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.flightservice.exception.FlightNotFoundException;
import com.flightservice.model.Flight;
import com.flightservice.repository.FlightRepository;

@Service
public class FlightServiceImpl {

	@Autowired
	private FlightRepository flightRepository;

	public String saveFlight(Flight flight) {
		flightRepository.save(flight);

		return flight.getFlight_id() + ": is saved sucessfully";
	}

	public List<Flight> getAllFlight() {
		return flightRepository.findAll();
	}

	public String updateFLight(Integer flightid, Flight flight) {
		if (!ObjectUtils.isEmpty(flightid) && !ObjectUtils.isEmpty(flight)) {
			Flight existingFlight = flightRepository.findById(flightid)
					.orElseThrow(() -> new FlightNotFoundException("Flight Not Found Exception"));

			existingFlight.setClass_name(flight.getClass_name());
			existingFlight.setDestination(flight.getDestination());
			existingFlight.setDoj(flight.getDoj());

			existingFlight.setFlight_name(flight.getFlight_name());
			existingFlight.setNoofseats_avl(flight.getNoofseats_avl());
			existingFlight.setSource(flight.getSource());
			existingFlight.setTicket_price(flight.getTicket_price());

			flightRepository.save(existingFlight);
			return "Flight Id  :" + existingFlight.getFlight_id() + "  Is updated successfully";

		} else {
			return "Flight Id :" + flightid + "Sorry not updated successfully";
		}
	}

	public String deleteFlight(Integer flightId) {
		Flight flight = flightRepository.findById(flightId)
				.orElseThrow(() -> new FlightNotFoundException("Flight Not Found Exception"));

		if (!ObjectUtils.isEmpty(flight)) {
			flightRepository.delete(flight);
			return flight.getFlight_id() + " is successfully deleted";
		} else {
			return flight.getFlight_id() + " is not deleted";
		}

	}

	public Flight findById(Integer id) {
		Flight flight = flightRepository.findById(id)
				.orElseThrow(() -> new FlightNotFoundException("Flight Not Found Exception"));

		return flight;

	}
	
	
	
	public String updateFlight(Integer id ,Integer rem_seat)
	{
		flightRepository.updateFlight(id, rem_seat);
		return "update Flight successfully";
	}
	
	public String updateFlightSeat(Integer id ,Integer noOfSeat)
	{
		flightRepository.updateFlightSeat(id, noOfSeat);
		return "update Flight successfully";
	}

}
