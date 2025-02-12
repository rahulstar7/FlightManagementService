package com.ticket.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(TicketNotFoundException.class)
	public ResponseEntity<ErrorResponse> getError(TicketNotFoundException exception) {
	
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMsg(exception.getMsg());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AuthenticationException.class)
	public ResponseEntity<ErrorResponse> getError(AuthenticationException ex)
	{
		
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMsg(ex.getMsg());
		 
		
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.NOT_FOUND);
		
	}
}
