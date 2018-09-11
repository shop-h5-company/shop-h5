package com.p2g.core.support.exception;

@SuppressWarnings("serial")
public class LoginException extends RuntimeException {
	public LoginException(String message) {
		super(message);
	}

	public LoginException(String message, Exception e) {
		super(message, e);
	}
}
