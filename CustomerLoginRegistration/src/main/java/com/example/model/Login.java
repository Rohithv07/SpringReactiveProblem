package com.example.model;

/**
 * Holds the information about the credentials
 * 
 * @author group 5
 *
 */
public class Login {

	/**
	 * This field holds the details about the username
	 */
	private String username;
	/**
	 * This field holds the details about the password
	 */
	private String password;

	/**
	 * All argument constructor
	 * 
	 * @param username
	 * @param password
	 */
	public Login(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	/**
	 * No argument constructor
	 */
	public Login() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
