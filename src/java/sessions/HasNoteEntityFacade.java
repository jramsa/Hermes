/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.HasNoteEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jerry
 */
@Stateless
public class HasNoteEntityFacade extends AbstractFacade<HasNoteEntity> {

    @PersistenceContext(unitName = "HermesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HasNoteEntityFacade() {
        super(HasNoteEntity.class);
    }
    
    public boolean createHasNote(String socialSecurityId, String mailUser, int idNote) {
        HasNoteEntity p = new HasNoteEntity(socialSecurityId, mailUser, idNote);
        em.persist(p);
        return true;
    }
    
}
