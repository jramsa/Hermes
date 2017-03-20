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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "Hospital")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HospitalEntity.findAll", query = "SELECT h FROM HospitalEntity h")
    , @NamedQuery(name = "HospitalEntity.findByHospitalName", query = "SELECT h FROM HospitalEntity h WHERE h.hospitalName = :hospitalName")
    , @NamedQuery(name = "HospitalEntity.findByDetailAddress", query = "SELECT h FROM HospitalEntity h WHERE h.detailAddress = :detailAddress")
    , @NamedQuery(name = "HospitalEntity.findByCityAddress", query = "SELECT h FROM HospitalEntity h WHERE h.cityAddress = :cityAddress")
    , @NamedQuery(name = "HospitalEntity.findByPostalAddress", query = "SELECT h FROM HospitalEntity h WHERE h.postalAddress = :postalAddress")
    , @NamedQuery(name = "HospitalEntity.findByCountryAddress", query = "SELECT h FROM HospitalEntity h WHERE h.countryAddress = :countryAddress")})

public class HospitalEntity implements Serializable {

    @JoinTable(name = "hasHub", joinColumns = {
        @JoinColumn(name = "hospitalName", referencedColumnName = "hospitalName")}, inverseJoinColumns = {
        @JoinColumn(name = "idHub", referencedColumnName = "idHub")})
    @ManyToMany
    private List<HubEntity> hubEntityList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "hospitalName")
    private String hospitalName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "detailAddress")
    private String detailAddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "cityAddress")
    private String cityAddress;
    @Column(name = "postalAddress")
    private Integer postalAddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "countryAddress")
    private String countryAddress;

    public HospitalEntity() {
    }

    public HospitalEntity(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public HospitalEntity(String hospitalName, String detailAddress, String cityAddress, String countryAddress) {
        this.hospitalName = hospitalName;
        this.detailAddress = detailAddress;
        this.cityAddress = cityAddress;
        this.countryAddress = countryAddress;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public String getCityAddress() {
        return cityAddress;
    }

    public void setCityAddress(String cityAddress) {
        this.cityAddress = cityAddress;
    }

    public Integer getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(Integer postalAddress) {
        this.postalAddress = postalAddress;
    }

    public String getCountryAddress() {
        return countryAddress;
    }

    public void setCountryAddress(String countryAddress) {
        this.countryAddress = countryAddress;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hospitalName != null ? hospitalName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HospitalEntity)) {
            return false;
        }
        HospitalEntity other = (HospitalEntity) object;
        if ((this.hospitalName == null && other.hospitalName != null) || (this.hospitalName != null && !this.hospitalName.equals(other.hospitalName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "entities.HospitalEntity[ hospitalName=" + hospitalName + " ]";
        return hospitalName;
    }

    @XmlTransient
    public List<HubEntity> getHubEntityList() {
        return hubEntityList;
    }

    public void setHubEntityList(List<HubEntity> hubEntityList) {
        this.hubEntityList = hubEntityList;
    }
    
}
