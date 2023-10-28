
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
        Vector v = new Vector(3);
        //v.randomFill();
        v.fillFromCSV("C:/Users/franc/Documents/NetBeansProjects/Math613Project1/vector.csv");
        System.out.println(v);
        

        Matrix A = new Matrix(3, 3);
        //A.randomFill();
        A.fillFromCSV("C:/Users/franc/Documents/NetBeansProjects/Math613Project1/matrix.csv");
        System.out.println(A);
        
        
        
        long start = System.nanoTime();
        
        System.out.println("\n\n\tApproximate Solution to Ax=b:");
        Vector x = Gaussian.eliminate(A, v);
        System.out.println("x' = " + x);
        
        
        System.out.println("\n\n\tSystem Created Rounding Error");
        Vector estimate = x.matrixMultiply(A);
        System.out.println("b' = " + estimate);
        Vector difference = v.difference(estimate);
        System.out.println(difference);
        System.out.println("one-norm: " + difference.getNorm(Norm.ONE));
        System.out.println("two-norm: " + difference.getNorm(Norm.TWO));
        System.out.println("inf-norm: " + difference.getNorm(Norm.INFINITE));
        
        long end = System.nanoTime();
        long duration = end - start;
        System.out.println("\n\nThe processing took " + duration + " nano seconds.");
        
        
        ////////////////////////////  EXTRAS  //////////////////////////////////
        
        System.out.println("\n\n\tEXTRA FEATURES");
        System.out.println("\n\n\tDeterminant of A");
        double d = Gaussian.getDeterminant(A);
        System.out.println(d);
        
        
        System.out.println("\n\n\tLU Factorization of A");
        HashMap<String, Matrix> LU = Gaussian.factorLU(A);
        System.out.println("L = " + LU.get("L"));
        System.out.println("U = " + LU.get("U"));
        
        

    }//end main()
}//end Main class
