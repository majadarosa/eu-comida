package com.geosapiens.eu_comida.security.auth.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geosapiens.eu_comida.security.auth.SigninRequest;
import com.geosapiens.eu_comida.security.auth.service.AuthenticationService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	
	static private final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

	@Autowired
	private AuthenticationService authenticationService;
	
	@PostMapping("/login")
	public ResponseEntity<Object> signin(@RequestBody SigninRequest request) {
		try {
			
			logger.info("inicio login: " + request.getEmail());
			
			return ResponseEntity.ok(authenticationService.signin(request));
			
		} catch (BadCredentialsException e) {
			return new ResponseEntity<Object>(HttpStatus.UNAUTHORIZED);
		}
	}
	
}
