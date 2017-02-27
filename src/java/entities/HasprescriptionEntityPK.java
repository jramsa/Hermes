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
 * @author Olivier
 */
@Embeddable
public class HasprescriptionEntityPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "socialSecurityId")
    private String socialSecurityId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idPrescription")
    private int idPrescription;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "mailUser")
    private String mailUser;

    public HasprescriptionEntityPK() {
    }

    public HasprescriptionEntityPK(String socialSecurityId, int idPrescription, String mailUser) {
        this.socialSecurityId = socialSecurityId;
        this.idPrescription = idPrescription;
        this.mailUser = mailUser;
    }

    public String getSocialSecurityId() {
        return socialSecurityId;
    }

    public void setSocialSecurityId(String socialSecurityId) {
        this.socialSecurityId = socialSecurityId;
    }

    public int getIdPrescription() {
        return idPrescription;
    }

    public void setIdPrescription(int idPrescription) {
        this.idPrescription = idPrescription;
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
        hash += (int) idPrescription;
        hash += (mailUser != null ? mailUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HasprescriptionEntityPK)) {
            return false;
        }
        HasprescriptionEntityPK other = (HasprescriptionEntityPK) object;
        if ((this.socialSecurityId == null && other.socialSecurityId != null) || (this.socialSecurityId != null && !this.socialSecurityId.equals(other.socialSecurityId))) {
            return false;
        }
        if (this.idPrescription != other.idPrescription) {
            return false;
        }
        if ((this.mailUser == null && other.mailUser != null) || (this.mailUser != null && !this.mailUser.equals(other.mailUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.HasprescriptionEntityPK[ socialSecurityId=" + socialSecurityId + ", idPrescription=" + idPrescription + ", mailUser=" + mailUser + " ]";
    }
    
}
