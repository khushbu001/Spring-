package com.demo.registration.RegistrationForm.exception;

public class InvalidAccountException extends RuntimeException {

	/**
	 * @author khushii
	 * 
	 */
	private static final long serialVersionUID = 2L;
	Integer userId;

	public InvalidAccountException(Integer userId) {
		this.userId = userId;

	}

	@Override
	public String toString() {
		return "This " + userId + " userId does not exist";
	}
}
