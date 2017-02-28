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
public class HasNoteEntityPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "socialSecurityId")
    private String socialSecurityId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "mailUser")
    private String mailUser;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idNote")
    private int idNote;

    public HasNoteEntityPK() {
    }

    public HasNoteEntityPK(String socialSecurityId, String mailUser, int idNote) {
        this.socialSecurityId = socialSecurityId;
        this.mailUser = mailUser;
        this.idNote = idNote;
    }

    public String getSocialSecurityId() {
        return socialSecurityId;
    }

    public void setSocialSecurityId(String socialSecurityId) {
        this.socialSecurityId = socialSecurityId;
    }

    public String getMailUser() {
        return mailUser;
    }

    public void setMailUser(String mailUser) {
        this.mailUser = mailUser;
    }

    public int getIdNote() {
        return idNote;
    }

    public void setIdNote(int idNote) {
        this.idNote = idNote;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (socialSecurityId != null ? socialSecurityId.hashCode() : 0);
        hash += (mailUser != null ? mailUser.hashCode() : 0);
        hash += (int) idNote;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HasNoteEntityPK)) {
            return false;
        }
        HasNoteEntityPK other = (HasNoteEntityPK) object;
        if ((this.socialSecurityId == null && other.socialSecurityId != null) || (this.socialSecurityId != null && !this.socialSecurityId.equals(other.socialSecurityId))) {
            return false;
        }
        if ((this.mailUser == null && other.mailUser != null) || (this.mailUser != null && !this.mailUser.equals(other.mailUser))) {
            return false;
        }
        if (this.idNote != other.idNote) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.HasNoteEntityPK[ socialSecurityId=" + socialSecurityId + ", mailUser=" + mailUser + ", idNote=" + idNote + " ]";
    }
    
}
