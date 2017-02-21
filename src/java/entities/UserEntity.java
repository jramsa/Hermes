/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jerry
 */
@Entity
@Table(name = "User")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserEntity.findAll", query = "SELECT u FROM UserEntity u")
    , @NamedQuery(name = "UserEntity.findByFirstnameUser", query = "SELECT u FROM UserEntity u WHERE u.firstnameUser = :firstnameUser")
    , @NamedQuery(name = "UserEntity.findByLastnameUser", query = "SELECT u FROM UserEntity u WHERE u.lastnameUser = :lastnameUser")
    , @NamedQuery(name = "UserEntity.findByMailUser", query = "SELECT u FROM UserEntity u WHERE u.mailUser = :mailUser")
    , @NamedQuery(name = "UserEntity.findByPassword", query = "SELECT u FROM UserEntity u WHERE u.password = :password")})
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "firstnameUser")
    private String firstnameUser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "lastnameUser")
    private String lastnameUser;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "mailUser")
    private String mailUser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "password")
    private String password;

    public UserEntity() {
    }

    public UserEntity(String mailUser) {
        this.mailUser = mailUser;
    }

    public UserEntity(String mailUser, String firstnameUser, String lastnameUser, String password) {
        this.mailUser = mailUser;
        this.firstnameUser = firstnameUser;
        this.lastnameUser = lastnameUser;
        this.password = password;
    }

    public String getFirstnameUser() {
        return firstnameUser;
    }

    public void setFirstnameUser(String firstnameUser) {
        this.firstnameUser = firstnameUser;
    }

    public String getLastnameUser() {
        return lastnameUser;
    }

    public void setLastnameUser(String lastnameUser) {
        this.lastnameUser = lastnameUser;
    }

    public String getMailUser() {
        return mailUser;
    }

    public void setMailUser(String mailUser) {
        this.mailUser = mailUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mailUser != null ? mailUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserEntity)) {
            return false;
        }
        UserEntity other = (UserEntity) object;
        if ((this.mailUser == null && other.mailUser != null) || (this.mailUser != null && !this.mailUser.equals(other.mailUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.UserEntity[ mailUser=" + mailUser + " ]";
    }
    
}
