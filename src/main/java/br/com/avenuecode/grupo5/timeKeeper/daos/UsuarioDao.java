package br.com.avenuecode.grupo5.timeKeeper.daos;

import br.com.avenuecode.grupo5.timeKeeper.entities.Usuario;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UsuarioDao {

    @PersistenceContext
    private EntityManager manager;


    public void save(Usuario usuario) {
        manager.persist(usuario);
    }

    public void update(Usuario usuario) {
        manager.merge(usuario);
    }

    public Usuario get(long id) {
        return manager.find(Usuario.class, id);
    }

    public Usuario getByLogin(String login) {
        String query = new StringBuilder()
                .append("FROM Usuario usuario WHERE usuario.login = '")
                .append(login)
                .append("'")
                .toString();

        System.out.println(query);

        try {
            return (Usuario) manager
                    .createQuery(query)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public List<Usuario> list() {
        return manager.createQuery("FROM Usuario").getResultList();
    }
}
