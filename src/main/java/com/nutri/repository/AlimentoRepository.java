package com.nutri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nutri.domain.Alimento;

public interface AlimentoRepository extends JpaRepository<Alimento, Long> {

}
