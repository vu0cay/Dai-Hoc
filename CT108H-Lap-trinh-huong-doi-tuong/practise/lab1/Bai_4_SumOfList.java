package lab1;

import java.util.Scanner;

public class Bai_4_SumOfList {
	public static Scanner sc = new Scanner(System.in);
	public static int inPut()
	{
		
		System.out.println("Enter number: ");
		int n = 0;
		
		do
		{
			try {
				n = Integer.parseInt(sc.nextLine().trim());
			}
			catch(Exception e)
			{
				System.out.println("try again");
				n = Integer.MAX_VALUE;
			}
		} while (n == Integer.MAX_VALUE);
		return n;
	}
	
	public static void main(String[] args) {
		
		int a = inPut();
		int b = inPut();
		
		System.out.println(a+" + "+b+" = " + (a+b));
		
		sc.close();
	}
}
