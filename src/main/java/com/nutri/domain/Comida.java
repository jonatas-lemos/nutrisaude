package com.nutri.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Data
public class Comida {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer peso;
	
	@ManyToOne
	@JoinColumn(name = "alimento_id")
	@JsonManagedReference
	private Alimento alimento;

	@ManyToOne
	@JoinColumn(name = "prato_id")
	@JsonManagedReference
	private Prato prato;

}
