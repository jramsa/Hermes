/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Jerry
 */
@Embeddable
public class HasInterventionEntityPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "socialSecurityId")
    private String socialSecurityId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idIntervention")
    private int idIntervention;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "mailUser")
    private String mailUser;

    public HasInterventionEntityPK() {
    }

    public HasInterventionEntityPK(String socialSecurityId, int idIntervention, String mailUser) {
        this.socialSecurityId = socialSecurityId;
        this.idIntervention = idIntervention;
        this.mailUser = mailUser;
    }

    public String getSocialSecurityId() {
        return socialSecurityId;
    }

    public void setSocialSecurityId(String socialSecurityId) {
        this.socialSecurityId = socialSecurityId;
    }

    public int getIdIntervention() {
        return idIntervention;
    }

    public void setIdIntervention(int idIntervention) {
        this.idIntervention = idIntervention;
    }

    public String getMailUser() {
        return mailUser;
    }

    public void setMailUser(String mailUser) {
        this.mailUser = mailUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (socialSecurityId != null ? socialSecurityId.hashCode() : 0);
        hash += (int) idIntervention;
        hash += (mailUser != null ? mailUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HasInterventionEntityPK)) {
            return false;
        }
        HasInterventionEntityPK other = (HasInterventionEntityPK) object;
        if ((this.socialSecurityId == null && other.socialSecurityId != null) || (this.socialSecurityId != null && !this.socialSecurityId.equals(other.socialSecurityId))) {
            return false;
        }
        if (this.idIntervention != other.idIntervention) {
            return false;
        }
        if ((this.mailUser == null && other.mailUser != null) || (this.mailUser != null && !this.mailUser.equals(other.mailUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.HasInterventionEntityPK[ socialSecurityId=" + socialSecurityId + ", idIntervention=" + idIntervention + ", mailUser=" + mailUser + " ]";
    }
    
}
