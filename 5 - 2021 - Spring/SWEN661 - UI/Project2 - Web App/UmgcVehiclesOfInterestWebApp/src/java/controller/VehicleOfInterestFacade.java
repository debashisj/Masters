/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.VehicleOfInterest;

/**
 *
 * @author Djena
 */
@Stateless
public class VehicleOfInterestFacade extends AbstractFacade<VehicleOfInterest> {

    @PersistenceContext(unitName = "UmgcVehiclesOfInterestWebAppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VehicleOfInterestFacade() {
        super(VehicleOfInterest.class);
    }
    
}
