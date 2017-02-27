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
import javax.persistence.Lob;
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
@Table(name = "prescription")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrescriptionEntity.findAll", query = "SELECT p FROM PrescriptionEntity p")
    , @NamedQuery(name = "PrescriptionEntity.findByIdPrescription", query = "SELECT p FROM PrescriptionEntity p WHERE p.idPrescription = :idPrescription")
    , @NamedQuery(name = "PrescriptionEntity.findByDatePrescription", query = "SELECT p FROM PrescriptionEntity p WHERE p.datePrescription = :datePrescription")
    , @NamedQuery(name = "PrescriptionEntity.findByDurationPrescription", query = "SELECT p FROM PrescriptionEntity p WHERE p.durationPrescription = :durationPrescription")
    , @NamedQuery(name = "PrescriptionEntity.findByQuantityPrescription", query = "SELECT p FROM PrescriptionEntity p WHERE p.quantityPrescription = :quantityPrescription")})
public class PrescriptionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idPrescription")
    private Integer idPrescription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datePrescription")
    @Temporal(TemporalType.DATE)
    private Date datePrescription;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "durationPrescription")
    private String durationPrescription;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "drugName")
    private String drugName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "quantityPrescription")
    private String quantityPrescription;

    public PrescriptionEntity() {
    }

    public PrescriptionEntity(Integer idPrescription) {
        this.idPrescription = idPrescription;
    }

    public PrescriptionEntity(Integer idPrescription, Date datePrescription, String durationPrescription, String drugName, String quantityPrescription) {
        this.idPrescription = idPrescription;
        this.datePrescription = datePrescription;
        this.durationPrescription = durationPrescription;
        this.drugName = drugName;
        this.quantityPrescription = quantityPrescription;
    }

    public Integer getIdPrescription() {
        return idPrescription;
    }

    public void setIdPrescription(Integer idPrescription) {
        this.idPrescription = idPrescription;
    }

    public Date getDatePrescription() {
        return datePrescription;
    }

    public void setDatePrescription(Date datePrescription) {
        this.datePrescription = datePrescription;
    }

    public String getDurationPrescription() {
        return durationPrescription;
    }

    public void setDurationPrescription(String durationPrescription) {
        this.durationPrescription = durationPrescription;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getQuantityPrescription() {
        return quantityPrescription;
    }

    public void setQuantityPrescription(String quantityPrescription) {
        this.quantityPrescription = quantityPrescription;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrescription != null ? idPrescription.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrescriptionEntity)) {
            return false;
        }
        PrescriptionEntity other = (PrescriptionEntity) object;
        if ((this.idPrescription == null && other.idPrescription != null) || (this.idPrescription != null && !this.idPrescription.equals(other.idPrescription))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PrescriptionEntity[ idPrescription=" + idPrescription + " ]";
    }
    
}
