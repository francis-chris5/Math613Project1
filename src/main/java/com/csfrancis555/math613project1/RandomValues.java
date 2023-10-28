
package com.csfrancis555.math613project1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class to create a random matrix and random vector to be used in this project
 * @author Chris Francis
 */
public class RandomValues {
    private int m;
    private int n;
    
    /**
     * The constructor will create the CSV files for a matrix and a vector to be used in the program as a test case
     * @param m the number of rows in the matrix A
     * @param n the number of columns in the matrix A and rows in the column vector x
     */
    public RandomValues(int m, int n){
        Random rand = new Random();
        this.m = m;
        this.n = n;
        double[][] A = new double[m][n];
        double[] b = new double[n];
        for(int i=0; i<this.m; i++){
            for(int j=0; j<this.n; j++){
                A[i][j] = rand.nextDouble();
            }
        }
        for(int i=0; i<this.n; i++){
            b[i] = rand.nextDouble();
        }
        File matrix = new File("mat.csv");
        File vector = new File("vec.csv");
        try {
            PrintWriter matrixWriter = new PrintWriter(matrix);
            PrintWriter vectorWriter = new PrintWriter(vector);
            for(int i=0; i<this.m; i++){
                for(int j=0; j<this.n; j++){
                    if(j < n-1){
                        matrixWriter.print(A[i][j] + ",");
                    }
                    else{
                        matrixWriter.println(A[i][j]);
                    }
                }
            }
            for(int i=0; i<n; i++){
                vectorWriter.println(b[i]);
            }
            matrixWriter.close();
            vectorWriter.close();
        } 
        catch(Exception e) {
            //just move on then
        }
    }//end 2-arg constructor
    
}//end RandomValues class
