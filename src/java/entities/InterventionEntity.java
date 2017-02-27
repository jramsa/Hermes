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
 * @author Olivier
 */
@Entity
@Table(name = "intervention")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InterventionEntity.findAll", query = "SELECT i FROM InterventionEntity i")
    , @NamedQuery(name = "InterventionEntity.findByIdIntervention", query = "SELECT i FROM InterventionEntity i WHERE i.idIntervention = :idIntervention")
    , @NamedQuery(name = "InterventionEntity.findByDateIntervention", query = "SELECT i FROM InterventionEntity i WHERE i.dateIntervention = :dateIntervention")
    , @NamedQuery(name = "InterventionEntity.findByReportIntervention", query = "SELECT i FROM InterventionEntity i WHERE i.reportIntervention = :reportIntervention")
    , @NamedQuery(name = "InterventionEntity.findByDateEdition", query = "SELECT i FROM InterventionEntity i WHERE i.dateEdition = :dateEdition")})
public class InterventionEntity implements Serializable {

    @JoinColumn(name = "idInterventionType", referencedColumnName = "idInterventionType")
    @ManyToOne(optional = false)
    private InterventiontypeEntity idInterventionType;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idIntervention")
    private Integer idIntervention;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateIntervention")
    @Temporal(TemporalType.DATE)
    private Date dateIntervention;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "reportIntervention")
    private String reportIntervention;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateEdition")
    @Temporal(TemporalType.DATE)
    private Date dateEdition;

    public InterventionEntity() {
    }

    public InterventionEntity(Integer idIntervention) {
        this.idIntervention = idIntervention;
    }

    public InterventionEntity(Integer idIntervention, Date dateIntervention, String reportIntervention, Date dateEdition) {
        this.idIntervention = idIntervention;
        this.dateIntervention = dateIntervention;
        this.reportIntervention = reportIntervention;
        this.dateEdition = dateEdition;
    }

    public Integer getIdIntervention() {
        return idIntervention;
    }

    public void setIdIntervention(Integer idIntervention) {
        this.idIntervention = idIntervention;
    }

    public Date getDateIntervention() {
        return dateIntervention;
    }

    public void setDateIntervention(Date dateIntervention) {
        this.dateIntervention = dateIntervention;
    }

    public String getReportIntervention() {
        return reportIntervention;
    }

    public void setReportIntervention(String reportIntervention) {
        this.reportIntervention = reportIntervention;
    }

    public Date getDateEdition() {
        return dateEdition;
    }

    public void setDateEdition(Date dateEdition) {
        this.dateEdition = dateEdition;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIntervention != null ? idIntervention.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InterventionEntity)) {
            return false;
        }
        InterventionEntity other = (InterventionEntity) object;
        if ((this.idIntervention == null && other.idIntervention != null) || (this.idIntervention != null && !this.idIntervention.equals(other.idIntervention))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.InterventionEntity[ idIntervention=" + idIntervention + " ]";
    }

    public InterventiontypeEntity getIdInterventionType() {
        return idInterventionType;
    }

    public void setIdInterventionType(InterventiontypeEntity idInterventionType) {
        this.idInterventionType = idInterventionType;
    }

    public void setIdPrescription(int nextInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
