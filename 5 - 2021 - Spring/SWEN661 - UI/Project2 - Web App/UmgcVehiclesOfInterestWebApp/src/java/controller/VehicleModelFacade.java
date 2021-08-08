/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.VehicleModel;

/**
 *
 * @author Djena
 */
@Stateless
public class VehicleModelFacade extends AbstractFacade<VehicleModel> {

    @PersistenceContext(unitName = "UmgcVehiclesOfInterestWebAppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VehicleModelFacade() {
        super(VehicleModel.class);
    }
    
}
