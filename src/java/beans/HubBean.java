/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.HubEntity;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import sessions.HubEntityFacade;

/**
 *
 * @author Jerry
 */
@Named(value = "hubBean")
@SessionScoped
@ManagedBean
public class HubBean implements Serializable {
    
    @EJB     
    HubEntityFacade hubFacade;
    
    private HubEntity hub;
    private List<HubEntity> listHub;

    /**
     * Creates a new instance of hubBean
     */
    public HubBean() {
        hub = new HubEntity();
        listHub = new ArrayList<>();
    }
    
   public HubEntity getHub() {
        return hub;
    }

    public void setHub(HubEntity user) {
        this.hub = hub;
    }
    
    public List<HubEntity> getListHub() {
        return listHub;
    }
    
    public List<HubEntity> listHub(){
        return hubFacade.getlistHub();
    }
    
}
