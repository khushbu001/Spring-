package com.demo.registration.RegistrationForm.exception;

public class InsufficientBalanceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Integer fromAccountId;

	public InsufficientBalanceException(Integer fromAccountId) {
		this.fromAccountId = fromAccountId;

	}

	public String toString() {
	return "Transaction Fails, Insufficient balance in the user account" + fromAccountId;

}
}
