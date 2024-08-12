package com.flightservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(FlightNotFoundException.class)
	public ResponseEntity<ErrorResponse> getError(FlightNotFoundException exception) {
	
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMsg(exception.getMessage());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
	}
}
