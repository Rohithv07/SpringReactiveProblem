package com.example.exception;

import javax.naming.AuthenticationException;

/**
 * If a token is missing, this case gets handles
 * @author group 5
 *
 */
public class JwtTokenMissingException extends AuthenticationException {

	private static final long serialVersionUID = 1L;

	public JwtTokenMissingException(String msg) {
		super(msg);
	}

}
