
package com.csfrancis555.math613project1;

import java.util.HashMap;


public class Gaussian {
    
    ////////////////////////////  DATAFIELDS  ////////////////////////
    private Matrix A;
    private Matrix L;
    private Matrix U;
    private HashMap<String, Matrix> factoredLU = new HashMap<>();
    
    
    
    ////////////////////////////  CONSTRUCTORS  /////////////////////

    /**
     * gaussian elimination reduction on a given matrix for backfill solutions and an LU factorization
     * an identity matrix is popped into L to initialize it and then both L and U are filled by calling the elimination method
     * @param A The matrix to be reduced for solving with back substitution and LU factorization
     */
    public Gaussian(Matrix A) {
        this.A = A;
        this.L = Matrix.identity(this.A.getM(), this.A.getN());
        this.U = this.eliminate();
        this.factoredLU.put("L", this.L);
        this.factoredLU.put("U", this.U);
    }//end 1-arg constructor
    
    
    
    /////////////////////////////////  GETTERS AND SETTERS  /////////////////

    /**
     * retrieves a key-value mapping of the "L" "U" factorization of the matrix
     * @return 
     */
    public HashMap<String, Matrix> getFactoredLU() {
        return factoredLU;
    }
    
    
    
    
    
    
    
    ////////////////////////////////////  OPERATIONS  /////////////////////
    
    /**
     * applies gaussian elimination to reduce the given matrix
     * for each row after the first number take the element i(i-1) and divide by (i-1)(i-1) to get the pivot, then walk through row subtracting element(i-1)j from element ii  
     * @return the gausian elimination reduced matrix
     */
    public Matrix eliminate(){
        Matrix reduced = new Matrix(A.getMatrix());
        for(int i=1; i<A.getMatrix().length; i++){
            double pivot = A.getValue(i, i-1) / A.getValue(i-1, i-1);
            if(A.getValue(i, i-1) != 0){
                L.setValue(i, i-1, pivot);
                for(int j=i-1; j<A.getMatrix()[i].length; j++){
                    reduced.setValue(i, j, A.getValue(i, j) - pivot * A.getValue(i-1, j));
                }
            }
        }
        return reduced;
    }//end eliminate()
    
    
//    public Vector backFill(){
//        Vector x;
//        //TODO use the reduced matrix to backfill a solution to Ax=b
//        return x;
//    }//end backFill()
    
    
}//end Gaussian class
