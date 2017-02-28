/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jerry
 */
@Entity
@Table(name = "Note")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NoteEntity.findAll", query = "SELECT n FROM NoteEntity n")
    , @NamedQuery(name = "NoteEntity.findByIdNote", query = "SELECT n FROM NoteEntity n WHERE n.idNote = :idNote")
    , @NamedQuery(name = "NoteEntity.findByNote", query = "SELECT n FROM NoteEntity n WHERE n.note = :note")
    , @NamedQuery(name = "NoteEntity.findByDateNote", query = "SELECT n FROM NoteEntity n WHERE n.dateNote = :dateNote")})
public class NoteEntity implements Serializable {
    @JoinColumn(name = "idNoteType", referencedColumnName = "idNoteType")
    @ManyToOne(optional = false)
    private NoteTypeEntity idNoteType;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idNote")
    private Integer idNote;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5000)
    @Column(name = "Note")
    private String note;
    @Column(name = "dateNote")
    @Temporal(TemporalType.DATE)
    private Date dateNote;

    public NoteEntity() {
    }

    public NoteEntity(Integer idNote) {
        this.idNote = idNote;
    }

    public NoteEntity(Integer idNote, String note) {
        this.idNote = idNote;
        this.note = note;
    }

    public Integer getIdNote() {
        return idNote;
    }

    public void setIdNote(Integer idNote) {
        this.idNote = idNote;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getDateNote() {
        return dateNote;
    }

    public void setDateNote(Date dateNote) {
        this.dateNote = dateNote;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNote != null ? idNote.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NoteEntity)) {
            return false;
        }
        NoteEntity other = (NoteEntity) object;
        if ((this.idNote == null && other.idNote != null) || (this.idNote != null && !this.idNote.equals(other.idNote))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.NoteEntity[ idNote=" + idNote + " ]";
    }
    
    public NoteTypeEntity getIdNoteType() {
        return idNoteType;
    }

    public void setIdNoteType(NoteTypeEntity idNoteType) {
        this.idNoteType = idNoteType;
    }
    
}
