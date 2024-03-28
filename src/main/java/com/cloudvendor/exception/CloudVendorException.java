package com.cloudvendor.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class CloudVendorException {
	
	private String message;
	private Throwable throwable;
	private HttpStatus httpStatus;
	
	public CloudVendorException(String message, Throwable throwable, HttpStatus httpStatus) {
		super();
		this.message = message;
		this.throwable = throwable;
		this.httpStatus = httpStatus;
	}
	

}
