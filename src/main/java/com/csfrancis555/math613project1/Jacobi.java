
package com.csfrancis555.math613project1;


public class Jacobi {
    
    ///////////////////////////  DATAFIELDS  ///////////////////////////////////
    
    private Matrix A;
    
    
    
    
    ///////////////////////////  CONSTRUCTORS  ////////////////////////////////
    
    /**
     * Constructor for the class which finds eigenvalues by the Jacobi method
     * @param A the matrix to find the eigenvalues of
     */
    public Jacobi(Matrix A){
        this.A = A;
    }//end one-arg constructor
    
    
    
    
    
    //////////////////////////////  OPERATIONS  ///////////////////////////////
    
    
    /**
     * Finds the outer norm of the matrix A passed into the object
     * @return the sum of squares for everything except the main diagonal
     */
    public double outerNorm(){
        double norm = 0.0;
        for(int i=0; i<A.getM(); i++){
            for(int j=0; j<A.getN(); j++){
                if(i != j){
                    norm += Math.pow(Math.abs(A.getValue(i, j)), 2);
                }
            }
        }
        return norm;
    }//end outerNorm()
    
    
    
    /**
     * function to find the sign of a value, used in the jacobi method
     * @param x the value to determine the sign of
     * @return either a positive or negative one
     */
    private int sign(double x){
        if(x < 0){
            return -1;
        }
        else{
            return +1;
        }
    }//end sign()
    
    
    
    
    /**
     * Reduces the matrix to one with approximations for the eigenvalues on the main diagonal
     * @param epsilon a very small positive number to serve as a threshold for "close enough" to zero
     * @return a matrix with approximate eigenvalues on the main diagonal
     */
    public Vector reduced(double epsilon){
        Matrix D = new Matrix(A.getM(), A.getN());
        for(int i=0; i<D.getM(); i++){
            for(int j=0; j<D.getN(); j++){
                D.setValue(i, j, A.getValue(i, j));
            }
        }
        double norm = outerNorm();
        while(norm > epsilon){
            int[] target = {0, 0};
            double max = 0;
            for(int i=0; i<D.getM(); i++){
                for(int j=0; j<D.getN(); j++){
                    if(Math.abs(D.getValue(i, j)) > max){
                        max = D.getValue(i, j);
                        target[0] = i;
                        target[1] = j;
                    }
                }
            }
            double theta = 0.5 * (D.getValue(target[0], target[0]) - D.getValue(target[1], target[1]))/D.getValue(target[0], target[1]);
            double t = sign(theta) / (Math.abs(theta) + Math.sqrt(1 + theta * theta));
            double c = 1.0 / Math.sqrt(1 + t * t);
            double s = c * t;
            D.setValue(target[0], target[0], A.getValue(target[0], target[0]) - t * A.getValue(target[0], target[1]));
            D.setValue(target[1], target[1], A.getValue(target[1], target[1]) + t * A.getValue(target[0], target[1]));
            for(int l=0; l<D.getN(); l++){
                if(l != target[0] && l != target[1]){
                    D.setValue(target[0], l, c * A.getValue(target[0], l) + s * A.getValue(target[1], l));
                    D.setValue(target[1], l, -s * A.getValue(target[0], l) + c * A.getValue(target[1], l));
                }
            }
            norm = norm - 2 * Math.pow(A.getValue(target[0], target[1]), 2);
        }
        Vector J = new Vector(D.getN());
        for(int i=0; i<D.getN(); i++){
            J.setValue(i, D.getValue(i, i));
        }
        return J;
    }//end reduced()
    
    
    
}//end Jacobi class
