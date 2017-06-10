package br.com.avenuecode.grupo5.timeKeeper.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.avenuecode.grupo5.timeKeeper.entities.Usuario;

@RestController
public class UsuarioController {
	
	@RequestMapping(path = "/usuario")
	public Usuario save(Usuario usuario){
		return usuario;		
	}
	
	@RequestMapping(path = "/usuario")
	public Usuario update(@RequestParam(value="usuario") Usuario usuario){
		return usuario;
	}

}
