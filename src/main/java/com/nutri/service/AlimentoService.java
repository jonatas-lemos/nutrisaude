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
	
	
	public BigDecimal criarRefeicao(RefeicaoDTO d) {
		Usuario u = usuarioRepository.findById(d.getIdUsuario()).get();
		Prato p = new Prato();
		p.setUsuario(u);
		p.setData(LocalDate.now());
		p = pratoRepository.save(p);
		
		BigDecimal soma = new BigDecimal(0);
		for(AlimentoDto dto: d.getAlimentos()) {
			Alimento a = alimentoRepository.findById(dto.getId()).get();
			Comida c = new Comida();
			c.setAlimento(a);
			c.setPeso(dto.getPeso());
			c.setPrato(p);
			comidaRepository.save(c);
			soma.add(calcularCaloria(dto, a));
		}
		
		p.setCaloriasTotal(soma);
		p = pratoRepository.save(p);
		
		return p.getCaloriasTotal(); 
		
	}

	

	public BigDecimal calcularCaloria(AlimentoDto d, Alimento a) {
		return a.getCaloria().multiply(new BigDecimal((d.getPeso()/100)));
	}

	
	
}
