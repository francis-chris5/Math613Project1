
package com.csfrancis555.math613project1;

import java.util.HashMap;


/**
 * Static class of methods for Gaussian Elimination related operations on a Matrix object
 * @author Chris Francis
 */
public class Gaussian {
    
    ////////////////////////////////////  OPERATIONS  /////////////////////
    

    /**
     * applies gaussian elimination to reduce the given matrix to find L and U
     * @param A the matrix to be factored
     * @return key value pair collection holding the matrices "L" and "U"
     */
    public static HashMap<String, Matrix> factorLU(Matrix A){
        Matrix U = new Matrix(A.getM(), A.getN());
        for(int i=0; i<A.getMatrix().length; i++){
            for(int j=0; j<A.getMatrix()[i].length; j++){
                U.setValue(i, j, A.getValue(i, j));
            }
        }
        Matrix L = Matrix.identity(U.getM(), U.getN());
        for(int i=1; i<U.getMatrix().length; i++){
            double pivot = U.getValue(i, i-1) / U.getValue(i-1, i-1);
            if(U.getValue(i, i-1) != 0){
                L.setValue(i, i-1, pivot);
                for(int j=i-1; j<U.getMatrix()[i].length; j++){
                    U.setValue(i, j, U.getValue(i, j) - pivot * U.getValue(i-1, j));
                }
            }
        }
        HashMap<String, Matrix> factorization = new HashMap<>();
        factorization.put("L", L);
        factorization.put("U", U);
        return factorization;
    }//end reduce()
    
    
    
    /**
     * Uses gaussian elimination to solve a system of equations in the form A <b>x</b> = <b>b</b>
     * @param A the coefficient matrix from the system of equations
     * @param b the vector of solutions from each equation in the original system of equations
     * @return the vector <b>x</b> of solutions to the system of equations
     */
    public static Vector eliminate(Matrix A, Vector b){
        Matrix reduced = new Matrix(A.getM(), A.getN());
        for(int i=0; i<A.getMatrix().length; i++){
            for(int j=0; j<A.getMatrix()[i].length; j++){
                reduced.setValue(i, j, A.getValue(i, j));
            }
        }
        Vector solution = Vector.zero(b.getN());
        solution.setValue(0, b.getValue(0));
        for(int i=1; i<reduced.getMatrix().length; i++){
            double pivot = reduced.getValue(i, i-1) / reduced.getValue(i-1, i-1);
            if(reduced.getValue(i, i-1) != 0){
                for(int j=i-1; j<reduced.getMatrix()[i].length; j++){
                    reduced.setValue(i, j, reduced.getValue(i, j) - pivot * reduced.getValue(i-1, j));
                }
                solution.setValue(i, b.getValue(i) - pivot * solution.getValue(i-1));
            }
        }
        for(int i=reduced.getMatrix().length-1; i>=0; i--){
            double reduction = reduced.getValue(i, i);
            for(int j=reduced.getMatrix()[i].length-1; j>i; j--){
                solution.setValue(i, solution.getValue(i) - reduced.getValue(i, j)*solution.getValue(j));
            }
            solution.setValue(i, solution.getValue(i)/reduction);
        }
        return solution;
    }//end eliminate()
    
    

    
    
    /**
     * The determinant of the given matrix found by the LU factorization
     * @param A the matrix to find the determinant of
     * @return the determinant of the matrix
     */
    public static double getDeterminant(Matrix A){
        HashMap<String, Matrix> LU = factorLU(A);
        Matrix U = LU.get("U");
        double d = 1;
        for(int i=0; i<U.getMatrix().length; i++){
            d *= U.getValue(i, i);
        }
        return d;
    }//end getDeterminant()
    

    
    
}//end Gaussian class
