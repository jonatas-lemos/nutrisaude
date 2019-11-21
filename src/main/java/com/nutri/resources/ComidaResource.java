package com.nutri.resources;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nutri.dto.RefeicaoDTO;
import com.nutri.repository.ComidaRepository;
import com.nutri.service.AlimentoService;

@RestController
@RequestMapping("/comida")
public class ComidaResource {

	@Autowired
	private AlimentoService alimentoService;
	
	@PostMapping
	public BigDecimal criar(@RequestBody RefeicaoDTO refeicao) {
		return alimentoService.criarRefeicao(refeicao);
	}
}
