package com.geosapiens.eu_comida.security.auth.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public interface JwtService {
	
	String extractDomain(String token);
	
    String extractUserName(String token);
    
    String generateToken(UserDetails userDetails);

    boolean isTokenValid(String token);	
}