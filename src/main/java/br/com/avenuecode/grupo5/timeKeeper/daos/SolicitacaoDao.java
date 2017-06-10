package br.com.avenuecode.grupo5.timeKeeper.daos;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.com.avenuecode.grupo5.timeKeeper.entities.Solicitacao;

/**
 * Created by xa0 on 10/06/17.
 */
@Repository
public class SolicitacaoDao {
    @PersistenceContext
    private EntityManager manager;

    public void save(Solicitacao solicitacao){
        manager.persist(solicitacao);
    }

    public Solicitacao get(long id){
        return manager.find(Solicitacao.class, id);
    }

    public Solicitacao update(Solicitacao solicitacao){
       return manager.merge(solicitacao);
    }
}
