package com.nutri.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nutri.domain.Comida;

public interface ComidaRepository extends JpaRepository<Comida, Long> {

	 @Query("select c FROM Comida c where c.prato.usuario.id = :idUsuario")
		public Optional<Comida> buscar(Long idUsuario);

}
