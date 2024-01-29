package MyFraction;
import java.util.Scanner;

public class Fraction {
	private int numerator;
	private int denominator;
	
	public Fraction() {}
	public Fraction(int num, int deno)
	{
		numerator = num;
		denominator = deno;
	}
	
	
	// methods
	public void input()
	{
		Scanner sc = new Scanner(System.in);
		do
		{
			System.out.println("Enter a/b, b != 0: ");
			numerator = Integer.parseInt(sc.nextLine());
			denominator = Integer.parseInt(sc.nextLine());	
		} while(denominator == 0);
	}
	public void show()
	{
		System.out.print("Fraction: ");
		if(numerator == 0) System.out.println(0);
		else if(denominator == 1) System.err.println(numerator);
		else System.out.println(numerator+"/"+denominator);
	}
	public void reverse()
	{
		int tmp = numerator;
		numerator = denominator;
		denominator = tmp;
	}
	public Fraction reverseValue()
	{
		return new Fraction(denominator,numerator);
	}
	public float fracValue()
	{
		return (float)numerator/denominator;
	}
	public boolean greater(Fraction b)
	{
		return numerator*b.denominator > b.numerator*denominator;
	}
	// add, sub, mul, div with fraction
	public Fraction add(Fraction a)
	{
		int num = numerator*a.denominator + a.numerator*denominator;
		int den = denominator*a.denominator;
		return new Fraction(num,den);
	}
	public Fraction sub(Fraction a)
	{
		int num = numerator*a.denominator - a.numerator*denominator;
		int den = denominator*a.denominator;
		return new Fraction(num,den);
	}
	public Fraction mul(Fraction a)
	{
		return new Fraction(numerator*a.numerator,denominator*a.denominator);
	}
	public Fraction div(Fraction a)
	{		
		return mul(a.reverseValue());
	}
	// add, sub, mul, div with int a
	public Fraction add(int a)
	{
		int num = numerator + a*denominator;
		int den = denominator;
		return new Fraction(num,den);
	}
	public Fraction sub(int a)
	{
		int num = numerator - a*denominator;
		int den = denominator;
		return new Fraction(num,den);
	}
	public Fraction mul(int a)
	{
		return new Fraction(numerator*a,denominator);
	}
	public Fraction div(int a)
	{		
		return new Fraction(numerator,a*denominator);
	}
}
