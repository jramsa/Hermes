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
@Table(name = "Patient")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PatientEntity.findAll", query = "SELECT p FROM PatientEntity p")
    , @NamedQuery(name = "PatientEntity.findByFirsnamePatient", query = "SELECT p FROM PatientEntity p WHERE p.firsnamePatient = :firsnamePatient")
    , @NamedQuery(name = "PatientEntity.findByLastnamePatient", query = "SELECT p FROM PatientEntity p WHERE p.lastnamePatient = :lastnamePatient")
    , @NamedQuery(name = "PatientEntity.findByDateOfBirth", query = "SELECT p FROM PatientEntity p WHERE p.dateOfBirth = :dateOfBirth")
    , @NamedQuery(name = "PatientEntity.findByBloodGroup", query = "SELECT p FROM PatientEntity p WHERE p.bloodGroup = :bloodGroup")
    , @NamedQuery(name = "PatientEntity.findBySocialSecurityId", query = "SELECT p FROM PatientEntity p WHERE p.socialSecurityId = :socialSecurityId")
    , @NamedQuery(name = "PatientEntity.findBySexPatient", query = "SELECT p FROM PatientEntity p WHERE p.sexPatient = :sexPatient")
    , @NamedQuery(name = "PatientEntity.findByDetailAddress", query = "SELECT p FROM PatientEntity p WHERE p.detailAddress = :detailAddress")
    , @NamedQuery(name = "PatientEntity.findByCityAddress", query = "SELECT p FROM PatientEntity p WHERE p.cityAddress = :cityAddress")
    , @NamedQuery(name = "PatientEntity.findByPostalAddress", query = "SELECT p FROM PatientEntity p WHERE p.postalAddress = :postalAddress")
    , @NamedQuery(name = "PatientEntity.findByCountryAddress", query = "SELECT p FROM PatientEntity p WHERE p.countryAddress = :countryAddress")
    , @NamedQuery(name = "PatientEntity.findPatient", query = "SELECT p FROM PatientEntity p WHERE UPPER(p.firsnamePatient) = UPPER(:firsnamePatient) AND UPPER(p.lastnamePatient) = UPPER(:lastnamePatient)")})

public class PatientEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "firsnamePatient")
    private String firsnamePatient;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "lastnamePatient")
    private String lastnamePatient;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateOfBirth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Size(max = 4)
    @Column(name = "BloodGroup")
    private String bloodGroup;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "socialSecurityId")
    private String socialSecurityId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "sexPatient")
    private String sexPatient;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "detailAddress")
    private String detailAddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "cityAddress")
    private String cityAddress;
    @Basic(optional = false)
    @NotNull
    @Column(name = "postalAddress")
    private int postalAddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "countryAddress")
    private String countryAddress;

    public PatientEntity() {
    }

    public PatientEntity(String socialSecurityId) {
        this.socialSecurityId = socialSecurityId;
    }

    public PatientEntity(String socialSecurityId, String firsnamePatient, String lastnamePatient, Date dateOfBirth, String sexPatient, String detailAddress, String cityAddress, int postalAddress, String countryAddress) {
        this.socialSecurityId = socialSecurityId;
        this.firsnamePatient = firsnamePatient;
        this.lastnamePatient = lastnamePatient;
        this.dateOfBirth = dateOfBirth;
        this.sexPatient = sexPatient;
        this.detailAddress = detailAddress;
        this.cityAddress = cityAddress;
        this.postalAddress = postalAddress;
        this.countryAddress = countryAddress;
    }

    public String getFirsnamePatient() {
        return firsnamePatient;
    }

    public void setFirsnamePatient(String firsnamePatient) {
        this.firsnamePatient = firsnamePatient;
    }

    public String getLastnamePatient() {
        return lastnamePatient;
    }

    public void setLastnamePatient(String lastnamePatient) {
        this.lastnamePatient = lastnamePatient;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getSocialSecurityId() {
        return socialSecurityId;
    }

    public void setSocialSecurityId(String socialSecurityId) {
        this.socialSecurityId = socialSecurityId;
    }

    public String getSexPatient() {
        return sexPatient;
    }

    public void setSexPatient(String sexPatient) {
        this.sexPatient = sexPatient;
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

    public int getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(int postalAddress) {
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
        hash += (socialSecurityId != null ? socialSecurityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PatientEntity)) {
            return false;
        }
        PatientEntity other = (PatientEntity) object;
        if ((this.socialSecurityId == null && other.socialSecurityId != null) || (this.socialSecurityId != null && !this.socialSecurityId.equals(other.socialSecurityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PatientEntity[ socialSecurityId=" + socialSecurityId + " ]";
    }
    
}
