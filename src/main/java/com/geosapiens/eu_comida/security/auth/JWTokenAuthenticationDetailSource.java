package com.geosapiens.eu_comida.security.auth;

import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import jakarta.servlet.http.HttpServletRequest;

/**
 * Implementation of {@link AuthenticationDetailsSource} which builds the
 * details object from an <tt>HttpServletRequest</tt> object, creating a
 * {@code WebAuthenticationDetails} .
 *
 * @author Ben Alex
 */
public class JWTokenAuthenticationDetailSource
		implements AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails> {
	
	/**
	 * @param context the {@code HttpServletRequest} object.
	 * @return the {@code WebAuthenticationDetails} containing information about the
	 *         current request
	 */
	@Override
	public WebAuthenticationDetails buildDetails(HttpServletRequest context) {
		return new JWTAuthenticationDetails(context, extractToken(context));
	}
	
	public static String extractToken(HttpServletRequest request) {
		String authHeader=request.getHeader("Authorization");
		if(authHeader!=null && authHeader.startsWith("Bearer ")) {
			return authHeader.substring(7);
		}
		return null;
	}

}
