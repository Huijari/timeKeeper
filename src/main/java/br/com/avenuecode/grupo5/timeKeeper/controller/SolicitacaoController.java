package br.com.avenuecode.grupo5.timeKeeper.controller;

import br.com.avenuecode.grupo5.timeKeeper.daos.SolicitacaoDao;
import br.com.avenuecode.grupo5.timeKeeper.daos.UsuarioDao;
import br.com.avenuecode.grupo5.timeKeeper.entities.Solicitacao;
import br.com.avenuecode.grupo5.timeKeeper.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

/**
 * Created by xa0 on 10/06/17.
 */

@RestController
@RequestMapping("/usuario/{usuarioId}/solicitacao")
@Transactional
public class SolicitacaoController {
    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private SolicitacaoDao solicitacaoDao;


    @PostMapping
    public Solicitacao save(@PathVariable long usuarioId, @RequestBody Solicitacao solicitacao){
        solicitacaoDao.save(solicitacao);
        Usuario usuario = usuarioDao.get(usuarioId);
        usuario.getSolicitacoes().add(solicitacao);
        usuarioDao.update(usuario);
        return solicitacao;
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Solicitacao solicitacao(@PathVariable("id") Integer id, @Valid Solicitacao solicitacao, BindingResult bindingResult){
        solicitacaoDao.update(solicitacao);
        return solicitacao;
    }
}
