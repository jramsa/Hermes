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
@Table(name = "hasNote")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HasNoteEntity.findAll", query = "SELECT h FROM HasNoteEntity h")
    , @NamedQuery(name = "HasNoteEntity.findBySocialSecurityId", query = "SELECT h FROM HasNoteEntity h WHERE h.hasNoteEntityPK.socialSecurityId = :socialSecurityId")
    , @NamedQuery(name = "HasNoteEntity.findByMailUser", query = "SELECT h FROM HasNoteEntity h WHERE h.hasNoteEntityPK.mailUser = :mailUser")
    , @NamedQuery(name = "HasNoteEntity.findByIdNote", query = "SELECT h FROM HasNoteEntity h WHERE h.hasNoteEntityPK.idNote = :idNote")})
public class HasNoteEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HasNoteEntityPK hasNoteEntityPK;

    public HasNoteEntity() {
    }

    public HasNoteEntity(HasNoteEntityPK hasNoteEntityPK) {
        this.hasNoteEntityPK = hasNoteEntityPK;
    }

    public HasNoteEntity(String socialSecurityId, String mailUser, int idNote) {
        this.hasNoteEntityPK = new HasNoteEntityPK(socialSecurityId, mailUser, idNote);
    }

    public HasNoteEntityPK getHasNoteEntityPK() {
        return hasNoteEntityPK;
    }

    public void setHasNoteEntityPK(HasNoteEntityPK hasNoteEntityPK) {
        this.hasNoteEntityPK = hasNoteEntityPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hasNoteEntityPK != null ? hasNoteEntityPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HasNoteEntity)) {
            return false;
        }
        HasNoteEntity other = (HasNoteEntity) object;
        if ((this.hasNoteEntityPK == null && other.hasNoteEntityPK != null) || (this.hasNoteEntityPK != null && !this.hasNoteEntityPK.equals(other.hasNoteEntityPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.HasNoteEntity[ hasNoteEntityPK=" + hasNoteEntityPK + " ]";
    }
    
}
