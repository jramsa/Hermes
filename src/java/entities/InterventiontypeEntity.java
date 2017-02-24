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
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Olivier
 */
@Entity
@Table(name = "interventiontype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InterventiontypeEntity.findAll", query = "SELECT i FROM InterventiontypeEntity i")
    , @NamedQuery(name = "InterventiontypeEntity.findByIdInterventionType", query = "SELECT i FROM InterventiontypeEntity i WHERE i.idInterventionType = :idInterventionType")
    , @NamedQuery(name = "InterventiontypeEntity.findByInterventionName", query = "SELECT i FROM InterventiontypeEntity i WHERE i.interventionName = :interventionName")
    , @NamedQuery(name = "InterventiontypeEntity.findByPriceIntervention", query = "SELECT i FROM InterventiontypeEntity i WHERE i.priceIntervention = :priceIntervention")})
public class InterventiontypeEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idInterventionType")
    private Integer idInterventionType;
    @Size(max = 25)
    @Column(name = "interventionName")
    private String interventionName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "priceIntervention")
    private float priceIntervention;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInterventionType")
    private List<InterventionEntity> interventionEntityList;

    public InterventiontypeEntity() {
    }

    public InterventiontypeEntity(Integer idInterventionType) {
        this.idInterventionType = idInterventionType;
    }

    public InterventiontypeEntity(Integer idInterventionType, float priceIntervention) {
        this.idInterventionType = idInterventionType;
        this.priceIntervention = priceIntervention;
    }

    public Integer getIdInterventionType() {
        return idInterventionType;
    }

    public void setIdInterventionType(Integer idInterventionType) {
        this.idInterventionType = idInterventionType;
    }

    public String getInterventionName() {
        return interventionName;
    }

    public void setInterventionName(String interventionName) {
        this.interventionName = interventionName;
    }

    public float getPriceIntervention() {
        return priceIntervention;
    }

    public void setPriceIntervention(float priceIntervention) {
        this.priceIntervention = priceIntervention;
    }

    @XmlTransient
    public List<InterventionEntity> getInterventionEntityList() {
        return interventionEntityList;
    }

    public void setInterventionEntityList(List<InterventionEntity> interventionEntityList) {
        this.interventionEntityList = interventionEntityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInterventionType != null ? idInterventionType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InterventiontypeEntity)) {
            return false;
        }
        InterventiontypeEntity other = (InterventiontypeEntity) object;
        if ((this.idInterventionType == null && other.idInterventionType != null) || (this.idInterventionType != null && !this.idInterventionType.equals(other.idInterventionType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.InterventiontypeEntity[ idInterventionType=" + idInterventionType + " ]";
    }
    
}
