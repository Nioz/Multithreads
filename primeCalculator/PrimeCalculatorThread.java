/*
 * Nicholas Bertinelli
 * 03/05/2019
 * Multiplying Matrices HW
 * Dr. Eugenio Cesario CS 438/505 50
 */

package scalarProduct;
import java.util.*;

public class PrimeCalculatorThread extends Thread {
	private int begin, end, numOfFoundPrimeNumbers;
	private ArrayList<Integer> primeNumberList;
	
	/*
	private final static int MIN_WAIT = 1; //to simulate a random wait
	private final static int MAX_WAIT = 3; //to simulate a random wait
	private Random random;
	*/
	
	public PrimeCalculatorThread(int begin, int end) {
		super();
		numOfFoundPrimeNumbers = 0;
		this.begin = begin;
		this.end = end;
		primeNumberList = new ArrayList<Integer>();
		
		//random = new Random(); //to be added to simulate a random wait
		}
	
	public void run() {
		boolean isPrime;
		int j;
		
		System.out.println(Thread.currentThread().getName() + " [" + begin + "," + end + "] started.");
		
		for(int curNumber = begin; curNumber <= end; curNumber++) {
			isPrime = true;
			if(curNumber == 1)
				isPrime = false;
			for(j = 2; j < curNumber; j++) {
				if(curNumber % j == 0)
					isPrime = false;
			}
			if(isPrime) {
				numOfFoundPrimeNumbers++;
				primeNumberList.add(curNumber);
				//randomWait();
			}
			
		}
		System.out.println(Thread.currentThread().getName() + "... " + Thread.currentThread().getName() + "[ " + begin + ","  + end + "] completed." 
		/*+ "\nPrime Numbers Found: " + numOfFoundPrimeNumbers + "(" + getPrimeNumbers() + ")"*/);
	}
	
	public int getNumPrimeNumbers() {
		return numOfFoundPrimeNumbers;
	}
	
	public String getPrimeNumbers() {
		String s = "";
		for(int i = 0; i < primeNumberList.size(); i++)
			s += primeNumberList.get(i) + " ";
		return s;
	}
	
	/*
	//This is implementing an I/O burst to make the CPU more efficient
	private void randomWait() {
		try {
			int randomTime = random.nextInt(MAX_WAIT - MIN_WAIT + 1) + MIN_WAIT;
			Thread.sleep(randomTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	*/
	
	
	

}



/*** CODE OUTPUT
*Main thread name: main
Thread-0 [1,6] started.
Thread-2 [13,20] started.
Thread-1 [7,12] started.
Thread-0... Thread-0[ 1,6] completed.
Thread-2... Thread-2[ 13,20] completed.
Thread-1... Thread-1[ 7,12] completed.
Result = 8 Duration: 0

*
*
*/