/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.HubEntity;
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
public class HubEntityFacade extends AbstractFacade<HubEntity> {

    @PersistenceContext(unitName = "HermesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HubEntityFacade() {
        super(HubEntity.class);
    }
    
    public List<HubEntity> getlistHub(){
        Query tmp = em.createNamedQuery("HubEntity.findAll",HubEntity.class);
        return tmp.getResultList();   
    }
    
    public HubEntity findHubByName(String name){
        Query tmp = em.createNamedQuery("HubEntity.findByHubName",HubEntity.class);
        tmp.setParameter("hubName", name);
        return (HubEntity)tmp.getSingleResult();
    }
    
      public int addHubToHospital(String nameHosp,String nameHub){
        Query query = em.createNativeQuery("INSERT INTO hasHub (hospitalName, idHub) VALUES ('"+ nameHosp +"', (SELECT idHub FROM Hub WHERE hubName='"+ nameHub + "'))");
        return query.executeUpdate();    
    }
    
      public List<Object[]> aGetListHospinHasHub(){
        Query query = em.createNativeQuery("SELECT DISTINCT hospitalName FROM hasHub");
        return query.getResultList();    
    }
      
      public List<Object[]> aGetListHubinHasHub(String nameHosp){
        Query query = em.createNativeQuery("SELECT hubName FROM Hub h, hasHub has WHERE h.idHub=has.idHub AND has.hospitalName = '"+ nameHosp +"'");
        return query.getResultList();    
    }
      public int removeHubToHospital(String nameHosp,String nameHub){
        Query query = em.createNativeQuery("DELETE FROM hasHub WHERE hospitalName='"+ nameHosp +"' AND idHub=(SELECT idHub from Hub WHERE Hub.hubName='"+ nameHub+ "')");
        return query.executeUpdate();    
    }
      
}
