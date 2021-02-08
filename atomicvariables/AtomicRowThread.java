package atomicvariables;

public class AtomicRowThread extends Thread {
	private int n;
	private int dim;
	private int row[];
	private int dec[];
	
	public AtomicRowThread(int n, int dim, int[] row, int[] dec) {
		this.n = n;
		this.dim = dim;
		this.row = row;
		this.dec = dec;
	}
	
	public void run() {
		for(int i = 0; i < n; i++) {
			dec[i] -= 1;
		}
	}

}
