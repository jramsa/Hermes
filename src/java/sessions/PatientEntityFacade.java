/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.PatientEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Jerry
 */
@Stateless
public class PatientEntityFacade extends AbstractFacade<PatientEntity> {

    @PersistenceContext(unitName = "HermesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PatientEntityFacade() {
        super(PatientEntity.class);
    }
    
    public PatientEntity findPatient(PatientEntity p){
        return em.find(PatientEntity.class,p.getSocialSecurityId());
    }
    
    public int createPatient(PatientEntity p){
        PatientEntity tmp = em.find(PatientEntity.class,p.getSocialSecurityId());
        if(tmp==null){
            em.persist(p);
            return 1;
        }
        return 0;
    }
    
    public List<PatientEntity> getPatientsByName(String firstName,String lastName){
        Query tmp = em.createNamedQuery("PatientEntity.findAll",PatientEntity.class);
        return tmp.getResultList();   
    }
    
}
