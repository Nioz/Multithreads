/*
 * Nicholas Bertinelli
 * CS 438
 * HW1 ScalarProduct 
 * 2/12/2019
 */

package scalarProduct;

public class ScalarHW1 extends Thread {
	
	private int begin, end, ris;
	int [] v1, v2;
	
	public ScalarHW1(String name, int [] v1, int [] v2, int begin, int end) {
		setName(name);
		this.v1 = v1;
		this.v2 = v2;
		this.begin = begin;
		this.end = end;
		this.ris = 0;
	}
	
	public void run() {
		System.out.println(Thread.currentThread().getName() + " [" + begin + "," + end + "] started!");
		ris = 0;
		for(int i = begin; i <= end; i++)
			ris += v1[i] * v2[i];
	}
	
	public int getResult() {
		return ris;
	}

}

/*
 **************************** CODE OUTPUT****************************
T0 [0,1] started!
T3 [6,9] started!
T1 [2,3] started!
T2 [4,5] started!
Result 0 = 5
Result 1 = 25
Result 2 = 61
Result 3 = 294
Result = 385
 * 
 * 
 */
