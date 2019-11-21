package com.nutri.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nutri.domain.Prato;
import com.nutri.repository.PratoRepository;

@RestController
@RequestMapping("/prato")
public class PratoResource {

	@Autowired
	private PratoRepository pratoRepository;

	@GetMapping
	public List<Prato> listar() {
		return pratoRepository.findAll();
	}
	
}
