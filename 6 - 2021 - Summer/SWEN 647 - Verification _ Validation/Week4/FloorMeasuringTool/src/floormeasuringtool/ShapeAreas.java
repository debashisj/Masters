/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package floormeasuringtool;

/**
 *
 * @author mbrown15
 */
public class ShapeAreas {
    
    public double oneParameter(String shape, float p1)
    {
        float area;
        if (shape.equals("C"))
            return p1 * p1 * Math.PI;
        else if (shape.equals("S"))
            return p1 * p1;
        else 
            return -1.0;
    }
    
    public double twoParameter(String shape, float p1, float p2)
    {
        float area;
        if (shape.equals("R"))
            return p1 * p2;
        else if (shape.equals("T"))
            return 0.5 * p1 * p2;
        else
            return -1.0;
    }
}
