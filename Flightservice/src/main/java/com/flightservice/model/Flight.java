package com.flightservice.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Flight")
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer flight_id;

	private String flight_name;

	private String source;

	private String destination;

	private LocalDate doj;

	private Integer noofseats_avl;

	private double ticket_price;

	private String class_name;

	/**
	 * @return the flight_id
	 */
	public Integer getFlight_id() {
		return flight_id;
	}

	/**
	 * @param flight_id the flight_id to set
	 */
	public void setFlight_id(Integer flight_id) {
		this.flight_id = flight_id;
	}

	/**
	 * @return the flight_name
	 */
	public String getFlight_name() {
		return flight_name;
	}

	/**
	 * @param flight_name the flight_name to set
	 */
	public void setFlight_name(String flight_name) {
		this.flight_name = flight_name;
	}

	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * @param destination the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}

	/**
	 * @return the doj
	 */
	public LocalDate getDoj() {
		return doj;
	}

	/**
	 * @param doj the doj to set
	 */
	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}

	/**
	 * @return the noofseats_avl
	 */
	public Integer getNoofseats_avl() {
		return noofseats_avl;
	}

	/**
	 * @param noofseats_avl the noofseats_avl to set
	 */
	public void setNoofseats_avl(Integer noofseats_avl) {
		this.noofseats_avl = noofseats_avl;
	}

	/**
	 * @return the ticket_price
	 */
	public double getTicket_price() {
		return ticket_price;
	}

	/**
	 * @param ticket_price the ticket_price to set
	 */
	public void setTicket_price(double ticket_price) {
		this.ticket_price = ticket_price;
	}

	/**
	 * @return the class_name
	 */
	public String getClass_name() {
		return class_name;
	}

	/**
	 * @param class_name the class_name to set
	 */
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	public Flight(Integer flight_id, String flight_name, String source, String destination, LocalDate doj,
			Integer noofseats_avl, double ticket_price, String class_name) {
		super();
		this.flight_id = flight_id;
		this.flight_name = flight_name;
		this.source = source;
		this.destination = destination;
		this.doj = doj;
		this.noofseats_avl = noofseats_avl;
		this.ticket_price = ticket_price;
		this.class_name = class_name;
	}

	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Flight [flight_id=" + flight_id + ", flight_name=" + flight_name + ", source=" + source
				+ ", destination=" + destination + ", doj=" + doj + ", noofseats_avl=" + noofseats_avl
				+ ", ticket_price=" + ticket_price + ", class_name=" + class_name + "]";
	}

}
