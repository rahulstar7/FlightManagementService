package com.ticket.exception;

public class TicketNotFoundException extends RuntimeException {


	
	
	private String msg;



	public TicketNotFoundException(String msg) {
		super();
		this.setMsg(msg);
	}



	public TicketNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}



	public TicketNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}



	public TicketNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}



	public TicketNotFoundException(Throwable cause) {
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
