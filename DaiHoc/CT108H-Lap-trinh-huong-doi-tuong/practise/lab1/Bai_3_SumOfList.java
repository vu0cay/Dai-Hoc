package lab1;

public class Bai_3_SumOfList {
	public static void main(String[] args) {
		
		double sum = 0, n, max = Double.MIN_VALUE;
		for(String e : args)
		{
			try {n = Double.parseDouble(e);}
			catch(Exception ex) { n = 0;}
			
			sum += n;
			max = n > max ? n : max;
		}
		
		System.out.println("Sum = " + sum + " max = "+max );
	}
}
