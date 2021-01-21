/*
 * nicholas bertinelli
 * 03/05/2019
 * multiplying matrices HW
 * Dr. Eugenio cesario cS 438/505 50
 */

package matrixMultiplication;

public class MatricesMultiTest {
    public static void main(String[] args) {  
       
        //Declaring two matrices a & b
        int [][] a = {{3, 7}, {3,2}, {6,5}, {4,8}};
        int [][] b = {{3, 7, 2}, {3,2,9}};  


        //these variables are used as the dimensions of the matrices
        int m = a[0].length; //2
        int k = b[0].length; //3
        int n = a.length;    //4
      
        //Initializes the matrix of c and the threads of c with the nxk dimensions of a & b
        int [][] c = new int [n][k];
        MatricesMulti [][] Threads = new MatricesMulti[n][k];

       
       
        //creating the threads that calculate each value for c
        for (int i = 0; i<n; i++){
            for (int j=0; j<k; j++){
                Threads[i][j] = new MatricesMulti(a, b, c, i, j);
                Threads[i][j].start();
                try {
                    //Synchronizes the threads, makes them go in order
                Threads[i][j].join();
                }
                catch(InterruptedException e) {}
            } //end j for
        } // end i for
       
        for(int i = 0; i < n; i++) {
            //rowThreads[i] = new MatricesMulti(i);
        }
      
        //Displays dimensions of matrices
        System.out.println("Dimensions of the matrices: ");
        System.out.println("m = " + a[0].length);
        System.out.println("k = " + b[0].length);
        System.out.println("n = " + a.length   );
      
        //Prints out elements of matrix a
        System.out.println("Elements of matrix A:");
        for (int i = 0; i<n; i++){
            for (int j=0; j<m; j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
       

        //Prints out elements of matrix b
        System.out.println("Elements of matrix B:");
        for (int i = 0; i<m; i++){
            for (int j=0; j<k; j++){
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }

      
        //Prints out elements of matrix c
        System.out.println("Elements of matrix C:");
        for (int i = 0; i<n; i++){
            for (int j=0; j<k; j++){
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
    }
}

/* cODE OUTPUT:
 * Dimensions of the matrices:
Dimensions of the matrices:
m = 2
k = 3
n = 4
Elements of matrix A:
3 7
3 2
6 5
4 8
Elements of matrix B:
3 7 2
3 2 9
Elements of matrix C:
30 35 69
15 25 24
33 52 57
36 44 80
*/