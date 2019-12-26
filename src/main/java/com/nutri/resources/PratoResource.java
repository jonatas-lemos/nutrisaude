package com.nutri.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nutri.domain.Prato;
import com.nutri.dto.PratoDto;
import com.nutri.repository.PratoRepository;
import com.nutri.service.PratoService;

@RestController
@RequestMapping("/prato")
public class PratoResource {

	@Autowired
	private PratoRepository pratoRepository;
	@Autowired
	private PratoService pratoService;

	@GetMapping("/{id}")
	public List<PratoDto> listar(@PathVariable("id") Long id) {
		List<Prato> pratos = pratoRepository.buscar(id);
		return pratoService.converter(pratos);
	}
	
	
}
