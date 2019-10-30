package com.pramati.crs.exceptions;

public class APIExeception extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public APIExeception() {
		super();
	}
	
	public APIExeception(String message) {
		super(message);
		
	}
	
	public APIExeception(Throwable thr) {
		super(thr);
	}
	
	public APIExeception(String message, Throwable th) {
		super(message, th);
	}
	
}
