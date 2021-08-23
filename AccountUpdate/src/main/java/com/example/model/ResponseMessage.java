package com.example.model;

/**
 * This is a class that holds the details about the response message of the API
 * 
 * @author group 5
 *
 */
public class ResponseMessage {
	/**
	 * This field hold the details about the status code
	 */
	private Integer statusCode;
	/**
	 * This field holds the status
	 */
	private String status;
	/**
	 * This field holds the id of the data we are processing
	 */
	private Integer id;
	/**
	 * This field holds the message from the API
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
