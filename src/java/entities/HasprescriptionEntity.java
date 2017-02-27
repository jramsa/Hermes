/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Olivier
 */
@Entity
@Table(name = "hasprescription")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HasprescriptionEntity.findAll", query = "SELECT h FROM HasprescriptionEntity h")
    , @NamedQuery(name = "HasprescriptionEntity.findBySocialSecurityId", query = "SELECT h FROM HasprescriptionEntity h WHERE h.hasprescriptionEntityPK.socialSecurityId = :socialSecurityId")
    , @NamedQuery(name = "HasprescriptionEntity.findByIdPrescription", query = "SELECT h FROM HasprescriptionEntity h WHERE h.hasprescriptionEntityPK.idPrescription = :idPrescription")
    , @NamedQuery(name = "HasprescriptionEntity.findByMailUser", query = "SELECT h FROM HasprescriptionEntity h WHERE h.hasprescriptionEntityPK.mailUser = :mailUser")})
public class HasprescriptionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HasprescriptionEntityPK hasprescriptionEntityPK;

    public HasprescriptionEntity() {
    }

    public HasprescriptionEntity(HasprescriptionEntityPK hasprescriptionEntityPK) {
        this.hasprescriptionEntityPK = hasprescriptionEntityPK;
    }

    public HasprescriptionEntity(String socialSecurityId, int idPrescription, String mailUser) {
        this.hasprescriptionEntityPK = new HasprescriptionEntityPK(socialSecurityId, idPrescription, mailUser);
    }

    public HasprescriptionEntityPK getHasprescriptionEntityPK() {
        return hasprescriptionEntityPK;
    }

    public void setHasprescriptionEntityPK(HasprescriptionEntityPK hasprescriptionEntityPK) {
        this.hasprescriptionEntityPK = hasprescriptionEntityPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hasprescriptionEntityPK != null ? hasprescriptionEntityPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HasprescriptionEntity)) {
            return false;
        }
        HasprescriptionEntity other = (HasprescriptionEntity) object;
        if ((this.hasprescriptionEntityPK == null && other.hasprescriptionEntityPK != null) || (this.hasprescriptionEntityPK != null && !this.hasprescriptionEntityPK.equals(other.hasprescriptionEntityPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.HasprescriptionEntity[ hasprescriptionEntityPK=" + hasprescriptionEntityPK + " ]";
    }
    
}
