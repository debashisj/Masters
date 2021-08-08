/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package floormeasuringtool.test;

import floormeasuringtool.ShapeAreas;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author djena
 */
public class ShapeAreasTest {
    
    public ShapeAreasTest() {
    }

    @Test
    public void oneParameterTest_circle() {
        System.out.println(Math.PI);
        ShapeAreas shapeAreas = new ShapeAreas();
        assertEquals(50.26, shapeAreas.oneParameter("C", 4), 0.01);
    }

    @Test
    public void oneParameterTest_square() {
        ShapeAreas shapeAreas = new ShapeAreas();
        assertEquals(16, shapeAreas.oneParameter("S", 4), 0.0);
    }

    @Test
    public void oneParameterTest_else() {
        ShapeAreas shapeAreas = new ShapeAreas();
        assertEquals(-1, shapeAreas.oneParameter("K", 4), 0.0);
    }

    @Test
    public void twoParameterTest_rectangle() {
        ShapeAreas shapeAreas = new ShapeAreas();
        assertEquals(20, shapeAreas.twoParameter("R", 4, 5), 0.01);
    }

    @Test
    public void twoParameterTest_triangle() {
        ShapeAreas shapeAreas = new ShapeAreas();
        assertEquals(12, shapeAreas.twoParameter("T", 4, 6), 0.0);
    }

    @Test(expected = NullPointerException.class)
    public void twoParameterTest_triangle_exception() {
        ShapeAreas shapeAreas = new ShapeAreas();
        shapeAreas.twoParameter(null, 4, 6);
    }

    @Test
    public void twoParameterTest_else() {
        ShapeAreas shapeAreas = new ShapeAreas();
        assertEquals(-1, shapeAreas.twoParameter("K", 4, 7), 0.0);
    }
}
