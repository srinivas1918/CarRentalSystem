package com.pramati.crs.response;

/**
 * @author manikanth
 * 
 * class to represent the error response
 */

public class ErrorResponse {

	private String message;
	private boolean success;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

}
