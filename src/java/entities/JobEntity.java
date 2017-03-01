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
 * @author Jerry
 */
@Entity
@Table(name = "Job")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JobEntity.findAll", query = "SELECT j FROM JobEntity j")
    , @NamedQuery(name = "JobEntity.findByIdJob", query = "SELECT j FROM JobEntity j WHERE j.idJob = :idJob")
    , @NamedQuery(name = "JobEntity.findByJobName", query = "SELECT j FROM JobEntity j WHERE j.jobName = :jobName")})
public class JobEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idJob")
    private Integer idJob;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "jobName")
    private String jobName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idJob")
    private List<UserEntity> userEntityList;

    public JobEntity() {
    }

    public JobEntity(Integer idJob) {
        this.idJob = idJob;
    }

    public JobEntity(Integer idJob, String jobName) {
        this.idJob = idJob;
        this.jobName = jobName;
    }

    public Integer getIdJob() {
        return idJob;
    }

    public void setIdJob(Integer idJob) {
        this.idJob = idJob;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    @XmlTransient
    public List<UserEntity> getUserEntityList() {
        return userEntityList;
    }

    public void setUserEntityList(List<UserEntity> userEntityList) {
        this.userEntityList = userEntityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idJob != null ? idJob.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JobEntity)) {
            return false;
        }
        JobEntity other = (JobEntity) object;
        if ((this.idJob == null && other.idJob != null) || (this.idJob != null && !this.idJob.equals(other.idJob))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.JobEntity[ idJob=" + idJob + " ]";
    }
    
}
