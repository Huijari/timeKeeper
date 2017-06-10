package br.com.avenuecode.grupo5.timeKeeper.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.avenuecode.grupo5.timeKeeper.daos.UsuarioDao;
import br.com.avenuecode.grupo5.timeKeeper.entities.Usuario;

@Controller
@RequestMapping("/usuario")
@Transactional
public class UsuarioController {
	
   @Autowired
   private UsuarioDao usuarioDAO;
	
   @PostMapping
	public Usuario save(@Valid Usuario usuario, BindingResult bindingResult){	   
		usuarioDAO.save(usuario);
		return usuario;		
	}
	
	@RequestMapping(path = "/{id}")
	public Usuario update(@PathVariable("id") Integer id, @Valid Usuario usuario, BindingResult bindingResult){
		usuarioDAO.update(usuario);
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
