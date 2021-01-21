package scalarProduct;

public class Ex17_1 {

	public static void main(String[] args) throws InterruptedException {
		int n = 6;
		int [] a = {1,2,3,4,5,6};
		int [] b = {1,2,3,4,5,6};
		int result;
		ScalarProductThread t1 = new ScalarProductThread("T1", a, b, 0, n/2 - 1);
		ScalarProductThread t2 = new ScalarProductThread("T2", a, b, n/2, n - 1);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		
		result = t1.getResult() + t2.getResult();
		System.out.println(result);

		

	}

}
