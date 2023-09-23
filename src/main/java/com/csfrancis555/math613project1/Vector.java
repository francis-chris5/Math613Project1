
package com.csfrancis555.math613project1;

import java.io.File;
import java.util.Random;
import java.util.Scanner;

public class Vector {
    
    ///////////////////////////////////////  DATAFIELDS  ////////////////////
    private int n;
    private double[] vector;

    
    
    
    /////////////////////////////////////  CONSTRUCTORS  //////////////////
    
    /**
     * Constructor for this vector object
     * @param n the number of dimensions in the vector
     */
    public Vector(int n) {
        this.n = n;
        this.vector = new double[this.n];
    }//end 1-arg constructor
    
    
    
    //////////////////////////////////  GETTERS & SETTERS  ///////////////////////
    
    /**
     * retrieves a particular value from the vector
     * @param i the position of the value to be retrieved 
     * @return the value at the desired position
     */
    public double getValue(int i){
        return this.vector[i];
    }//end getValue()
    
    
    /**
     * changes an individual value in the vector
     * @param i the position to be changed
     * @param value the value to change it to
     */
    public void setValue(int i, double value){
        this.vector[i] = value;
    }//end setValue()
    
    
    /**
     * the entire vector as a matrix
     * @return 
     */
    public double[] getVector(){
        return this.vector;
    }//end getVector()

    
    /**
     * 
     * @return the number of dimensions in the vector
     */
    public int getN() {
        return n;
    }//end getN()
    
    
    
    
    /////////////////////////////////  OPERATIONS  //////////////////////////////
    
//    /**
//     * multiply by another vector placed on the right
//     * @param y the other vector
//     * @return a new vector with the product of this transposed and the other vector if they're the same size, null otherwise
//     */
//    public Vector rightMultiply(Vector y){
//        Vector p;
//        if(this.getN() == y.getN()){
//            //TODO right multiply vectors (transpose this)
//        }
//        else{
//            p = null;
//        }
//        return p;
//    }//end rightMultiply()
//    
//    
//    
//    /**
//     * multiply by another vector placed on the left
//     * @param y the other vector
//     * @return a new vector with the product of this and the other vector transposed if they're the same size, null otherwise
//     */
//    public Vector leftMultiply(Vector y){
//        Vector p;
//        if(this.getN() == y.getN()){
//            //TODO left multiply vectors (transpose y)
//        }
//        else{
//            p = null;
//        }
//        return p;
//    }//end leftMultiply()
//    
//    
//    /**
//     * multiply this vector by a scalar multiple
//     * @param s the scalar multiple
//     * @return the scaled vector
//     */
//    public Vector scalarMultiply(double s){
//        Vector y = new Vector(this.getN());
//        for(int i=0; i<this.getVector().length; i++){
//            y.setValue(i, this.getValue(i) * s);
//        }
//        return y;
//    }//end scalarMultiply()
//    
//    
//    /**
//     * adds this to another vector if they have the same number of dimensions
//     * @param y the other vector to be added
//     * @return the vector with the sum of each dimension if they're the same size, null otherwise
//     */
//    public Vector sum(Vector y){
//        Vector z;
//        if(this.getN() == y.getN()){
//            //TODO sum the vectors
//        }
//        else{
//            z = null;
//        }
//        return z;
//    }//end sum()
//    
//    
//    /**
//     * multiply this vector by a matrix on its left
//     * @param A the matrix to be multiplied by
//     * @return the resultant vector if they are compatible size, null otherwise
//     */
//    public Vector matrixMultiply(Matrix A){
//        Vector b;
//        if(this.getN() == A.getN()){
//            //TODO multiply by matrix on left
//        }
//        else{
//            b = null;
//        }
//        return b;
//    }
    
    
    
    ////////////////////////////////  FILL VECTOR VALUES  ///////////////////////
    
    
    /**
     * Fills this vector with random values between 0 and 1
     */
    public void randomFill(){
        Random rand = new Random();
        for(int i=0; i<this.getVector().length; i++){
            this.setValue(i, rand.nextDouble());
        }
    }//end randomFill()
    
    
    
    /**
     * In a realistic situation sensors would collect the massive amounts of data and store it in a way that could typically be easily exported as a .csv file, for test cases in class creating the .csv file in Excel seems reasonable.
     * @param filepath the filepath or URL where the .csv file is to be found
     */
    public void fillFromCSV(String filepath){
        File csv = new File(filepath);
        try{
            Scanner fromFile = new Scanner(csv);
            int i=0;
            while(fromFile.hasNextDouble()){
                this.setValue(i, fromFile.nextDouble());
                i++;
            }
        }
        catch(Exception e){
            this.randomFill();
        }
    }//end fillFromCSV()
    
    
    
    /////////////////////////////////  OVERRIDES  ////////////////////////

    /**
     * a console/terminal friendly textual representation of this vector
     * @return 
     */
    @Override
    public String toString() {
        String representation = new String("[");
        for(int i=0; i<this.getVector().length; i++){
            representation += this.getValue(i) + " ";
        }
        representation += "\b]^T";
        return representation;
    }//end toString()

    
    
    /**
     * compares to see if two vectors are equal
     * @param obj the other matrix to compare to
     * @return 
     */
    @Override
    public boolean equals(Object obj) {
        try{
            Vector y = (Vector)obj;
            if(this.getN() != y.getN()){
                return false;
            }
            boolean checking = true;
            for(int i=0; i<this.getVector().length; i++){
                if(this.getValue(i) != y.getValue(i)){
                    checking = false;
                }
            }
            return checking;
        }
        catch(Exception e){
            return false;
        }
    }//end equals()
    
    
}//end Vector class
