package com.alghanim.enaya.travelinsurance.plan.exceptions;

import java.util.Date;

public class CustomExceptions extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date timestamp;
	private String message;
	private String error;
	private String httpCodeMessage;
	private int status;

	public CustomExceptions(Date timestamp, String httpCodeMessage, String error, String message, int status) {
		this.timestamp = timestamp;
		this.message = message;
		this.error = error;
		this.httpCodeMessage = httpCodeMessage;
		this.status = status;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getHttpCodeMessage() {
		return httpCodeMessage;
	}

	public void setHttpCodeMessage(String httpCodeMessage) {
		this.httpCodeMessage = httpCodeMessage;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "TermsExceptions [timestamp=" + timestamp + ", message=" + message + ", error=" + error
				+ ", httpCodeMessage=" + httpCodeMessage + ", status=" + status + "]";
	}
}