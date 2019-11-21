package com.nutri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nutri.domain.Prato;

public interface PratoRepository extends JpaRepository<Prato, Long> {

}
