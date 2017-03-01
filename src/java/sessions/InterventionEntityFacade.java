/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.InterventionEntity;
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
public class InterventionEntityFacade extends AbstractFacade<InterventionEntity> {

    @PersistenceContext(unitName = "HermesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InterventionEntityFacade() {
        super(InterventionEntity.class);
    }
    
    public boolean createIntervention(InterventionEntity intervention){
        InterventionEntity i = em.find(InterventionEntity.class, intervention.getIdIntervention());
        em.persist(intervention);
        return true;        
    }
    
    public List<Object[]> getListInterMed(String mail){
        Query query = em.createNativeQuery("SELECT i.idIntervention, p.firsnamePatient,p.lastnamePatient,i.dateEdition, it.interventionName, i.dateIntervention, it.priceIntervention,i.reportIntervention FROM Intervention i, InterventionType it, Patient p, hasIntervention h, User u WHERE h.mailUser=u.mailUser AND p.socialSecurityId=h.socialSecurityId AND h.idIntervention=i.idIntervention AND i.idInterventionType=it.idInterventionType AND u.mailUser ='"+ mail +"'");
        List <Object[]> list = query.getResultList();
        return list; 
    }
}
