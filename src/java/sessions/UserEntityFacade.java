/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.JobEntity;
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
