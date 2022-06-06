package com.sp.exception;

public class TechnicalException extends RuntimeException {

	public TechnicalException() {
		super();
	}
	
	public TechnicalException(String message) {
		super(message);
	}
	
	public TechnicalException(Throwable e, String message) {
		super(message, e);
	}
}
