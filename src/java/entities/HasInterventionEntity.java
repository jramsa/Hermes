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
 * @author Jerry
 */
@Entity
@Table(name = "hasIntervention")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HasInterventionEntity.findAll", query = "SELECT h FROM HasInterventionEntity h")
    , @NamedQuery(name = "HasInterventionEntity.findBySocialSecurityId", query = "SELECT h FROM HasInterventionEntity h WHERE h.hasInterventionEntityPK.socialSecurityId = :socialSecurityId")
    , @NamedQuery(name = "HasInterventionEntity.findByIdIntervention", query = "SELECT h FROM HasInterventionEntity h WHERE h.hasInterventionEntityPK.idIntervention = :idIntervention")
    , @NamedQuery(name = "HasInterventionEntity.findByMailUser", query = "SELECT h FROM HasInterventionEntity h WHERE h.hasInterventionEntityPK.mailUser = :mailUser")})
public class HasInterventionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HasInterventionEntityPK hasInterventionEntityPK;

    public HasInterventionEntity() {
    }

    public HasInterventionEntity(HasInterventionEntityPK hasInterventionEntityPK) {
        this.hasInterventionEntityPK = hasInterventionEntityPK;
    }

    public HasInterventionEntity(String socialSecurityId, int idIntervention, String mailUser) {
        this.hasInterventionEntityPK = new HasInterventionEntityPK(socialSecurityId, idIntervention, mailUser);
    }

    public HasInterventionEntityPK getHasInterventionEntityPK() {
        return hasInterventionEntityPK;
    }

    public void setHasInterventionEntityPK(HasInterventionEntityPK hasInterventionEntityPK) {
        this.hasInterventionEntityPK = hasInterventionEntityPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hasInterventionEntityPK != null ? hasInterventionEntityPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HasInterventionEntity)) {
            return false;
        }
        HasInterventionEntity other = (HasInterventionEntity) object;
        if ((this.hasInterventionEntityPK == null && other.hasInterventionEntityPK != null) || (this.hasInterventionEntityPK != null && !this.hasInterventionEntityPK.equals(other.hasInterventionEntityPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.HasInterventionEntity[ hasInterventionEntityPK=" + hasInterventionEntityPK + " ]";
    }
    
}
