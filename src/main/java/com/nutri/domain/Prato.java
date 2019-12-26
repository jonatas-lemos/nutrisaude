package com.nutri.domain;

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

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
public class Prato {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer caloriasTotal;
	private LocalDate data;
	
	@OneToMany(mappedBy = "prato", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Comida> comida;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	@JsonManagedReference
	private Usuario usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCaloriasTotal() {
		return caloriasTotal;
	}

	public void setCaloriasTotal(Integer caloriasTotal) {
		this.caloriasTotal = caloriasTotal;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public List<Comida> getComida() {
		return comida;
	}

	public void setComida(List<Comida> comida) {
		this.comida = comida;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


}
