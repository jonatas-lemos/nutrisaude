package com.nutri.dto;

import java.util.List;

import lombok.Data;

@Data
public class RefeicaoDTO {
	private Long idUsuario;
	private List<AlimentoDto> alimentos;
}
