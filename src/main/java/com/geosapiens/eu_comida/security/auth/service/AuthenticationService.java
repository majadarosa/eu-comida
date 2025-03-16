package com.geosapiens.eu_comida.security.auth.service;

import com.geosapiens.eu_comida.security.auth.JwtAuthenticationResponse;
import com.geosapiens.eu_comida.security.auth.SigninRequest;

public interface AuthenticationService {
	JwtAuthenticationResponse signin(SigninRequest request);

	JwtAuthenticationResponse signup(SigninRequest request);
}
