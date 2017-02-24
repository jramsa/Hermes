/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.inject.Named;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import sessions.InterventionEntityFacade;
import sessions.InterventiontypeEntityFacade;

/**
 *
 * @author Olivier
 */
@Named(value = "interventionBean")
@SessionScoped
public class InterventionBean implements Serializable {

    @EJB
    InterventionEntityFacade interventionFacade;
    
    @EJB
    InterventiontypeEntityFacade interventiontypeFacade;
    
    /**
     * Creates a new instance of InterventionBean
     */
    public InterventionBean() {
    }
    
}
