package com.tcs.authdemo.security.jwt;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.tcs.authdemo.security.services.UserDetailsImpl;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtils {

	@Value("${authdemo.app.jwtSecret}")
	private String jwtSecret;
	@Value("${authdemo.app.jwtExpirationMs}")
	private int jwtExpirationMs;
	
	public String generateJwtToken(Authentication authentication) {
		// userName
		
		UserDetailsImpl userDetailsImpl =(UserDetailsImpl)authentication.getPrincipal();
		// do we need to build token?
		return Jwts.builder().setSubject(userDetailsImpl.getUsername())
				.setIssuedAt(new Date())
				.setExpiration(new Date(new Date().getTime()+jwtExpirationMs))
				.signWith(SignatureAlgorithm.HS512, jwtSecret)
				.compact();
				
		/// do we need current time to provide IAT?
		// do we need exp time?
		// alog for generating token
		// compress/compact the token
	}
	public String getUserNameFromJwtToken(String token) {
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
	}
	
	
	public boolean validateJwtToken(String authToken) {
		
	}
}