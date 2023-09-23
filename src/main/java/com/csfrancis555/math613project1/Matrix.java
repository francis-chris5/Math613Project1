
package com.csfrancis555.math613project1;


public class Matrix {
    
    //////////////////////////////  DATAFIELDS  /////////////////////////
    private int m;
    private int n;
    private double[][] matrix;

    
    ///////////////////////////////  CONSTRUCTORS  /////////////////////
    
    /**
     * Creates an empty matrix object to be filled later with either random values between 1 and 0 or loaded in from a .csv file (standard for sensor data collection)
     * @param m the number of rows in the matrix
     * @param n the number of columns in the matrix
     */
    public Matrix(int m, int n) {
        this.m = m;
        this.n = n;
        matrix = new double[m][n];
    }//end 2-arg constructor

    
    
    
    ///////////////////////////////  GETTERS & SETTERS  //////////////////////
    
    /**
     * 
     * @return the number of rows in the matrix
     */
    public int getM() {
        return m;
    }//end getM()

    
    /**
     * 
     * @return the number of columns in the matrix
     */
    public int getN() {
        return n;
    }//end getN()
    
    
    /**
     * Request a particular value from the matrix based on its position
     * @param i the row number of the desired value in the matrix
     * @param j the column number of the desired value in the matrix
     * @return the desired value from the matrix
     */
    public double getValue(int i, int j){
        return matrix[i][j];
    }//end getValue()
    
    
    /**
     * Alters a particular value in the matrix based on its position
     * @param i the row number of the value to change
     * @param j the column number of the value to change
     * @param value the desired value to put in the matrix
     */
    public void setValue(int i, int j, double value){
        this.matrix[i][j] = value;
    }//end setValue()

    
    /**
     * 
     * @return the entire matrix as a 2D array
     */
    public double[][] getMatrix() {
        return matrix;
    }//end getMatrix()
    
    
    
    
    
    /////////////////////////////////////////////  OPERATIONS  ////////////////
    
    /**
     * Multiply by placing another matrix to the right
     * @param B the other matrix
     * @return the product of this matrix with the other one on the right if they're compatible, null otherwise
     */
    public Matrix rightMultiply(Matrix B){
        Matrix C;
        if(this.getN() == B.getM()){
            //TODO right multiply another matrix
        }
        else{
            C = null;
        }
        return C;
    }//end rightMultiply()
    
    
    /**
     * Multiply by placing another matrix to the left
     * @param B the other matrix
     * @return the product of this matrix with the other one on the left if they're compatible, null otherwise
     */
    public Matrix leftMultiply(Matrix B){
        Matrix C;
        if(B.getN() == this.getM()){
            //TODO left multiply another matrix
        }
        else{
            C = null;
        }
        return C;
    }//end leftMultiply()
    
    
    /**
     * multiply this matrix by a scalar value
     * @param s the scalar to multiply by
     * @return the scaled matrix
     */
    public Matrix scalarMultiply(double s){
        Matrix C = new Matrix(this.getM(), this.getN());
        for(int i=0; i<this.getMatrix().length; i++){
            for(int j=0; j<this.getMatrix()[i].length; j++){
                C.setValue(i, j, this.getMatrix()[i][j] * s);
            }
        }
        return C;
    }//end scalarMultiply()
    
    
    /**
     * find the sum of this matrix with another appropriately sized matrix
     * @param B the other matrix to add to this one
     * @return a new matrix with the summed values if they're the same size, null otherwise
     */
    public Matrix sum(Matrix B){
        Matrix C;
        if(this.getN() == B.getN() && this.getM() == B.getM()){
            //TODO add the matrices
        }
        else{
            C = null;
        }
        return C;
    }//end sum()
    
    
    
    ////////////////////////////////////  FILL MATRIX VALUES  ////////////////////
    
    
    /**
     * Fills this matrix with random values between 0 and 1
     */
    public void randomFill(){
        //TODO fill the matrix with random values
    }//end randomFill()
    
    
    /**
     * In a realistic situation sensors would collect the massive amounts of data and store it in a way that could typically be easily exported as a .csv file, for test cases in class creating the .csv file in Excel seems reasonable.
     * @param filepath the filepath or URL where the .csv file is to be found
     */
    public void fillFromCSV(String filepath){
        //TODO fill the matrix with values listed in a .csv file
    }
    
}//end Matrix class