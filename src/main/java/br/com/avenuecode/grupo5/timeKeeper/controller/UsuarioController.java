package br.com.avenuecode.grupo5.timeKeeper.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.avenuecode.grupo5.timeKeeper.entities.Usuario;

import javax.xml.ws.Response;

@RestController
public class UsuarioController {
	
	@RequestMapping(path = "/usuario")
	public Usuario save(Usuario usuario){
		return usuario;		
	}
	
	@RequestMapping(path = "/usuario")
	public Usuario update(@RequestParam(value="usuario") Usuario usuario) {
		return usuario;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Usuario> listar(@PathVariable("id") Integer id){
		Usuario usuario = usuarios.get(id);

		if(usuario == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else{
			return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
		}
}
