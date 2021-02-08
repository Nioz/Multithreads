package PrinterS;
//Printer Sequential. goes with PrinterSTest
public class PrinterS 
{
	private int from;
	private int to;
	
	public PrinterS(int from, int to)
	{
		this.from = from;
		this.to = to;
	}
	
	public void print() 
	{
		for (int i = from; i <= to; i++)
			System.out.println(i + " ");
		
	System.out.println();
	}

}
