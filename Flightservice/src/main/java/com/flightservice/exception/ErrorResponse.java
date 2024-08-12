package com.flightservice.exception;

public class ErrorResponse {

	private String msg;

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

	public ErrorResponse(String msg) {
		super();
		this.msg = msg;
	}

	public ErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
