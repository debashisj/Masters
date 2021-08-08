/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package floormeasuringtool.test;

import floormeasuringtool.FloorMeasuringTool;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;
import static org.junit.Assert.assertTrue;


/**
 *
 * @author djena
 */
public class FloorMeasuringToolTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    public FloorMeasuringToolTest() {
    }

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }
    @Test
    public void main_printShapeArea() throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
        Method method = FloorMeasuringTool.class.getDeclaredMethod("printShapeArea", Scanner.class, Scanner.class);
        method.setAccessible(true);
        method.invoke(null, new Scanner("R"), new Scanner("4\n3"));
        assertTrue(outContent.toString().contains("The area is 12.0"));
    }
}
