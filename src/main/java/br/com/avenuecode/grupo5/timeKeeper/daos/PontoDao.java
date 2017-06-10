package br.com.avenuecode.grupo5.timeKeeper.daos;

import br.com.avenuecode.grupo5.timeKeeper.entities.Ponto;
import br.com.avenuecode.grupo5.timeKeeper.entities.Usuario;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by huijari on 6/10/17
 */

@Repository
public class PontoDao {

    @PersistenceContext
    private EntityManager manager;

    public void save(Ponto ponto) {
        manager.persist(ponto);
    }
}
