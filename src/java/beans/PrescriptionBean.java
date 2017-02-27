/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.PrescriptionEntity;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
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
    
    private String mailuser;    
    private String socialSecurityId;
    
    @ManagedProperty(value="#{userBean}")
    private UserBean user;
    
    @ManagedProperty(value="#{patientBean}")
    private PatientBean patient;
    
    
    public String getMailuser() {
        return mailuser;
    }

    public String getSocialSecurityId() {
        return socialSecurityId;
    }
   
    public void setMailuser(String mailuser) {
        this.mailuser = mailuser;
    }

    public void setSocialSecurityId(String socialSecurityId) {
        this.socialSecurityId = socialSecurityId;
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
        //facadeHasPrescription.createHasPrescription(socialSecurityId,prescription.getIdPrescription(), mailuser);
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
}
