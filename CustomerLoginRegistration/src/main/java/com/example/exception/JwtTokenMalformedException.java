package com.example.exception;

import javax.naming.AuthenticationException;

/**
 * If a token is malformed and this condition gets handled
 * @author group 5
 *
 */
public class JwtTokenMalformedException extends AuthenticationException {

	/**
	 * This field holds the detail about serial version uid
	 */
	private static final long serialVersionUID = 1L;

	public JwtTokenMalformedException(String msg) {
		super(msg);
	}

}
