/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.UserEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    
}
