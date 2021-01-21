/*********************************************************
 * Nicholas Bertinelli
 * CS 438/505
 * 4/2/2019
 * Dr. Cesario
 * Homework 3
 *********************************************************/

package semaphores;

import java.util.concurrent.Semaphore;

public class CBABA {
	// This should output C B A B A C B A B A

	private static Semaphore semA = new Semaphore(0);
	private static Semaphore semB = new Semaphore(0);
	private static Semaphore semC = new Semaphore(1);
	private static Semaphore mutex = new Semaphore(1);
	private static int countA = 0;

	public static void main(String[] args) throws Exception {
		while (true) {
			Thread c = new C();
			Thread b = new B();
			Thread a = new A();
			c.start();
			b.start();
			a.start();
			Thread.sleep(1000);
		}

	}// main

	private static class C extends Thread {
		public void run() {
			try {
				semC.acquire();
				mutex.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.print("C ");

			semB.release();
			mutex.release();

		}
	} // end C class

	private static class B extends Thread {
		public void run() {
			try {
				semB.acquire();
				mutex.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.print("B ");

			semA.release();
			mutex.release();
		}// end run
	}// end B class

	private static class A extends Thread {
		public void run() {
			try {
				semA.acquire();
				mutex.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}// end try/catch

			System.out.print("A ");

			countA++;
			if (countA == 2) {
				countA = 0;
				semC.release();
				mutex.release();
			} else {
				semB.release();
				mutex.release();
			}// end if/else
		}// end run
	} // end A class

}

/********************************* CODE OUTPUT ************************************************
 * C B A B A C B A B A C B A B A C B A B A C B A B A C B A B A C B A B A C B A B A
 **********************************************************************************************/
