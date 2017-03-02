/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;


import entities.JobEntity;
import entities.HospitalEntity;
import entities.UserEntity;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;
import sessions.JobEntityFacade;
import sessions.UserEntityFacade;

/**
 *
 * @author Jerry
 */
@ManagedBean
@Named(value = "userBean")
@SessionScoped
public class UserBean implements Serializable{

    @EJB     
    UserEntityFacade facade;
    
    @EJB     
    JobEntityFacade jobFacade;
    
    private UserEntity user;
    private JobEntity job;
    
    private String role;
    
    private HospitalEntity hospitalEntity;
    
    public UserBean() {
        user = new UserEntity();
    }
      
    public String authentification(){
        RequestContext context = RequestContext.getCurrentInstance();
        if(facade.findUser(this.user)==null){
            context.execute("swal('Oups...','Utilisateur ou mot de passe incorrect','error')");
                return "index"; 
                }
        else{
            UserEntity tmp = facade.findUser(this.user);
            if(tmp.getPassword().equals(this.user.getPassword()) && tmp.getIdJob().getIdJob()==3){
                //this.user = tmp;
                return "admin";
            }
            else if(tmp.getPassword().equals(this.user.getPassword()) && tmp.getIdJob().getIdJob()== 1){
                this.user = tmp;
                updateHospital();
                return "accueil";
            }
            else if(tmp.getPassword().equals(this.user.getPassword())){
                context.execute("swal('Oups...','Utilisateur non habilité','error')");
                return "index";
            }
            else{
                context.execute("swal('Oups...','Utilisateur ou mot de passe incorrect','error')");
                return "index";
            }
        }           
    }
    
    public List<Object[]> listRole(){
        return facade.listRole();
    }
    
    public String createUser() {
        int idJobRole = facade.getRoleUser(role);
        job = jobFacade.find(idJobRole);
        user.setIdJob(job);
        int created = facade.createUser(user);
        RequestContext context = RequestContext.getCurrentInstance();
        if (created == 1) {
            context.execute("swal('Félicitations','Utilisateur créé','success')");
            this.user = new UserEntity();
            return "adduser";
        } else {
            context.execute("swal('Oups...','Utilisateur existe déjà','error')");
            return "adduser";
        }
    }
    public String deleteUser(){
        boolean deleted = facade.deleteUser(user);
        RequestContext context = RequestContext.getCurrentInstance();
        if (deleted == true) {
            context.execute("swal('Félicitations','Utilisateur supprimé','success')");
            return "removeuser";
        } else {
            context.execute("swal('Oups...','Suppression impossible','error')");
            return "removeuser";
        }
    }
    
    
    public void registerUser(){
        
    }

    /**
     * @return the user
     */
    public UserEntity getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(UserEntity user) {
        this.user = user;
    }


    /**
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }
    
    /*public String getUserJob() {
        return facade.getUserJob(user);
    }*/
    
    public String getUserHub() {
        return facade.getUserHub(user);
    }
    
    public String getUserService() {
        return facade.getUserService(user);
    }
    
    public void updateHospital() {
        HospitalEntity entity = facade.getUserHospitalEntity(user);
        if(entity == null) {
            System.out.println("null");
            return;
        }
        setHospitalEntity(entity);
    }
    
    public void setHospitalEntity(HospitalEntity hospitalEntity) {
        this.hospitalEntity = hospitalEntity;
    }
    
    public HospitalEntity getHospital() {
        return hospitalEntity;

    }
}
