/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.JobEntity;
import entities.HospitalEntity;
import entities.UserEntity;
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
public class UserEntityFacade extends AbstractFacade<UserEntity> {

    @PersistenceContext(unitName = "HermesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserEntityFacade() {
        super(UserEntity.class);
    }
    
    public int createUser(UserEntity u){
        UserEntity tmp = em.find(UserEntity.class,u.getMailUser());
        if(tmp==null){
            em.persist(u);
            return 1;
        }
        return 0;
    }
    
    public UserEntity findUser(UserEntity u){
        return em.find(UserEntity.class,u.getMailUser());
    }
    
    public boolean deleteUser(UserEntity u){
        UserEntity tmp = em.find(UserEntity.class,u.getMailUser());
        if(tmp!=null){
            em.remove(u);
            return true;
        }
        return false;
    }

    public String getUserHub(UserEntity u) {
        Query q = em.createNativeQuery("SELECT h.hubName FROM hub h JOIN hasservice hs ON hs.idHub = h.idHub JOIN service s ON s.idService = hs.idService WHERE s.serviceName = \""+getUserService(u)+"\"");
        List<String> hubList = q.getResultList();
        if (hubList.isEmpty()) {
            return "Non spécifié";
        }
        return hubList.get(0);
    }

    public String getUserService(UserEntity u) {
        Query q = em.createNativeQuery("SELECT s.serviceName FROM user u JOIN workin w ON w.mailUser = u.mailUser JOIN service s ON s.idService = w.idService WHERE u.mailUser = \""+u.getMailUser()+"\"");
        List<String> serviceList = q.getResultList();
        if (serviceList.isEmpty()) {
            return "Non spécifié";
        }
        return serviceList.get(0);
    }

    public HospitalEntity getUserHospitalEntity(UserEntity u) {
        System.out.println(getUserHub(u));
        Query q = em.createNativeQuery("SELECT hh.hospitalName FROM hashub hh JOIN hub h ON hh.idHub = h.idHub WHERE h.hubName = \""+getUserHub(u)+"\"");
        List<String> hospitalList = q.getResultList();
        if (hospitalList.isEmpty()) {
            System.out.println("empty");
            return null;
        }
        System.out.println(hospitalList.get(0));
        return em.find(HospitalEntity.class, hospitalList.get(0));
    }
    
    
    
    public int getRoleUser(String role){
        Query query = em.createNativeQuery("SELECT idJob FROM Job WHERE jobName='"+ role +"'");
        return (int)query.getSingleResult();    
    }
    
    public List<Object[]> listRole(){
        Query query = em.createNativeQuery("SELECT jobName FROM Job");
        return query.getResultList();    
    }
    
    public JobEntity findRole (int j) {
        JobEntity job = em.find(JobEntity.class, j);
        return job;
    }
    
}
