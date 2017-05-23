/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Experiencialaboral;
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
public class ExperiencialaboralFacade extends AbstractFacade<Experiencialaboral> {

    @PersistenceContext(unitName = "RedSocialG01-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ExperiencialaboralFacade() {
        super(Experiencialaboral.class);
    }
    
    public List<Experiencialaboral> findExperienciaslaboralesPoridUsuario(int id) {
        Query q; 
        
        q = em.createQuery("select exp from Experiencialaboral exp where exp.expLaboralUsuarioFK.idUsuario = :id");
        q.setParameter("id",  id);
        return q.getResultList();
    }
    
   
    public void borrarExperienciaLaboral(int id) {
        Query q; 
        
        q = em.createQuery("DELETE FROM Experiencialaboral exp where exp.idExperienciaLaboral = :id");
        q.setParameter("id",  id);
        
        int count = q.executeUpdate();
    }
}
