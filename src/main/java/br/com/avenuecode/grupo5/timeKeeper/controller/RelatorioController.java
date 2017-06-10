package br.com.avenuecode.grupo5.timeKeeper.controller;

import br.com.avenuecode.grupo5.timeKeeper.daos.UsuarioDao;
import br.com.avenuecode.grupo5.timeKeeper.entities.Usuario;
import br.com.avenuecode.grupo5.timeKeeper.service.Relatorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

/**
 * Created by xa0 on 10/06/17.
 */

@RestController
@RequestMapping("/usuario/{usuarioId}/relatorio")
@Transactional
public class RelatorioController {
    @Autowired
    private UsuarioDao usuarioDao;

    @GetMapping
    public ResponseEntity<Relatorio> gerar(@PathVariable long usuarioId) {
        Usuario usuario = usuarioDao.get(usuarioId);
        Relatorio relatorio = new Relatorio(usuario);

        if (relatorio == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Relatorio>(relatorio, HttpStatus.OK);
        }
    }
}
