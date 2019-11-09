package com.nutri.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Data
public class Prato {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private BigDecimal caloriasTotal;
	private LocalDate data;
	
	@OneToMany(mappedBy = "prato", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonBackReference
	private List<Comida> comida;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	@JsonManagedReference
	private Usuario usuario;


}
