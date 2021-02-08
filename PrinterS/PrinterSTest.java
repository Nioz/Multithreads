package PrinterS;
//Printer Sequential, goes w/ PrinterS
public class PrinterSTest 
{
	public static void main(String args[])
	{
		PrinterS s1 = new PrinterS(1,10);
		PrinterS s2 = new PrinterS(11,20);
		s1.print();
		s2.print();
		System.out.println("END");
	}

}
