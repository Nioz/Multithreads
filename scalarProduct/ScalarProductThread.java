package scalarProduct;

public class ScalarProductThread extends Thread {
	private int begin, end, ris;
	int [] v1, v2;
	
	public ScalarProductThread(String name, int [] v1, int [] v2, int begin, int end) {
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
