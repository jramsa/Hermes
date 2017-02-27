/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.HasInterventionEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jerry
 */
@Stateless
public class HasInterventionEntityFacade extends AbstractFacade<HasInterventionEntity> {

    @PersistenceContext(unitName = "HermesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HasInterventionEntityFacade() {
        super(HasInterventionEntity.class);
    }
    
    public boolean createHasIntervention(String socialSecurityId, int idIntervention, String mailUser) {
        HasInterventionEntity p = new HasInterventionEntity (socialSecurityId, idIntervention, mailUser);
        em.persist(p);
        return true;
    }
    
}
