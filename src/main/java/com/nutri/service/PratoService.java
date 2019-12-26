package com.nutri.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nutri.domain.Prato;
import com.nutri.dto.ComidaDto;
import com.nutri.dto.PratoDto;

@Service
public class PratoService {

	public List<PratoDto> converter(List<Prato> pratos) {

		List<PratoDto> p = new ArrayList<PratoDto>();
		pratos.forEach(x -> {
			PratoDto dto = new PratoDto();
			dto.setCaloriasTotal(x.getCaloriasTotal());
			dto.setData(x.getData());
			dto.setId(x.getId());

			List<ComidaDto> a = new ArrayList<ComidaDto>();

			x.getComida().forEach(f -> {
				ComidaDto g = new ComidaDto();
				g.setCaloria(f.getAlimento().getCaloria());
				g.setNome(f.getAlimento().getNome());
				g.setPeso(f.getPeso());
				a.add(g);
			});
			dto.setComidas(a);
			p.add(dto);
		});

		return p;
	}

}
