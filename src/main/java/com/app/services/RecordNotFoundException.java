package com.app.services;

public class RecordNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message;

	public String getMessage() {
		return message;
	}

	public RecordNotFoundException(String message) {
		super(message);
		this.message = message;
	}

}
