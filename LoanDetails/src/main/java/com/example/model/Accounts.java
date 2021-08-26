package com.example.model;

import org.springframework.data.annotation.Id;

/**
 * The model class for Account
 * 
 * @author group 5
 *
 */
public class Accounts {
	/**
	 * This is the primary key for the accounts
	 */
	@Id
	private int acc_id;
	/**
	 * This field holds data about account type.
	 */
	private String acc_type;
	/**
	 * This field holds the data about account name
	 */
	private String acc_name;
	/**
	 * This field holds the data about the username
	 */
	private String username;
	/**
	 * This field holds the data about the password of the user
	 */
	private String password;
	/**
	 * This field holds the data about the address of the user
	 */
	private String address;
	/**
	 * This field holds the data about the state
	 */
	private String state;
	/**
	 * This field holds the data about the country of the user
	 */
	private String country;
	/**
	 * This field holds the data about the email of the user
	 */
	private String email;
	/**
	 * This field holds the pan card details
	 */
	private String pan;
	/**
	 * This field holds the contact number details
	 */
	private String contact_no;
	/**
	 * This field holds the date of birth details
	 */
	private String dob;

	/**
	 * No argument constructor
	 */
	public Accounts() {
		super();
	}

	/**
	 * All argument constructor
	 * @param acc_id
	 * @param acc_type
	 * @param acc_name
	 * @param username
	 * @param password
	 * @param address
	 * @param state
	 * @param country
	 * @param email
	 * @param pan
	 * @param contact_no
	 * @param dob
	 */
	public Accounts(int acc_id, String acc_type, String acc_name, String username, String password, String address,
			String state, String country, String email, String pan, String contact_no, String dob) {
		super();
		this.acc_id = acc_id;
		this.acc_type = acc_type;
		this.acc_name = acc_name;
		this.username = username;
		this.password = password;
		this.address = address;
		this.state = state;
		this.country = country;
		this.email = email;
		this.pan = pan;
		this.contact_no = contact_no;
		this.dob = dob;
	}

	public String getContact_no() {
		return contact_no;
	}

	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}

	public int getAcc_id() {
		return acc_id;
	}

	public void setAcc_id(int acc_id) {
		this.acc_id = acc_id;
	}

	public String getAcc_type() {
		return acc_type;
	}

	public void setAcc_type(String acc_type) {
		this.acc_type = acc_type;
	}

	public String getAcc_name() {
		return acc_name;
	}

	public void setAcc_name(String acc_name) {
		this.acc_name = acc_name;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Accounts [acc_id=" + acc_id + ", acc_type=" + acc_type + ", acc_name=" + acc_name + ", username="
				+ username + ", password=" + password + ", address=" + address + ", state=" + state + ", country="
				+ country + ", email=" + email + ", pan=" + pan + ", contact_no=" + contact_no + ", dob=" + dob + "]";
	}

}
