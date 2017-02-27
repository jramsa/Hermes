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
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import org.primefaces.context.RequestContext;
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
    
    private InterventionEntity intervention;
    private InterventiontypeEntity interventionType;
    
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
        interventionType.setIdInterventionType(1);//a changer pour recuperer l'id du type de l'inter
        intervention.setIdIntervention(ThreadLocalRandom.current().nextInt(1, Integer.MAX_VALUE));
        intervention.setIdInterventionType(interventionType);
        boolean created = interventionFacade.createIntervention(intervention);
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
}
