
package com.csfrancis555.math613project1;


public class Math613Project1 {

    public static void main(String[] args) {
        Vector v = new Vector(3);
        //v.randomFill();
        v.fillFromCSV("C:/Users/franc/Documents/NetBeansProjects/Math613Project1/vector.csv");
        System.out.println(v);
        
        Matrix A = new Matrix(3, 3);
        A.fillFromCSV("C:/Users/franc/Documents/NetBeansProjects/Math613Project1/matrix.csv");
        System.out.println(A);
    }
}
