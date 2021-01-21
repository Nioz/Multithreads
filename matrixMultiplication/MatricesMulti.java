/*
 * Nicholas Bertinelli
 * 03/05/2019
 * Multiplying Matrices HW
 * Dr. Eugenio Cesario CS 438/505 50
 */
package matrixMultiplication;

public class MatricesMulti extends Thread {
  
    private int [][] a;
    private int [][] b;
    private int [][] c;
    private int row;
    private int col;
  
    //Constructor for thread(s)
    public MatricesMulti(int[][] a, int[][] b, int[][] c, int row, int col) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.row = row;
        this.col = col;
    } //End constructor

   
  
    //Run method that adds the row of A * the col of B throughout both matrices of A & B
    public void run() {
        c[row][col] = (a[row][0] * b[0][col]) + (a[row][1]*b[1][col]) ;
    } 
}