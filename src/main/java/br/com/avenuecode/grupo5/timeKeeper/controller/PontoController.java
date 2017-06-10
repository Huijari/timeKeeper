package br.com.avenuecode.grupo5.timeKeeper.controller;

import br.com.avenuecode.grupo5.timeKeeper.daos.PontoDao;
import br.com.avenuecode.grupo5.timeKeeper.daos.UsuarioDao;
import br.com.avenuecode.grupo5.timeKeeper.entities.Ponto;
import br.com.avenuecode.grupo5.timeKeeper.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

/**
 * Created by huijari on 6/10/17
 */
@RestController
@RequestMapping("/usuario/{usuarioId}/ponto")
@Transactional
public class PontoController {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private PontoDao pontoDao;

    @PostMapping
    public Ponto baterPonto(@PathVariable long usuarioId, @RequestBody Ponto ponto) {
        pontoDao.save(ponto);
        Usuario usuario = usuarioDao.get(usuarioId);
        usuario.getPontos().add(ponto);
        usuarioDao.update(usuario);
        return ponto;
    }

}
