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
@Table(name = "VEHICLE_MAKE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VehicleMake.findAll", query = "SELECT v FROM VehicleMake v")
    , @NamedQuery(name = "VehicleMake.findByMake", query = "SELECT v FROM VehicleMake v WHERE v.make = :make")})
public class VehicleMake implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "MAKE")
    private String make;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "make")
    private Collection<VehicleOfInterest> vehicleOfInterestCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "make")
    private Collection<VehicleModel> vehicleModelCollection;

    public VehicleMake() {
    }

    public VehicleMake(String make) {
        this.make = make;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @XmlTransient
    public Collection<VehicleOfInterest> getVehicleOfInterestCollection() {
        return vehicleOfInterestCollection;
    }

    public void setVehicleOfInterestCollection(Collection<VehicleOfInterest> vehicleOfInterestCollection) {
        this.vehicleOfInterestCollection = vehicleOfInterestCollection;
    }

    @XmlTransient
    public Collection<VehicleModel> getVehicleModelCollection() {
        return vehicleModelCollection;
    }

    public void setVehicleModelCollection(Collection<VehicleModel> vehicleModelCollection) {
        this.vehicleModelCollection = vehicleModelCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (make != null ? make.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VehicleMake)) {
            return false;
        }
        VehicleMake other = (VehicleMake) object;
        if ((this.make == null && other.make != null) || (this.make != null && !this.make.equals(other.make))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.VehicleMake[ make=" + make + " ]";
    }
    
}
