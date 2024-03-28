package com.cloudvendor.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice //to handle the exception globally
public class CloudVendorExceptionHandler {
	
	@ExceptionHandler(value = {CloudVendorNotFoundException.class}) //to specify which exception it will handle.
	public ResponseEntity<Object> handleCloudVendorNotFoundException
	(CloudVendorNotFoundException cloudVendorNotFoundException){
		CloudVendorException cloudVendorException = new CloudVendorException(
				cloudVendorNotFoundException.getMessage(),cloudVendorNotFoundException.getCause(),HttpStatus.NOT_FOUND
				);
		return new ResponseEntity<Object>(cloudVendorException, HttpStatus.NOT_FOUND);
	}

}
