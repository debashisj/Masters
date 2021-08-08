/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
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
 * @author Djena
 */
@Entity
@Table(name = "REASON_FOR_INTEREST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReasonForInterest.findAll", query = "SELECT r FROM ReasonForInterest r")
    , @NamedQuery(name = "ReasonForInterest.findByReason", query = "SELECT r FROM ReasonForInterest r WHERE r.reason = :reason")
    , @NamedQuery(name = "ReasonForInterest.findByDescription", query = "SELECT r FROM ReasonForInterest r WHERE r.description = :description")})
public class ReasonForInterest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "REASON")
    private String reason;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "DESCRIPTION")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reason")
    private Collection<VehicleOfInterest> vehicleOfInterestCollection;

    public ReasonForInterest() {
    }

    public ReasonForInterest(String reason) {
        this.reason = reason;
    }

    public ReasonForInterest(String reason, String description) {
        this.reason = reason;
        this.description = description;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<VehicleOfInterest> getVehicleOfInterestCollection() {
        return vehicleOfInterestCollection;
    }

    public void setVehicleOfInterestCollection(Collection<VehicleOfInterest> vehicleOfInterestCollection) {
        this.vehicleOfInterestCollection = vehicleOfInterestCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reason != null ? reason.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReasonForInterest)) {
            return false;
        }
        ReasonForInterest other = (ReasonForInterest) object;
        if ((this.reason == null && other.reason != null) || (this.reason != null && !this.reason.equals(other.reason))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ReasonForInterest[ reason=" + reason + " ]";
    }
    
}
