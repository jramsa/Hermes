/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.PatientEntity;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import org.primefaces.context.RequestContext;
import sessions.PatientEntityFacade;
import java.util.List;
import javax.faces.bean.SessionScoped;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Jerry
 */
@Named(value = "patient")
@ManagedBean
@SessionScoped
public class PatientBean implements Serializable {
    
    @EJB     
    PatientEntityFacade facade;
    
    private PatientEntity patient;
    private List<PatientEntity> listPatient;
    private PatientEntity selectedPatient;

    /**
     * Creates a new instance of Patient
     */
    public PatientBean() {
        patient = new PatientEntity();
        listPatient = new ArrayList<>();
        selectedPatient = new PatientEntity();
    }
    
    public String selectPatient(SelectEvent event){
        this.selectedPatient = (PatientEntity) event.getObject();
        return "resultPatient";
    }
    
    
    public String createPatient() {
        int created = facade.createPatient(patient);
        RequestContext context = RequestContext.getCurrentInstance();
        if (created == 1) {
            context.execute("swal('Félicitations','Patient créé','success')");
            this.patient = new PatientEntity();
            return "nouveauPatient";
        } else {
            context.execute("swal('Oups...','Impossible de créer le patient','error')");
            return "nouveauPatient";
        }
    }
    
    
    
    public PatientEntity getPatient() {
        return patient;
    }

    /**
     * @param user the user to set
     */
    public void setPatient(PatientEntity user) {
        this.patient = user;
    }
    
    public List<PatientEntity> patientResult(){
        listPatient = facade.getPatientsByName(patient.getFirsnamePatient(),patient.getLastnamePatient());
        ArrayList<PatientEntity> tmp = new ArrayList<>();
        for(PatientEntity p:listPatient){
            if(p.getFirsnamePatient().equalsIgnoreCase(this.patient.getFirsnamePatient()) &&
               p.getLastnamePatient().equalsIgnoreCase(this.patient.getLastnamePatient())){
                tmp.add(p);
            }
        }
        return tmp;
    }

    /**
     * @return the listPatient
     */
    public List<PatientEntity> getListPatient() {
        return listPatient;
    }

    /**
     * @param listPatient the listPatient to set
     */
    public void setListPatient(List<PatientEntity> listPatient) {
        this.listPatient = listPatient;
    }
    
    public void updatePatient() {
        RequestContext context = RequestContext.getCurrentInstance();
        PatientEntity h = facade.find(this.selectedPatient.getSocialSecurityId());
        if (h != null) {
            facade.edit(this.selectedPatient);
            context.execute("swal('Success','Modifications enregistrées','success')");
        } else {
            context.execute("swal('Oups...','Modifications non enregistrées','error')");
        }
    }

    /**
     * @return the selectedPatient
     */
    public PatientEntity getSelectedPatient() {
        return selectedPatient;
    }

    /**
     * @param selectedPatient the selectedPatient to set
     */
    public void setSelectedPatient(PatientEntity selectedPatient) {
        this.selectedPatient = selectedPatient;
    }
    
}
