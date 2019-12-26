package com.nutri.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nutri.domain.Comida;
import com.nutri.domain.Prato;
import com.nutri.dto.RefeicaoDTO;
import com.nutri.repository.ComidaRepository;
import com.nutri.service.AlimentoService;

@RestController
@RequestMapping("/comida")
public class ComidaResource {

	@Autowired
	private AlimentoService alimentoService;
	@Autowired
	private ComidaRepository a;
	
	@PostMapping
	public Prato criar(@RequestBody RefeicaoDTO refeicao) {
		return alimentoService.criarRefeicao(refeicao);
	}
	@GetMapping
	public List<Comida> listar() {
		return a.findAll();
	}
}
