/*********************************************************
 * Nicholas Bertinelli
 * CS 438/505
 * 4/2/2019
 * Dr. Cesario
 * Homework 3
 *********************************************************/

package semaphores;

import java.util.concurrent.Semaphore;

//This should print out A B B C A B B C
public class ABBC {
	private static Semaphore semA = new Semaphore(1);
	private static Semaphore semB = new Semaphore(0);
	private static Semaphore semC = new Semaphore(0);
	private static Semaphore mutex = new Semaphore(1);
	private static int countB = 0;

	public static void main(String[] args) throws Exception {
		while (true) {
			// Creating Threads
			Thread a = new A();
			Thread b = new B();
			Thread c = new C();
			// Starting Threads
			a.start();
			b.start();
			c.start();
			Thread.sleep(750);
		} // end While

	}// End Main

	private static class A extends Thread {
		public void run() {
			try {
				semA.acquire();
				mutex.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.print("A ");

			mutex.release();
			semB.release(1);
		}// end run
	}// end A class

	private static class B extends Thread {
		public void run() {
			try {
				semB.acquire();
				mutex.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.print("B ");
			countB++;

			if (countB == 1)
				semB.release();
			else if (countB == 2)
				semC.release();

			mutex.release();

		}// end run
	}// end B class

	private static class C extends Thread {
		public void run() {
			try {
				semC.acquire();
				mutex.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.print("C ");

			countB = 0;

			mutex.release();
			semA.release();

		}// end run
	}// end C class

}

/********************************* CODE OUTPUT ************************************************
 * A B B C A B B C A B B C A B B C A B B C A B B C A B B C A B B C
 **********************************************************************************************/
