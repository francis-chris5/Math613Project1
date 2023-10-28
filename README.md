# MATH 613 Project 1
___
Class project for an Applied Linear Algebra course taught at Indiana State University in the fall semester of 2023.

The javadoc for this project can be found at https://francis-chris5.github.io/Math613Project1 

The program is designed to take as input one $$ n $$-dimensional vector, $$ \vec{b} $$, stored in CSV file (only 1 entry per line, so as a column vector), and an $$ m \times n $$ matrix, $$ A $$, stored in a CSV file. An object exists in the package to create matrix and vector CSV files of a given size filled with random values in the range $$ (0, 1) $$ to be used in test cases.

It will then use Gaussian Elimination to solve a system of equations in the form of $$ A \vec{x} = \vec{b} $$ and determine an approximate solution $$ x' $$.

Once $$ x' $$ is known the program will turn around and multiply that by $$ A $$ to get a value labeled as $$ b' $$ and approximate the error introduced by the limitations of the double precision floating point numbers used in the Java Programming language: truncated at 64 bits rather than rounding. It will then display the $$ 1 $$-norm, $$ 2 $$-norm, and $$ \infty $$-norm for the error.

The program will also find the $$ LU $$-factorization of the matrix $$ A $$ since that is a byproduct of Gaussian Elimination, and use the trace of the upper triangular matrix $$ U $$ to calculate the determinant of $$ A $$.

