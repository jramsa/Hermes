/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jerry
 */
@Entity
@Table(name = "NoteType")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NoteTypeEntity.findAll", query = "SELECT n FROM NoteTypeEntity n")
    , @NamedQuery(name = "NoteTypeEntity.findByIdNoteType", query = "SELECT n FROM NoteTypeEntity n WHERE n.idNoteType = :idNoteType")
    , @NamedQuery(name = "NoteTypeEntity.findByNoteName", query = "SELECT n FROM NoteTypeEntity n WHERE n.noteName = :noteName")})
public class NoteTypeEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idNoteType")
    private Integer idNoteType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "noteName")
    
    private String noteName;

    public NoteTypeEntity() {
    }

    public NoteTypeEntity(Integer idNoteType) {
        this.idNoteType = idNoteType;
    }

    public NoteTypeEntity(Integer idNoteType, String noteName) {
        this.idNoteType = idNoteType;
        this.noteName = noteName;
    }

    public Integer getIdNoteType() {
        return idNoteType;
    }

    public void setIdNoteType(Integer idNoteType) {
        this.idNoteType = idNoteType;
    }

    public String getNoteName() {
        return noteName;
    }

    public void setNoteName(String noteName) {
        this.noteName = noteName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNoteType != null ? idNoteType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NoteTypeEntity)) {
            return false;
        }
        NoteTypeEntity other = (NoteTypeEntity) object;
        if ((this.idNoteType == null && other.idNoteType != null) || (this.idNoteType != null && !this.idNoteType.equals(other.idNoteType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return noteName;
    }
    
}
