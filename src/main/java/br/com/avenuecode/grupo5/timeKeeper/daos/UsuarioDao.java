package br.com.avenuecode.grupo5.timeKeeper.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.avenuecode.grupo5.timeKeeper.entities.Usuario;

import java.util.List;

@Repository
public class UsuarioDao
{

   @PersistenceContext
   private EntityManager manager;


   public void save(Usuario usuario)
   {
      manager.persist(usuario);
   }

   public void update(Usuario usuario)
   {
      manager.merge(usuario);
   }

   public Usuario get(long id){
      return manager.find(Usuario.class, id);
   }

   public List<Usuario> list() {
      return manager.createQuery("FROM Usuario").getResultList();
   }
}
