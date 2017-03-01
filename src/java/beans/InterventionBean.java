/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.InterventionEntity;
import entities.InterventiontypeEntity;
import javax.inject.Named;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import org.primefaces.context.RequestContext;
import sessions.HasInterventionEntityFacade;
import sessions.InterventionEntityFacade;
import sessions.InterventiontypeEntityFacade;

/**
 *
 * @author Olivier
 */
@Named(value = "interventionBean")
@SessionScoped
@ManagedBean
public class InterventionBean implements Serializable {

    @EJB
    InterventionEntityFacade interventionFacade;
    
    @EJB
    InterventiontypeEntityFacade interventiontypeFacade;
    
    @EJB
    HasInterventionEntityFacade hasPrescriptionFacade;
    
    @ManagedProperty(value="#{userBean}")
    private UserBean user;
    
    @ManagedProperty(value="#{patientBean}")
    private PatientBean patient;
    
    private InterventionEntity intervention;
    private InterventiontypeEntity interventionType;
    private String interName;
    
    public InterventionEntity getIntervention() {
        return intervention;
    }

    public void setIntervention(InterventionEntity i) {
        this.intervention = i;
    }
    
    public InterventiontypeEntity getInterventionType() {
        return interventionType;
    }

    public void setTypeIntervention(InterventiontypeEntity t) {
        this.interventionType = t;
    }
    
    private List <Object[]> listInterUser = new ArrayList<>();
    public List<Object[]> aListInterView(){
        listInterUser = interventionFacade.getListInterMed(getUser().getUser().getMailUser());
        ArrayList<Object[]> tmp = new ArrayList<>();
        for(Object[] o : listInterUser){
                tmp.add(o);
        }
        return tmp;    
    }
    
    private List <Object[]> listInterPatient = new ArrayList<>();
    public List<Object[]> aListPatientInterView(){
        listInterPatient = interventionFacade.getListInterPatient(getPatient().getSelectedPatient().getSocialSecurityId());
        ArrayList<Object[]> tmp = new ArrayList<>();
        for(Object[] o : getListInterPatient()){
                tmp.add(o);
        }
        return tmp;    
    }
  
    
    /**
     * Creates a new instance of InterventionBean
     */
    public InterventionBean() {
        intervention = new InterventionEntity();
        interventionType = new InterventiontypeEntity();
    }
    
    public List<InterventiontypeEntity> listIntervention(){
        return interventiontypeFacade.getlistIntervention();
    }
    
    public void setDate(){      
        intervention.setDateEdition(new java.util.Date());
    }
    
    public String createIntervention() {
        setDate();
        InterventiontypeEntity typeInter = interventiontypeFacade.findInterventionByName(interName);
        intervention.setIdIntervention(ThreadLocalRandom.current().nextInt(1, Integer.MAX_VALUE));
        intervention.setIdInterventionType(typeInter);
        boolean created = interventionFacade.createIntervention(intervention);
        hasPrescriptionFacade.createHasIntervention(getPatient().getSelectedPatient().getSocialSecurityId(),intervention.getIdIntervention(), getUser().getUser().getMailUser());
        RequestContext context = RequestContext.getCurrentInstance();
        if (created==true){
            context.execute("swal('Félicitations','Intervention créée','success')");
            this.intervention = new InterventionEntity();
            return "resultPatient";    
        }
        else {
            context.execute("swal('Oups...','Intervention non créée','error')");
            return "resultPatient";
        }
    }   

    /**
     * @return the interName
     */
    public String getInterName() {
        return interName;
    }

    /**
     * @param interName the interName to set
     */
    public void setInterName(String interName) {
        this.interName = interName;
    }

    /**
     * @return the user
     */
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
     * @return the listInterPatient
     */
    public List <Object[]> getListInterPatient() {
        return listInterPatient;
    }

    /**
     * @param listInterPatient the listInterPatient to set
     */
    public void setListInterPatient(List <Object[]> listInterPatient) {
        this.listInterPatient = listInterPatient;
    }
}
