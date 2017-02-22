/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.UserEntity;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;
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
    
    private UserEntity user;
    
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
            if(tmp.getPassword().equals(this.user.getPassword()) && user.getMailUser().equals("admin@aphp.fr")){
                this.user = new UserEntity();
                return "admin";
            }
            else if(tmp.getPassword().equals(this.user.getPassword())){
                //this.user = new UserEntity();
                this.user = tmp;
                return "accueil";
            }
            else{
                context.execute("swal('Oups...','Utilisateur ou mot de passe incorrect','error')");
                return "index";
            }
        }           
    }
    
    public String createUser() {
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
}
