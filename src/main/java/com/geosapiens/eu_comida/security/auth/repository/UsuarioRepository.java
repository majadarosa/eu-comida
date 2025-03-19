package com.geosapiens.eu_comida.security.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.geosapiens.eu_comida.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	@Query(value = "SELECT usuario " +
			"FROM Usuario usuario "
			+ " where usuario.email = :username ")
	public Usuario findByUsername(String username);
	}
