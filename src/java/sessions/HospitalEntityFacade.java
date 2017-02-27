/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.HospitalEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Jerry
 */
@Stateless
public class HospitalEntityFacade extends AbstractFacade<HospitalEntity> {

    @PersistenceContext(unitName = "HermesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HospitalEntityFacade() {
        super(HospitalEntity.class);
    }
    
    public boolean creatHospital(HospitalEntity h){
        HospitalEntity hospital = em.find(HospitalEntity.class, h.getHospitalName());
        if(hospital == null ){
                   em.persist(h);
                   return true; 
        }
        else{
            return false;
        }
    }
    
    public List<HospitalEntity> getlistHospital(){
        Query tmp = em.createNamedQuery("HospitalEntity.findAll",HospitalEntity.class);
        return tmp.getResultList();   
    }
    
    public boolean deleteHosp(HospitalEntity h){
        HospitalEntity hospital = em.find(HospitalEntity.class, h.getHospitalName());
        if(hospital != null){
            //hospital = (HospitalEntity)em.merge(hospital);
            em.remove(hospital);
            return true;
        }
        else{
            return false;
        }
    }
}
