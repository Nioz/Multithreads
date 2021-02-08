package atomicvariables;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicMatrixTest {

	public static void main(String[] args) {
		int m = 4;
		int n = 2;
		int[] dec = new int[n];
		int[] inc = new int[m];
		
		AtomicInteger[][] arr1 = new AtomicInteger[n][m];
		
		
		int arr2[][] = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				arr1[i][j] = new AtomicInteger(0);
			}
			}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				arr2[i][j] = 0;
				System.out.println(arr2[i][j] + "\t");
			}
			System.out.println();
		}
		
		System.out.println(arr1);
		
		AtomicRowThread[] rowThreads = new AtomicRowThread[n];
		AtomicColThread[] colThreads= new AtomicColThread[m];
		
		for(int i = 0; i < n; i++) {
			int temp[] = new int[m];
			for(int j = 0; j < m; j++) {
				temp[j] = arr2[i][j];
			}
		
		
		rowThreads[i] = new AtomicRowThread(i, n, temp, dec);
		rowThreads[i].start();
		try {
			rowThreads[i].join();
		} catch(InterruptedException e) {}
		
		}
		
		for(int i = 0; i < n; i++) {
			System.out.println(dec[i] + " \t");
		}

	}

}
