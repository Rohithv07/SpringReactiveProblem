package com.example.model;

/**
 * This is a class that holds the details about the response message of the API
 * 
 * @author group 5
 *
 */
public class ResponseMessage {

	/**
	 * This field holds the details about the status code
	 */
	private Integer statusCode;
	/**
	 * This field holds the details about the status
	 */
	private String status;
	/**
	 * This filed holds the details about the message
	 */
	private String message;

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
