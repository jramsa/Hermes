/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.HasprescriptionEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Olivier
 */
@Stateless
public class HasprescriptionEntityFacade extends AbstractFacade<HasprescriptionEntity> {

    @PersistenceContext(unitName = "HermesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HasprescriptionEntityFacade() {
        super(HasprescriptionEntity.class);
    }
    
    public boolean createHasPrescription(String socialSecurityId, int idPrescription, String mailUser) {
        HasprescriptionEntity p = new HasprescriptionEntity(socialSecurityId, idPrescription, mailUser);
        em.persist(p);
        return true;
    }
}
