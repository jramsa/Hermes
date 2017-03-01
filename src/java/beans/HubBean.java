/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.HubEntity;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
//import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import org.primefaces.context.RequestContext;
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
    
    private String nameHosp;
    private String nameHub;
    
    public String addHubToHospital(){
        int created = hubFacade.addHubToHospital(nameHosp,nameHub);
        RequestContext context = RequestContext.getCurrentInstance();
        if (created != 0) {
            context.execute("swal('Félicitations','Service ajouté','success')");
            return "addhub";
        } else {
            context.execute("swal('Oups...','Service déjà ajouté','error')");
            return "addhub";
        }   
    }

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

    /**
     * @return the nameHosp
     */
    public String getNameHosp() {
        return nameHosp;
    }

    /**
     * @param nameHosp the nameHosp to set
     */
    public void setNameHosp(String nameHosp) {
        this.nameHosp = nameHosp;
    }

    /**
     * @return the nameHub
     */
    public String getNameHub() {
        return nameHub;
    }

    /**
     * @param nameHub the nameHub to set
     */
    public void setNameHub(String nameHub) {
        this.nameHub = nameHub;
    }
    
}
