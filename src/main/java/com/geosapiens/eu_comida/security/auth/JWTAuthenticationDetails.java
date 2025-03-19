package com.geosapiens.eu_comida.security.auth;

import org.springframework.security.web.authentication.WebAuthenticationDetails;

import jakarta.servlet.http.HttpServletRequest;

public class JWTAuthenticationDetails extends WebAuthenticationDetails{

	private String jwt;

	public JWTAuthenticationDetails(HttpServletRequest context,String jwtoken)
	{
		super(context);
		this.jwt = jwtoken;
	}
	
	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	
	
}
