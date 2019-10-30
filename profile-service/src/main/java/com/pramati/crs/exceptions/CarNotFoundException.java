package com.pramati.crs.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CarNotFoundException extends APIExeception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CarNotFoundException(String message) {
		super(message);
	}
}
