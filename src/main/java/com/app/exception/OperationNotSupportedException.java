package com.app.exception;

public class OperationNotSupportedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message;

	public OperationNotSupportedException(String message) {
		super(message);

		this.message = message;

	}

	public String getMessage() {
		return message;
	}

}
