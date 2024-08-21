package com.flightservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.flightservice.model.Flight;

import jakarta.transaction.Transactional;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

	@Transactional
	@Modifying
	@Query(value = "update Flight set noofseats_avl=:rem_seat where flight_id=:id", nativeQuery = true)
	public void updateFlight(@Param("id") Integer id, @Param("rem_seat") Integer rem_seat);

	@Transactional
	@Modifying
	@Query(value = "update Flight  set noofseats_avl=:noOfSeat where flight_id=:id", nativeQuery = true)
	public void updateFlightSeat(@Param("id") Integer id, @Param("noOfSeat") Integer noOfSeat);

}
