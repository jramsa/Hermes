/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.InterventiontypeEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Olivier
 */
@Stateless
public class InterventiontypeEntityFacade extends AbstractFacade<InterventiontypeEntity> {

    @PersistenceContext(unitName = "HermesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InterventiontypeEntityFacade() {
        super(InterventiontypeEntity.class);
    }
    
    public List<InterventiontypeEntity> getlistIntervention(){
        Query tmp = em.createNamedQuery("InterventiontypeEntity.findAll",InterventiontypeEntity.class);
        return tmp.getResultList();   
    }
    
    public InterventiontypeEntity findInterventionByName(String intervention){
        Query tmp = em.createNamedQuery("InterventiontypeEntity.findByInterventionName",InterventiontypeEntity.class);
        tmp.setParameter("interventionName", intervention);
        return (InterventiontypeEntity)tmp.getSingleResult();
    }
       
}
