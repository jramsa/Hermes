/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.PrescriptionEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Olivier
 */
@Stateless
public class PrescriptionEntityFacade extends AbstractFacade<PrescriptionEntity> {

    @PersistenceContext(unitName = "HermesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PrescriptionEntityFacade() {
        super(PrescriptionEntity.class);
    }
    
    public boolean createPrescription(PrescriptionEntity prescription){
        PrescriptionEntity p = em.find(PrescriptionEntity.class, prescription.getIdPrescription());
        em.persist(prescription);
        return true;        
    }
}
