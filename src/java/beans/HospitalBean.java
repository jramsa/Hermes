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
            return "addhosp";
        }
    }
    
    public void updateHospital() {
        RequestContext context = RequestContext.getCurrentInstance();
        HospitalEntity h = facade.find(this.hospital.getHospitalName());
        if (h != null) {
            facade.edit(this.hospital);
            context.execute("swal('Success','Hospital has been modified','success')");
        } else {
            context.execute("swal('Oups...','This Hospital does not exist','error')");
        }
    }
    
    public List<HospitalEntity> listHospital(){
        return facade.getlistHospital();
    }
    
    public String removeHospital(){
        //System.out.println(hospital.getHospitalName());
        boolean deleted = facade.deleteHosp(hospital);
        RequestContext context = RequestContext.getCurrentInstance();
        if (deleted == true) {
            context.execute("swal('Félicitations','Hopital supprimé','success')");
            return "removehosp";
        } else {
            
            context.execute("swal('Oups...','Suppression impossible','error')");
            return "removehosp";
        }
    }

}
