/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.NoteTypeEntity;
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
public class NoteTypeEntityFacade extends AbstractFacade<NoteTypeEntity> {

    @PersistenceContext(unitName = "HermesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NoteTypeEntityFacade() {
        super(NoteTypeEntity.class);
    }
    
    public List<NoteTypeEntity> getlistNotes(){
        Query tmp = em.createNamedQuery("NoteTypeEntity.findAll",NoteTypeEntity.class);
        return tmp.getResultList();   
    }
    
    public NoteTypeEntity findNoteByName(String note){
        Query tmp = em.createNamedQuery("NoteTypeEntity.findByNoteName",NoteTypeEntity.class);
        tmp.setParameter("noteName", note);
        return (NoteTypeEntity)tmp.getSingleResult();
    }   
    
    public List<NoteTypeEntity> getListNoteType(){
        Query tmp = em.createNamedQuery("NoteTypeEntity.findAll",NoteTypeEntity.class);
        return tmp.getResultList();   
    }
    
    //a corriger
    public List<Object[]> getListInterventionMed(String mail){
        Query query = em.createQuery("SELECT n.idNote, n.dateNote, n.note"+" FROM NoteEntity n");
        List <Object[]> list = query.getResultList();
        return list; 
    }
}
