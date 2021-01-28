package com.demo.registration.RegistrationForm.exception;

public class LimitTransactionException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 111L;

	public LimitTransactionException() {
	}

	@Override
	public String toString() {
		return "Sorry the transaction limit for today is complete try on next Date.";
	}

}
