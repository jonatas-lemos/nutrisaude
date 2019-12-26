package com.nutri.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nutri.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	public Optional<Usuario> findByEmail(String email);

    @Query("select u FROM Usuario u where u.email = :email AND u.senha = :senha ")
	public Optional<Usuario> login(String email, String senha);

}
