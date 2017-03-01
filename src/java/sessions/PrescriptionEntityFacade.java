/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.PrescriptionEntity;
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
    
    public List<Object[]> getListPrescriptionMed(String mail){
        Query query = em.createNativeQuery("SELECT pr.idPrescription, p.firsnamePatient,p.lastnamePatient,pr.datePrescription, pr.durationPrescription,pr.drugName,pr.quantityPrescription FROM Prescription pr,Patient p, hasPrescription h, User u WHERE h.mailUser=u.mailUser AND p.socialSecurityId=h.socialSecurityId AND h.idPrescription= pr.idPrescription AND u.mailUser ='"+ mail +"'");
        List <Object[]> list = query.getResultList();
        return list; 
    }
}
