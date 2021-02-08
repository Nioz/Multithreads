package atomicvariables;

public class AtomicColThread extends Thread {
	private int m;
	private int dim;
	private int row[];
	private int inc[];
	
	public AtomicColThread(int m, int dim, int[] row, int[] inc) {
		this.m = m;
		this.dim = dim;
		this.row = row;
		this.inc = inc;
	}
	
	public void run() {
		for(int i = 0; i < dim; i++) {
			inc[i] += 1;
		}
	}

}
