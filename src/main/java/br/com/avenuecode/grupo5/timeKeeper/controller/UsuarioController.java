package br.com.avenuecode.grupo5.timeKeeper.controller;

import br.com.avenuecode.grupo5.timeKeeper.daos.UsuarioDao;
import br.com.avenuecode.grupo5.timeKeeper.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sun.misc.Request;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuario")
@Transactional
@CrossOrigin("http://localhost:8081")
public class UsuarioController {

	@Autowired
	private UsuarioDao usuarioDAO;

	@PostMapping
	public Usuario save(@Valid @RequestBody Usuario usuario, BindingResult bindingResult) {
		usuarioDAO.save(usuario);
		return usuario;
	}

	@PutMapping(path = "/{id}")
	public Usuario update(@PathVariable("id") long id, @Valid Usuario usuario, BindingResult bindingResult) {
		usuarioDAO.update(usuario);
		return usuario;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Usuario> listar(@PathVariable("id") long id) {
		Usuario usuario = usuarioDAO.get(id);

		if (usuario == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
		}
	}

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public List<Usuario> listarTodos() {
        return usuarioDAO.list();
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
	public Usuario login(@RequestBody Usuario login) {
		Usuario usuario = usuarioDAO.getByLogin(login.getLogin());
		if (usuario == null) {
			usuario = new Usuario();
			usuario.setLogin(login.getLogin());
			usuario.setProfile(Usuario.Profile.BASIC);
			usuario.setJornadaDiaria(8);
			usuarioDAO.save(usuario);
		}
		return usuario;
	}
}
