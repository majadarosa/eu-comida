package com.geosapiens.eu_comida.security.auth.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

import org.hibernate.tuple.entity.VersionProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.geosapiens.eu_comida.entity.Usuario;
import com.geosapiens.eu_comida.security.auth.Login;
import com.geosapiens.eu_comida.security.auth.repository.UsuarioRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetailsService userDetailsService() {
		return new UserDetailsService() {
			@Override
			public UserDetails loadUserByUsername(String username) {

				Usuario usuario = usuarioRepository.findByUsername(username);
				if (usuario != null)
					return new Login(username, usuario.getPassword(), usuario.getRole());

				throw new UsernameNotFoundException("User not found");
			}
		};
	}

}
