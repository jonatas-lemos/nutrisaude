package com.nutri.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class PratoDto {

	
	private Long id;
	private Integer caloriasTotal;
	private LocalDate data;
	private List<ComidaDto> comidas;
}
