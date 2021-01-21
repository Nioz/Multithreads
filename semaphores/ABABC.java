package semaphores;

import java.util.concurrent.Semaphore;

public class ABABC {
	
	private static Semaphore semA = new Semaphore(1);
	private static Semaphore semB = new Semaphore(0);
	private static Semaphore semC = new Semaphore(0);
	private static Semaphore mutex = new Semaphore(1);
	private static int countB = 0;
	
	public static void main(String args[]) throws Exception{
		while(true) {
			Thread a = new A();
			Thread b = new B();
			Thread c = new C();
			a.start();
			b.start();
			c.start();
			Thread.sleep(1000);
		}// while
	}// main
		

	
private static class A extends Thread {
	public void run() {
		try {
			semA.acquire();
			mutex.acquire();
		} catch (InterruptedException e) {e.printStackTrace();}
		
		System.out.print("A ");
		
		semB.release();
		
		mutex.release();
	}
}

private static class B extends Thread {
	public void run() {
	
	//Statement before printing
	
	try {
		//semB takes the token
		semB.acquire();
	} catch ( InterruptedException e) {e.printStackTrace();}
	
	System.out.print("B ");
	
	countB++;
	if(countB == 2) {
		countB = 0;
		semC.release();
		mutex.release();
	} else {
		semA.release();
		mutex.release();
	}
	
	
	}
}

private static class C extends Thread {
	public void run() {
	
	//Statement before printing
	
	try {
		//semB takes the token
		semC.acquire();
	} catch ( InterruptedException e) {e.printStackTrace();}
	
	System.out.print("C ");
	
	mutex.release();
	semA.release();
	}
}



}
