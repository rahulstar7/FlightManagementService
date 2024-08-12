package com.flightservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightservice.model.Flight;

@Repository
public interface FlightRepository  extends JpaRepository<Flight, Integer>{

}
