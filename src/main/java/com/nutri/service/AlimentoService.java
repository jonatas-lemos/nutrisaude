package com.nutri.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nutri.domain.Alimento;
import com.nutri.domain.Comida;
import com.nutri.domain.Prato;
import com.nutri.domain.Usuario;
import com.nutri.dto.AlimentoDto;
import com.nutri.dto.RefeicaoDTO;
import com.nutri.repository.AlimentoRepository;
import com.nutri.repository.ComidaRepository;
import com.nutri.repository.PratoRepository;
import com.nutri.repository.UsuarioRepository;

@Service
public class AlimentoService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PratoRepository pratoRepository;
	@Autowired
	private AlimentoRepository alimentoRepository;
	@Autowired
	private ComidaRepository comidaRepository;
	
	
	public Prato criarRefeicao(RefeicaoDTO d) {
		Usuario u = usuarioRepository.findById(d.getIdUsuario()).get();
		Prato p = new Prato();
		p.setUsuario(u);
		p.setData(LocalDate.now());
		p = pratoRepository.save(p);
		
		Integer soma =	0;
		for(AlimentoDto dto: d.getAlimentos()) {
			Alimento a = alimentoRepository.findById(dto.getId()).get();
			Comida c = new Comida();
			c.setAlimento(a);
			c.setPeso(dto.getPeso());
			c.setPrato(p);
			comidaRepository.save(c);
			soma+=calcularCaloria(dto, a);
		}
		p.setCaloriasTotal(soma);
		p = pratoRepository.save(p);
		
		return p; 
		
	}

	

	public Integer calcularCaloria(AlimentoDto d, Alimento a) {
		Integer division = d.getPeso()/100;
		Integer m = a.getCaloria()*division; 
		return m;
	}

	
	
}
