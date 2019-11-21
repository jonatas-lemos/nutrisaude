package com.nutri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nutri.domain.Comida;

public interface ComidaRepository extends JpaRepository<Comida, Long> {

}
