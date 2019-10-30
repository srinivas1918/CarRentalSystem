package com.pramati.crs.fare.exception;

import org.springframework.http.HttpStatus;

/**
 * Generic API exception class
 * 
 * @author ashishr
 *
 */
public class APIException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final String message;
	private final HttpStatus status;

	public APIException(String message, HttpStatus status) {
		this.message = message;
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public HttpStatus getStatus() {
		return status;
	}

}
