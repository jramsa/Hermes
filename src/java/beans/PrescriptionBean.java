/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.PrescriptionEntity;
import javax.inject.Named;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import org.primefaces.context.RequestContext;
import sessions.PrescriptionEntityFacade;
import java.util.concurrent.ThreadLocalRandom;
import javax.el.ELContext;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import sessions.HasprescriptionEntityFacade;
/**
 *
 * @author Olivier
 */
@Named(value = "prescriptionBean")
@SessionScoped
@ManagedBean
public class PrescriptionBean implements Serializable {

    @EJB
    PrescriptionEntityFacade facadePrescription;
    
    @EJB
    HasprescriptionEntityFacade facadeHasPrescription;
    
    private PrescriptionEntity prescription;
    
    @ManagedProperty(value="#{userBean}")
    private UserBean user;
    
    @ManagedProperty(value="#{patientBean}")
    private PatientBean patient;
    
    private List <Object[]> listPrescriptionUser = new ArrayList<>();
    public List<Object[]> aListPrescriptionView(){
        setListPrescriptionUser(facadePrescription.getListPrescriptionMed(getUser().getUser().getMailUser()));
        ArrayList<Object[]> tmp = new ArrayList<>();
        for(Object[] o : getListPrescriptionUser()){
                tmp.add(o);
        }
        return tmp;    
    }
    
    private List <Object[]> listPrescriptionPatient = new ArrayList<>();
    public List<Object[]> aListPatientPrescriptionView(){
        listPrescriptionPatient = facadePrescription.getListPrescriptionPatient(getPatient().getSelectedPatient().getSocialSecurityId());
        ArrayList<Object[]> tmp = new ArrayList<>();
        for(Object[] o : listPrescriptionPatient){
                tmp.add(o);
        }
        return tmp;    
    }
  
    /**
     * Creates a new instance of PrescriptionBean
     */
    public PrescriptionBean() {
        this.prescription = new PrescriptionEntity();
    }
    
    public PrescriptionEntity getPrescription(){
        return prescription;
    }
    
    public void setPrescription(PrescriptionEntity prescription){
        this.prescription = prescription;
    }
    
    public void setDate(){      
        prescription.setDatePrescription(new java.util.Date());
    }
      
    public String createPrescription() {
        setDate();
        prescription.setIdPrescription(ThreadLocalRandom.current().nextInt(1, Integer.MAX_VALUE));
        boolean created = facadePrescription.createPrescription(prescription);
        facadeHasPrescription.createHasPrescription(getPatient().getSelectedPatient().getSocialSecurityId(),prescription.getIdPrescription(),getUser().getUser().getMailUser());
        RequestContext context = RequestContext.getCurrentInstance();
        if (created==true){
            context.execute("swal('Félicitations','Prescription créée','success')");
            this.prescription = new PrescriptionEntity();
            return "resultPatient";    
        }
        else {
            context.execute("swal('Oups...','Prescription non créée','error')");
            return "resultPatient";
        }
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
     * @return the listPrescriptionUser
     */
    public List <Object[]> getListPrescriptionUser() {
        return listPrescriptionUser;
    }

    /**
     * @param listPrescriptionUser the listPrescriptionUser to set
     */
    public void setListPrescriptionUser(List <Object[]> listPrescriptionUser) {
        this.listPrescriptionUser = listPrescriptionUser;
    }
}
