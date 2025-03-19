package com.geosapiens.eu_comida.security.auth;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import com.geosapiens.eu_comida.security.auth.service.JwtService;
import com.geosapiens.eu_comida.security.auth.service.UserService;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private JwtService jwtService;

	@Autowired
	private UserService userService;

	@Autowired
	@Qualifier("handlerExceptionResolver")
	private HandlerExceptionResolver resolver;

	static private final Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);

	@Override
	protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response,
			@NonNull FilterChain filterChain) throws ServletException, IOException {

		try {
			final String authHeader = request.getHeader("Authorization");
			final String jwt;
			final String userEmail;

			if (StringUtils.isEmpty(authHeader) || !StringUtils.startsWith(authHeader, "Bearer ")) {
				filterChain.doFilter(request, response);
				return;
			}
			jwt = authHeader.replace("Bearer ", "");
			userEmail = jwtService.extractUserName(jwt);

			UserDetails userDetails = userService.userDetailsService().loadUserByUsername(userEmail);

			if (jwtService.isTokenValid(jwt)) {
				SecurityContext context = SecurityContextHolder.createEmptyContext();

				UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails,
						null, userDetails.getAuthorities());

				authToken.setDetails(new JWTokenAuthenticationDetailSource().buildDetails(request));
				context.setAuthentication(authToken);

				SecurityContextHolder.setContext(context);
			}

			filterChain.doFilter(request, response);
		} catch (MalformedJwtException e) {
			logger.error(
					"Error while handling the token:", e);
			throw new BadCredentialsException("Error while handling the token.", e);
		} catch (ExpiredJwtException e) {
			logger.error("Error while logging in: expired token.", e);
			throw e;
		} catch (Exception e) {
			logger.error("Error while handling the token.", e);
			throw e;
		}

	}

}
