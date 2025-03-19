package com.geosapiens.eu_comida.security.auth.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.geosapiens.eu_comida.security.auth.JwtAuthenticationResponse;
import com.geosapiens.eu_comida.security.auth.Login;
import com.geosapiens.eu_comida.security.auth.SigninRequest;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	static private final Logger logger = LoggerFactory.getLogger(AuthenticationServiceImpl.class);
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	
	@Override
	public JwtAuthenticationResponse signup(SigninRequest request) {
		
		Login user = new Login(request.getEmail(), passwordEncoder.encode(request.getPassword()), null);
		
		String jwt = jwtService.generateToken(user);
		
		JwtAuthenticationResponse authenticationResponse = new JwtAuthenticationResponse();
		authenticationResponse.setToken(jwt);
		
		return authenticationResponse;
	}

	
	@Override
	public JwtAuthenticationResponse signin(SigninRequest request) {
				
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        
		Login login = new Login(request.getEmail(), request.getPassword(), null);
		String jwt = jwtService.generateToken(login);
		
		JwtAuthenticationResponse authenticationResponse = new JwtAuthenticationResponse();
		authenticationResponse.setToken(jwt);
		
        
		return authenticationResponse; 
	}
	
	
	
}
