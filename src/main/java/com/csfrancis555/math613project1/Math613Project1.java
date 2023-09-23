
package com.csfrancis555.math613project1;


public class Math613Project1 {

    public static void main(String[] args) {
        Vector v = new Vector(3);
        //v.randomFill();
        v.fillFromCSV("C:/Users/franc/Documents/NetBeansProjects/Math613Project1/vector.csv");
        System.out.println(v);

        Matrix A = new Matrix(3, 3);
        //A.randomFill();
        A.fillFromCSV("C:/Users/franc/Documents/NetBeansProjects/Math613Project1/matrix.csv");
        System.out.println(A);
        
        Matrix B = new Matrix(3, 3);
        Matrix C = new Matrix(3, 3);
        B.fillFromCSV("C:/Users/franc/Documents/NetBeansProjects/Math613Project1/matrix.csv");
        C.fillFromCSV("C:/Users/franc/Documents/NetBeansProjects/Math613Project1/matrix.csv");
        Matrix D = A.sum(B);
        Matrix E = A.scalarMultiply(3);
        Matrix F = A.rightMultiply(B);
        System.out.println(D);
        System.out.println(E);
        System.out.println(F);
        
        Vector y = v.matrixMultiply(A);
        System.out.println(y);
        
    }
}
