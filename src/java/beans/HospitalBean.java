/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.HospitalEntity;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import org.primefaces.context.RequestContext;
import sessions.HospitalEntityFacade;
import java.util.List;

/**
 *
 * @author Jerry
 */
@Named(value = "hospitalBean")
@SessionScoped
public class HospitalBean implements Serializable {

    @EJB
    HospitalEntityFacade facade;
    
    private HospitalEntity hospital;
    
    private String nameHub;
    private String nameHosp;

    public HospitalBean() {
        hospital = new HospitalEntity();
    }
    
    public HospitalEntityFacade getFacade() {
        return facade;
    }

    /**
     * @param facade the facade to set
     */
    public void setFacade(HospitalEntityFacade facade) {
        this.facade = facade;
    }

    public HospitalEntity getHospital() {
        return hospital;
    }

    public void setHospital(HospitalEntity hospital) {
        this.hospital = hospital;
    }

    public String createHospital() {
        boolean created = facade.creatHospital(hospital);
        RequestContext context = RequestContext.getCurrentInstance();
        if (created == true) {
            context.execute("swal('Félicitations','Hôpital créé','success')");
            this.hospital = new HospitalEntity();
            return "addhosp";
        } else {
            context.execute("swal('Oups...','Hôpital existe déjà','error')");
            this.hospital = new HospitalEntity();
            return "addhosp";
        }
    }
    
    public void updateHospital() {
        HospitalEntity h = facade.find(this.hospital.getHospitalName());
        if (h != null) {
            facade.edit(this.hospital);
        }
    }
    
    public List<HospitalEntity> listHospital(){
        return facade.getlistHospital();
    }
    
    public String removeHospital(){
        HospitalEntity hosp = facade.find(this.hospital.getHospitalName());
        boolean deleted = facade.deleteHosp(hosp);
        RequestContext context = RequestContext.getCurrentInstance();
        if (deleted == true) {
            context.execute("swal('Félicitations','Hôpital supprimé','success')");
            return "removehosp";
        } else {
            context.execute("swal('Oups...','Suppression impossible','error')");
            return "removehosp";
        }
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
    
    public String addHubToHospital(){
        return "";
    }

}
