package com.nutri.dto;

import java.util.List;


public class RefeicaoDTO {
	private Long idUsuario;
	private List<AlimentoDto> alimentos;

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public List<AlimentoDto> getAlimentos() {
		return alimentos;
	}

	public void setAlimentos(List<AlimentoDto> alimentos) {
		this.alimentos = alimentos;
	}

}
