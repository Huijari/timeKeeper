package br.com.avenuecode.grupo5.timeKeeper.controller;

import br.com.avenuecode.grupo5.timeKeeper.daos.PontoDao;
import br.com.avenuecode.grupo5.timeKeeper.daos.UsuarioDao;
import br.com.avenuecode.grupo5.timeKeeper.entities.Ponto;
import br.com.avenuecode.grupo5.timeKeeper.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.Calendar;

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
    public Ponto baterPonto(@PathVariable long usuarioId) {
        Ponto ponto;

        Usuario usuario = usuarioDao.get(usuarioId);
        if (usuario.getPontos().isEmpty()) {
            ponto = new Ponto();
            ponto.setEntrada(Calendar.getInstance());
            usuario.getPontos().add(ponto);
        } else {
            Ponto ultimo = usuario.getPontos().get(usuario.getPontos().size() - 1);
            if (ultimo.getSaida() != null) {
                ponto = new Ponto();
                ponto.setEntrada(Calendar.getInstance());
                usuario.getPontos().add(ponto);
            } else {
                ponto = ultimo;
                ponto.setSaida(Calendar.getInstance());
            }
        }

        pontoDao.save(ponto);
        usuarioDao.save(usuario);

        return ponto;
    }
}
