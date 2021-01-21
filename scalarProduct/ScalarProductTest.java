package scalarProduct;

public class ScalarProductTest {

	public static void main(String[] args) throws InterruptedException {
		int [] a = {1,2,3,4,5,6};
		int [] b = {1,2,3,4,5,6};
		int numOfThreads = 4;
		
		int s = (a.length / numOfThreads); // length of the subvectors assigned to each thread
		int n = a.length;
		
		ScalarProductThread threads [] = new ScalarProductThread[numOfThreads];
		
		int init = -1, end = -1;
		
		
		for(int i = 0; i < numOfThreads; i++) {
			if(i == 0) {
				init = 0;
				end = init + s - 1;
			}
			else if(i != 0 && i < numOfThreads - 1) {
				init = end + 1;
				end = init + s - 1;
			}
			else {
				init = end + 1;   //-1; //TO BE DONE: initialize "init", on the basis of "s" and "n"
				end = a.length - 1;
			}
			
			      //-1; //TO BE DONE: initialize "end", on the basis of "s" and "n"
			threads[i] = new ScalarProductThread("T" + i, a, b, init, end);
			threads[i].start();
		}
		
		//waiting for the completion of the threads
		for(int i = 0; i < numOfThreads; i++) {
			threads[i].join();
		}
		
		int result = 0;
		//computation for the final result
		for(int i = 0; i <numOfThreads; i++) {
			System.out.println("Result " + i + " = " + threads[i].getResult());
			result += threads[i].getResult();
		}
		
		System.out.println("Result = " + result);

	}

}
