package com.sp.exception;

public class FunctionnalException extends Exception {

	public FunctionnalException() {
		super();
	}
	
	public FunctionnalException(String message) {
		super(message);
	}
	
	public FunctionnalException(Throwable e, String message) {
		super(message, e);
	}
}
