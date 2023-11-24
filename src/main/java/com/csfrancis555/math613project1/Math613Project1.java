
package com.csfrancis555.math613project1;

import java.util.HashMap;


/**
 * The Main class for demonstrating a test case of the project objects
 * @author Chris Francis
 */
public class Math613Project1 {

    /**
     * Main method for test cases and telemetry on the project
     * @param args command line starting arguments are not used here
     */
    public static void main(String[] args) {
        //RandomValues rv = new RandomValues(10, 10);
        Vector v = new Vector(10);
        //v.randomFill();
        v.fillFromCSV("C:/Users/franc/Documents/NetBeansProjects/Math613Project1/vector.csv");
        v = v.scalarMultiply(10);
        System.out.println("b = \n" + v);
        

        Matrix A = new Matrix(10, 10);
        //A.randomFill();
        A.fillFromCSV("C:/Users/franc/Documents/NetBeansProjects/Math613Project1/matrix.csv");
        A = A.scalarMultiply(10);
        System.out.println("A = \n" + A);
        
        
        
        Matrix B = new Matrix(10, 10);
        //B.randomFill();
        B.fillFromCSV("C:/Users/franc/Documents/NetBeansProjects/Math613Project1/matrix.csv");
        B = B.scalarMultiply(10);
        B = B.rightMultiply(B.transpose());
        B = B.scalarMultiply(0.5);
        System.out.println("B = \n" + B);
        
        
        long start = System.nanoTime();
        
        System.out.println("\n\n\tApproximate Solution to Ax=b:");
        Vector x = Gaussian.eliminate(A, v);
        System.out.println("x' = " + x);
        
        
        System.out.println("\n\n\tSystem Created Rounding Error");
        Vector estimate = x.matrixMultiply(A);
        System.out.println("b' = " + estimate);
        Vector difference = v.difference(estimate);
        System.out.println("Difference: " + difference);
        System.out.println("one-norm: " + difference.getNorm(Norm.ONE));
        System.out.println("two-norm: " + difference.getNorm(Norm.TWO));
        System.out.println("inf-norm: " + difference.getNorm(Norm.INFINITE));
        
        
        System.out.println("\n\n\tEignenvalues of B");
        Jacobi J = new Jacobi(B);
        System.out.println("J = \n" + J.reduced(0.001));
        
        long end = System.nanoTime();
        long duration = end - start;
        System.out.println("\n\nThe processing took " + duration + " nano seconds.");
        

        
        

    }//end main()
}//end Main class
