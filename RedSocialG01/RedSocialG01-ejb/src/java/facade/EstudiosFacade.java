/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Estudios;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Usuario
 */
@Stateless
public class EstudiosFacade extends AbstractFacade<Estudios> {

    @PersistenceContext(unitName = "RedSocialG01-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstudiosFacade() {
        super(Estudios.class);
    }

    public List<Estudios> findEstudiosPoridUsuario(int idLista) {
        Query q; 
        
        q = em.createQuery("select est from Estudios est where est.estudiosUsuarioFK.idUsuario = :id");
        q.setParameter("id",  idLista);
        return q.getResultList();
    }
    
//    public Estudios findEstudioPorIdEstudio(int id)
//    {
//        Query q;
//        
//        q = em.createQuery("select est from Estudios est where est.idEstudios = :id");
//        q.setParameter("id", id);
//        return (Estudios) q.getSingleResult();
//    }
    
    public void borrarEstudio(int id) {
        Query q;
        
        q = em.createQuery("delete from Estudios est where est.idEstudios = :id");
        q.setParameter("id",  id);
        
        int count = q.executeUpdate();
    }
}
