package com.ticket.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ticket")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ticket_id;

	private Integer flight_id;

	private String flight_name;

	private String source;

	private String destination;

	private LocalDate doj;

	private String class_name;

	private Double ticket_price;

	private Integer total_passenger;

	private Double total_amount;

	public Ticket(Integer ticket_id, Integer flight_id, String flight_name, String source, String destination,
			LocalDate doj, String class_name, Double ticket_price, Integer total_passenger, Double total_amount) {
		super();
		this.ticket_id = ticket_id;
		this.flight_id = flight_id;
		this.flight_name = flight_name;
		this.source = source;
		this.destination = destination;
		this.doj = doj;
		this.class_name = class_name;
		this.ticket_price = ticket_price;
		this.total_passenger = total_passenger;
		this.total_amount = total_amount;
	}

	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the ticket_id
	 */
	public Integer getTicket_id() {
		return ticket_id;
	}

	/**
	 * @param ticket_id the ticket_id to set
	 */
	public void setTicket_id(Integer ticket_id) {
		this.ticket_id = ticket_id;
	}

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

	/**
	 * @return the ticket_price
	 */
	public Double getTicket_price() {
		return ticket_price;
	}

	/**
	 * @param ticket_price the ticket_price to set
	 */
	public void setTicket_price(Double ticket_price) {
		this.ticket_price = ticket_price;
	}

	/**
	 * @return the total_passenger
	 */
	public Integer getTotal_passenger() {
		return total_passenger;
	}

	/**
	 * @param total_passenger the total_passenger to set
	 */
	public void setTotal_passenger(Integer total_passenger) {
		this.total_passenger = total_passenger;
	}

	/**
	 * @return the total_amount
	 */
	public Double getTotal_amount() {
		return total_amount;
	}

	/**
	 * @param total_amount the total_amount to set
	 */
	public void setTotal_amount(Double total_amount) {
		this.total_amount = total_amount;
	}

	@Override
	public String toString() {
		return "Ticket [ticket_id=" + ticket_id + ", flight_id=" + flight_id + ", flight_name=" + flight_name
				+ ", source=" + source + ", destination=" + destination + ", doj=" + doj + ", class_name=" + class_name
				+ ", ticket_price=" + ticket_price + ", total_passenger=" + total_passenger + ", total_amount="
				+ total_amount + "]";
	}

}
