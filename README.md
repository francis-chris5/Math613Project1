# MATH 613 Project 1
___
Class project for an Applied Linear Algebra course taught at Indiana State University in the fall semester of 2023.

The javadoc for this project can be found at https://francis-chris5.github.io/Math613Project1 

The program is designed to take as input one $n$-dimensional vector, $\vec{b}$, stored in CSV file (only 1 entry per line, so as a column vector), and two $m \times n$ matrices, $A$ and $B$, stored in a CSV file. An object exists in the package to create matrix and vector CSV files of a given size filled with random values in the range $(0, 1)$ to be used in test cases. As per the instructions $A$ and $\vec{b}$ are multiplied by a scalar of 10.

It will then use Gaussian Elimination to solve a system of equations in the form of $A \vec{x} = \vec{b}$ and determine an approximate solution $x'$.

Once $x'$ is known the program will turn around and multiply that by $A$ to get a value labeled as $b'$ and approximate the error introduced by the limitations of the double precision floating point numbers used in the Java Programming language: truncated at 64 bits rather than rounding. It will then display the $1$-norm, $2$-norm, and $\infty$-norm for the error.

Following this the output will display the eigenvalues for the matrix $10 B B^T { 1 \over 2}$ which were found using the Jacobi method.
