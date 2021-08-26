package com.example.util;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.exception.JwtTokenMalformedException;
import com.example.exception.JwtTokenMissingException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

/**
 * Component class for handling the token generation
 * 
 * @author group 5
 *
 */
@Component
public class JwtUtil {

	/**
	 * This field holds the jwt secret
	 */
	@Value("${jwt.secret}")
	private String jwtSecret;

	/**
	 * This field holds the token validity
	 */
	@Value("${jwt.token.validity}")
	private long tokenValidity;

	/**
	 * constitute the payload part of a JSON web token and represent a set of
	 * information exchanged between two parties.
	 * 
	 * @param token
	 * @return Claims
	 */
	public Claims getClaims(final String token) {
		try {
			Claims body = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
			return body;
		} catch (Exception e) {
			System.out.println(e.getMessage() + " => " + e);
		}
		return null;
	}

	/**
	 * Generates the token using username and password as subject
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public String generateToken(String username, String password) {
		Claims claims = Jwts.claims().setSubject(username).setSubject(password);
		long nowMillis = System.currentTimeMillis();
		long expMillis = nowMillis + tokenValidity;
		Date exp = new Date(expMillis);
		return Jwts.builder().setClaims(claims).setIssuedAt(new Date(nowMillis)).setExpiration(exp)
				.signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
	}

	/**
	 * Various validation for the token is carried out
	 * 
	 * @param token
	 * @throws JwtTokenMalformedException
	 * @throws JwtTokenMissingException
	 */
	public void validateToken(final String token) throws JwtTokenMalformedException, JwtTokenMissingException {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
		} catch (SignatureException ex) {
			throw new JwtTokenMalformedException("Invalid JWT signature");
		} catch (MalformedJwtException ex) {
			throw new JwtTokenMalformedException("Invalid JWT token");
		} catch (ExpiredJwtException ex) {
			throw new JwtTokenMalformedException("Expired JWT token");
		} catch (UnsupportedJwtException ex) {
			throw new JwtTokenMalformedException("Unsupported JWT token");
		} catch (IllegalArgumentException ex) {
			throw new JwtTokenMissingException("JWT claims string is empty.");
		}
	}

}
