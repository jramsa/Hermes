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
      
      public int addServToHub(String nameHosp,String nameHub, String nameServ){
        Query query = em.createNativeQuery("INSERT INTO hasService(idHub,idService) VALUES ((SELECT h.idHub FROM Hub h, Hospital hosp, hasHub WHERE h.hubName ='"+nameHub+ "' AND h.idHub=hasHub.idHub AND hasHub.hospitalName=hosp.hospitalName and hosp.hospitalName= '"+nameHosp+ "' ), (SELECT idService FROM Service s WHERE s.serviceName='"+ nameServ+ "'))");
        return query.executeUpdate();    
    }
      
      public int addUserToServ(String nameServ, String nameUser){
        Query query = em.createNativeQuery("INSERT INTO WorkIn(mailUser,idService) VALUES ('"+nameUser+ "', (SELECT idService FROM Service s WHERE s.serviceName='"+ nameServ+ "'))");
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
      
      public List<Object[]> onListServHasServChange(String nameHub){
        Query query = em.createNativeQuery("SELECT serviceName FROM Service s, hasService has, Hub h WHERE s.idService=has.idService AND has.idHub=h.idHub AND hubName = '"+ nameHub +"'");
        return query.getResultList();    
    }
      
      public int removeHubToHospital(String nameHosp,String nameHub){
        Query query = em.createNativeQuery("DELETE FROM hasHub WHERE hospitalName='"+ nameHosp +"' AND idHub=(SELECT idHub from Hub WHERE Hub.hubName='"+ nameHub+ "')");
        return query.executeUpdate();    
    }
      
      public List<Object[]> aGetListServ(){
        Query query = em.createNativeQuery("SELECT serviceName FROM Service");
        return query.getResultList();    
    }
      
      public List<Object[]> onListUserChange(){
        Query query = em.createNativeQuery("SELECT mailUser FROM User");
        return query.getResultList();    
    }
      
}
