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
import org.primefaces.event.SelectEvent;
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
    private String nameServ;
    private String nameUser;
    
    public String addHubToHospital(){
        int created = hubFacade.addHubToHospital(nameHosp,nameHub);
        RequestContext context = RequestContext.getCurrentInstance();
        if (created != 0) {
            context.execute("swal('Félicitations','Pôle ajouté','success')");
            setNameHosp("");
            setNameHub("");
            return "addhub";
        } else {
            context.execute("swal('Oups...','Pôle déjà ajouté','error')");
            return "addhub";
        }   
    }
    
    public String addServToHub(){
        int created = hubFacade.addServToHub(nameHosp,nameHub,nameServ);
        RequestContext context = RequestContext.getCurrentInstance();
        if (created != 0) {
            context.execute("swal('Félicitations','Service ajouté','success')");
            setNameHosp("");
            setNameHub("");
            return "addserv";
        } else {
            context.execute("swal('Oups...','Service déjà ajouté','error')");
            return "addserv";
        }   
    }
    
    public String addUserToServ(){
        int created = hubFacade.addUserToServ(nameServ,nameUser);
        RequestContext context = RequestContext.getCurrentInstance();
        if (created != 0) {
            context.execute("swal('Félicitations','Utilisateur ajouté','success')");
            setNameHosp("");
            setNameHub("");
            return "changeuserserv";
        } else {
            context.execute("swal('Oups...','Utilisateur déjà ajouté','error')");
            return "changeuserserv";
        }   
    }
    
    private List<Object[]> ListHospinHasHub = new ArrayList<>();
    public List<Object[]> aGetListHospinHasHub(){
        setListHospinHasHub(hubFacade.aGetListHospinHasHub());
        return getListHospinHasHub();
    }
    
    private List<Object[]> listHubinHasHub = new ArrayList<>();
    
    public void onHubinHasHubChange() {
            setListHubinHasHub(hubFacade.aGetListHubinHasHub(getNameHosp()));
    }
    
    private List<Object[]> listServ = new ArrayList<>();
    
    public void onServinHasServChange() {
            listServ = hubFacade.aGetListServ();
    }
    
    private List<Object[]> listServHasServ = new ArrayList<>();
    
    public void onListServHasServChange() {
            listServHasServ = hubFacade.onListServHasServChange(nameHub);
    }
    
    private List<Object[]> listUser = new ArrayList<>();
    
    public void onListUserChange() {
            listUser = hubFacade.onListUserChange();
    }
    
    public String removeHubToHospital(){
        int created = hubFacade.removeHubToHospital(nameHosp,nameHub);
        RequestContext context = RequestContext.getCurrentInstance();
        if (created != 0) {
            context.execute("swal('Félicitations','Service supprimé','success')");
            setNameHosp("");
            setNameHub("");
            return "remove";
        } else {
            context.execute("swal('Oups...','Service déjà supprimé','error')");
            return "removehub";
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

    /**
     * @return the ListHospinHasHub
     */
    public List<Object[]> getListHospinHasHub() {
        return ListHospinHasHub;
    }

    /**
     * @param ListHospinHasHub the ListHospinHasHub to set
     */
    public void setListHospinHasHub(List<Object[]> ListHospinHasHub) {
        this.ListHospinHasHub = ListHospinHasHub;
    }

    /**
     * @return the listHubinHasHub
     */
    public List<Object[]> getListHubinHasHub() {
        return listHubinHasHub;
    }

    /**
     * @param listHubinHasHub the listHubinHasHub to set
     */
    public void setListHubinHasHub(List<Object[]> listHubinHasHub) {
        this.listHubinHasHub = listHubinHasHub;
    }

    /**
     * @return the nameServ
     */
    public String getNameServ() {
        return nameServ;
    }

    /**
     * @param nameServ the nameServ to set
     */
    public void setNameServ(String nameServ) {
        this.nameServ = nameServ;
    }

    /**
     * @return the listServ
     */
    public List<Object[]> getListServ() {
        return listServ;
    }

    /**
     * @param listServ the listServ to set
     */
    public void setListServ(List<Object[]> listServ) {
        this.listServ = listServ;
    }

    /**
     * @return the nameUser
     */
    public String getNameUser() {
        return nameUser;
    }

    /**
     * @param nameUser the nameUser to set
     */
    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    /**
     * @return the listServHasServ
     */
    public List<Object[]> getListServHasServ() {
        return listServHasServ;
    }

    /**
     * @param listServHasServ the listServHasServ to set
     */
    public void setListServHasServ(List<Object[]> listServHasServ) {
        this.listServHasServ = listServHasServ;
    }

    /**
     * @return the listUser
     */
    public List<Object[]> getListUser() {
        return listUser;
    }

    /**
     * @param listUser the listUser to set
     */
    public void setListUser(List<Object[]> listUser) {
        this.listUser = listUser;
    }
    
}
