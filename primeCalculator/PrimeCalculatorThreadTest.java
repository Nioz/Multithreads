/*
 * Nicholas Bertinelli
 * 03/05/2019
 * Multiplying Matrices HW
 * Dr. Eugenio Cesario CS 438/505 50
 */

package scalarProduct;

public class PrimeCalculatorThreadTest {

	public static void main(String[] args) throws InterruptedException {
		Thread ct = Thread.currentThread();
		System.out.println("Main thread name: " + ct.getName());
		int firstNum = 1;
		int lastNum = 20;
		int numOfThreads = 3;
		int numOfFoundPrimeNumbers = 0;
		
		int range= (int)(lastNum - firstNum  +1) / numOfThreads;
		
		
		long startTime = System.currentTimeMillis();
		
		PrimeCalculatorThread threads [] = new PrimeCalculatorThread[numOfThreads];
		
		int init = -1, end = -1;
		
		for(int i = 0; i < numOfThreads; i++) {
				init = i * range + firstNum;
				end = (i < numOfThreads - 1) ? (init + range - 1) : (lastNum);
				
				threads[i] = new PrimeCalculatorThread(init, end);
			}
			
			for(int i = 0; i < numOfThreads; i++) {
				threads[i].start();
			}
			
			for (int i = 0; i < numOfThreads; i++) {
				threads[i].join();
			}
			

		int result = 0;
		
		
		long curTime = System.currentTimeMillis();
		long duration = (curTime - startTime) / 1000;
		
		for(int i = 0; i < numOfThreads; i++) {
			numOfFoundPrimeNumbers += threads[i].getNumPrimeNumbers();
		}
		
		//System.out.println("Result = " + numOfFoundPrimeNumbers + " Duration: " + duration);
		
		
		
		

	}
	// from = (i + s) + 1
	// to = from + s - 1

}
