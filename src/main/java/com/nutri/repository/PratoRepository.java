package com.nutri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nutri.domain.Prato;

public interface PratoRepository extends JpaRepository<Prato, Long> {

	 @Query("select p FROM Prato p where p.usuario.id = :idUsuario")
	 public List<Prato> buscar(Long idUsuario);

}
