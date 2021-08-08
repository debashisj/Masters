/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Djena
 */
@Entity
@Table(name = "VEHICLE_OF_INTEREST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VehicleOfInterest.findAll", query = "SELECT v FROM VehicleOfInterest v")
    , @NamedQuery(name = "VehicleOfInterest.findByLicensePlate", query = "SELECT v FROM VehicleOfInterest v WHERE v.licensePlate = :licensePlate")
    , @NamedQuery(name = "VehicleOfInterest.findByVehYear", query = "SELECT v FROM VehicleOfInterest v WHERE v.vehYear = :vehYear")
    , @NamedQuery(name = "VehicleOfInterest.findByColor", query = "SELECT v FROM VehicleOfInterest v WHERE v.color = :color")
    , @NamedQuery(name = "VehicleOfInterest.findByOwnersName", query = "SELECT v FROM VehicleOfInterest v WHERE v.ownersName = :ownersName")
    , @NamedQuery(name = "VehicleOfInterest.findByOwnersPhone", query = "SELECT v FROM VehicleOfInterest v WHERE v.ownersPhone = :ownersPhone")})
public class VehicleOfInterest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "LICENSE_PLATE")
    private String licensePlate;
    @Size(max = 4)
    @Column(name = "VEH_YEAR")
    private String vehYear;
    @Size(max = 10)
    @Column(name = "COLOR")
    private String color;
    @Size(max = 30)
    @Column(name = "OWNERS_NAME")
    private String ownersName;
    @Size(max = 10)
    @Column(name = "OWNERS_PHONE")
    private String ownersPhone;
    @JoinColumn(name = "REASON", referencedColumnName = "REASON")
    @ManyToOne(optional = false)
    private ReasonForInterest reason;
    @JoinColumn(name = "MAKE", referencedColumnName = "MAKE")
    @ManyToOne(optional = false)
    private VehicleMake make;
    @JoinColumn(name = "MODEL", referencedColumnName = "MODEL")
    @ManyToOne(optional = false)
    private VehicleModel model;

    public VehicleOfInterest() {
    }

    public VehicleOfInterest(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getVehYear() {
        return vehYear;
    }

    public void setVehYear(String vehYear) {
        this.vehYear = vehYear;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getOwnersName() {
        return ownersName;
    }

    public void setOwnersName(String ownersName) {
        this.ownersName = ownersName;
    }

    public String getOwnersPhone() {
        return ownersPhone;
    }

    public void setOwnersPhone(String ownersPhone) {
        this.ownersPhone = ownersPhone;
    }

    public ReasonForInterest getReason() {
        return reason;
    }

    public void setReason(ReasonForInterest reason) {
        this.reason = reason;
    }

    public VehicleMake getMake() {
        return make;
    }

    public void setMake(VehicleMake make) {
        this.make = make;
    }

    public VehicleModel getModel() {
        return model;
    }

    public void setModel(VehicleModel model) {
        this.model = model;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (licensePlate != null ? licensePlate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VehicleOfInterest)) {
            return false;
        }
        VehicleOfInterest other = (VehicleOfInterest) object;
        if ((this.licensePlate == null && other.licensePlate != null) || (this.licensePlate != null && !this.licensePlate.equals(other.licensePlate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.VehicleOfInterest[ licensePlate=" + licensePlate + " ]";
    }
    
}
