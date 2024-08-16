package com.flightservice.exception;

public class FlightNotFoundException extends RuntimeException {


	
	
	private String msg;



	public FlightNotFoundException(String msg) {
		super();
		this.setMsg(msg);
	}



	public FlightNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}



	public FlightNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}



	public FlightNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}



	public FlightNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}



	public String getMsg() {
		return msg;
	}



	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
}
