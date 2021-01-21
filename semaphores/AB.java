package semaphores;

import java.util.concurrent.Semaphore;

public class AB {
	
	private static Semaphore semA = new Semaphore(2);
	private static Semaphore semB = new Semaphore(0);
	//since this is a shared variable, we give this one token so only one thread can modify this at a time
	private static Semaphore mutex = new Semaphore(1); 
	private static int countA = 0;

	public static void main(String[] args) throws Exception {
		while(true) {
			Thread a = new A();
			Thread b = new B();
			a.start();
			b.start();
			Thread.sleep(1000);
		}// while
	}// main



private static class A extends Thread {
	public void run() {
	
	//Statement before printing
	
	try {
		//Acquires the semA token
		semA.acquire();
		//Mutex.acquire allows A to hold onto the mutex token and be sure that it is the only one modifying it
		mutex.acquire();
	} catch ( InterruptedException e) {e.printStackTrace();}
	
	System.out.print("A ");
	
	countA++;
	//If count is 2 then release the token to semaphore B so B can take the token and run
	if(countA == 2)
		semB.release();
	
	//regardless, we want to release mutex so that the other class(es) may work with and modify it
	mutex.release();
	
	//semB.release();
	}//run
} //A Class

/*
 * another implementation is to pass through one token, check if count is 1, and if it is then return the semaphore to semA
 */

private static class B extends Thread {
	public void run() {
	
	//Statement before printing
	
	try {
		//semB takes the token
		semB.acquire();
	} catch ( InterruptedException e) {e.printStackTrace();}
	
	System.out.print("B ");
	
	countA = 0;
	mutex.release();
	semA.release(2);
	
	//semA.release(); This is for printing A B A B exercise
	}//run
} //B Class

}

