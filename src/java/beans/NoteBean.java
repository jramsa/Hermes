/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.NoteEntity;
import entities.NoteTypeEntity;
import javax.inject.Named;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedProperty;
import sessions.NoteTypeEntityFacade;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import org.primefaces.context.RequestContext;
import sessions.HasNoteEntityFacade;
import sessions.NoteEntityFacade;

/**
 *
 * @author Jerry
 */
@Named(value = "noteBean")
@SessionScoped
@ManagedBean
public class NoteBean implements Serializable {
    
    @EJB
    NoteTypeEntityFacade noteTypeFacade;
    
    @EJB
    NoteEntityFacade noteFacade;
    
    @EJB
    HasNoteEntityFacade hasNotefacade;
    
    @ManagedProperty(value="#{userBean}")
    private UserBean user;
    
    @ManagedProperty(value="#{patientBean}")
    private PatientBean patient;
    
    private NoteTypeEntity noteType;
    private NoteEntity note;
    private String name;
    
    /**
     * Creates a new instance of NoteBean
     */
    public NoteBean() {
        noteType = new NoteTypeEntity(); 
        note = new NoteEntity();
    }
    
    private List <NoteTypeEntity> listNoteType = new ArrayList<>();
    public List<NoteTypeEntity> aListNoteType(){
        setList(noteTypeFacade.getListNoteType());
        ArrayList<NoteTypeEntity> tmp = new ArrayList<>();
        for(NoteTypeEntity p:getList()){
                tmp.add(p);
        }
        return tmp;
    }
    
    private List <Object[]> listNoteUser = new ArrayList<>();
    public List<Object[]> aListNoteView(){
        setListNoteUser(noteTypeFacade.getListInterventionMed(getUser().getUser().getMailUser()));
        ArrayList<Object[]> tmp = new ArrayList<>();
        for(Object[] o :getListNoteUser()){
                tmp.add(o);
        }
        return tmp;
        
    }
    
    public List<NoteTypeEntity> listNotes(){
        return noteTypeFacade.getlistNotes();
    }
    
    public void setDate(){      
        getNote().setDateNote(new java.util.Date());
    }
    
    public String createNote() {       
        NoteTypeEntity typenote = noteTypeFacade.findNoteByName(name);
        setDate();
        getNote().setIdNote(ThreadLocalRandom.current().nextInt(1, Integer.MAX_VALUE));
        note.setIdNoteType(typenote);
        boolean created = noteFacade.createNote(getNote());hasNotefacade.createHasNote(patient.getSelectedPatient().getSocialSecurityId(),user.getUser().getMailUser(),note.getIdNote());
        RequestContext context = RequestContext.getCurrentInstance();
        if (created==true){
            context.execute("swal('Félicitations','Note créée','success')");
            this.note = new NoteEntity();
            return "resultPatient";    
        }
        else {
            context.execute("swal('Oups...','Note non créée','error')");
            return "resultPatient";
        }
    }   


    public UserBean getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(UserBean user) {
        this.user = user;
    }

    /**
     * @return the patient
     */
    public PatientBean getPatient() {
        return patient;
    }

    /**
     * @param patient the patient to set
     */
    public void setPatient(PatientBean patient) {
        this.patient = patient;
    }

    /**
     * @return the noteType
     */
    public NoteTypeEntity getNoteType() {
        return noteType;
    }

    /**
     * @param noteType the noteType to set
     */
    public void setNoteType(NoteTypeEntity noteType) {
        this.noteType = noteType;
    }

    /**
     * @return the note
     */
    public NoteEntity getNote() {
        return note;
    }

    /**
     * @param note the note to set
     */
    public void setNote(NoteEntity note) {
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the list
     */
    public List <NoteTypeEntity> getList() {
        return listNoteType;
    }

    /**
     * @param list the list to set
     */
    public void setList(List <NoteTypeEntity> list) {
        this.listNoteType = list;
    }

    /**
     * @return the listNoteUser
     */
    public List <Object[]> getListNoteUser() {
        return listNoteUser;
    }

    /**
     * @param listNoteUser the listNoteUser to set
     */
    public void setListNoteUser(List <Object[]> listNoteUser) {
        this.listNoteUser = listNoteUser;
    }
    
}
