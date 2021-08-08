/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package floormeasuringtool;

import java.util.Scanner;

/**
 * @author mbrown15
 */
public class FloorMeasuringTool {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanstr = new Scanner(System.in);
        Scanner scanfloat = new Scanner(System.in);

        System.out.println("UMUC Floor Measuring Tool\n");
        System.out.println("Enter the shape of the room.");
        System.out.println("Square (S)");
        System.out.println("Rectangle (R)");
        System.out.println("Triangle (T)");
        System.out.println("Circle (C)");

        printShapeArea(scanstr, scanfloat);
    }

    private static void printShapeArea(Scanner scanstr, Scanner scanfloat) {
        ShapeAreas sa = new ShapeAreas();
        String shape = scanstr.nextLine();
        if (shape.equals("C"))
            System.out.println("Enter the radius.");
        else
            System.out.println("Enter the width.");
        float parameter1 = scanfloat.nextFloat();

        if (shape.equals("R") || shape.equals("T")) {
            System.out.println("Enter the height.");
            float parameter2 = scanfloat.nextFloat();
            System.out.println("The area is " + sa.twoParameter(shape, parameter1, parameter2));
        } else {
            System.out.println("The area is " + sa.oneParameter(shape, parameter1));
        }
    }
}
