/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jerry
 */
@Entity
@Table(name = "Hub")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HubEntity.findAll", query = "SELECT h FROM HubEntity h")
    , @NamedQuery(name = "HubEntity.findByIdHub", query = "SELECT h FROM HubEntity h WHERE h.idHub = :idHub")
    , @NamedQuery(name = "HubEntity.findByHubName", query = "SELECT h FROM HubEntity h WHERE h.hubName = :hubName")})
public class HubEntity implements Serializable {

    @ManyToMany(mappedBy = "hubEntityList")
    private List<HospitalEntity> hospitalEntityList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idHub")
    private Integer idHub;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "hubName")
    private String hubName;

    public HubEntity() {
    }

    public HubEntity(Integer idHub) {
        this.idHub = idHub;
    }

    public HubEntity(Integer idHub, String hubName) {
        this.idHub = idHub;
        this.hubName = hubName;
    }

    public Integer getIdHub() {
        return idHub;
    }

    public void setIdHub(Integer idHub) {
        this.idHub = idHub;
    }

    public String getHubName() {
        return hubName;
    }

    public void setHubName(String hubName) {
        this.hubName = hubName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHub != null ? idHub.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HubEntity)) {
            return false;
        }
        HubEntity other = (HubEntity) object;
        if ((this.idHub == null && other.idHub != null) || (this.idHub != null && !this.idHub.equals(other.idHub))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return hubName;
    }

    @XmlTransient
    public List<HospitalEntity> getHospitalEntityList() {
        return hospitalEntityList;
    }

    public void setHospitalEntityList(List<HospitalEntity> hospitalEntityList) {
        this.hospitalEntityList = hospitalEntityList;
    }
    
}
