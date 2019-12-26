package com.nutri.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nutri.domain.Usuario;
import com.nutri.repository.UsuarioRepository;

@RestController
@RequestMapping("/auth")
public class UsuarioResource {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping("/login/{email}/{senha}")
	public ResponseEntity<?> logar(@PathVariable("email") String email, @PathVariable("senha") String senha) {
		Optional<Usuario> usuario = usuarioRepository.login(email, senha);
		if (usuario.isPresent()) {
			return new ResponseEntity<Usuario>(usuario.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Usuario>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
