package com.nutri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nutri.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
