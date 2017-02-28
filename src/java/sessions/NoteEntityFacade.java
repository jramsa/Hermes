/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.NoteEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jerry
 */
@Stateless
public class NoteEntityFacade extends AbstractFacade<NoteEntity> {

    @PersistenceContext(unitName = "HermesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NoteEntityFacade() {
        super(NoteEntity.class);
    }
    
    public boolean createNote(NoteEntity note){
        NoteEntity n = em.find(NoteEntity.class, note.getIdNote());
        em.persist(note);
        return true;        
    }
    
}
