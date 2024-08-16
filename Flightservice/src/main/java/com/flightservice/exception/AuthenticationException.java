package com.flightservice.exception;

public class AuthenticationException  extends RuntimeException{


	
	String msg;


	public AuthenticationException(String msg) {
		super();
		this.msg = msg;
	}


	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}


	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	

}
