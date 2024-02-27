package lab2;

import java.util.Scanner;

public class Fraction {
	// attributes
	private int numerator;
	private int denominator;
	
	// constructors
	public Fraction() {}
	public Fraction(int num, int deno)
	{
		numerator = num;
		denominator = deno;
	}
	
	// methods
	// nhap gia tri cho 1 phan so. Neu mau = 0 nhap lai
	public void input()
	{
		Scanner sc = new Scanner(System.in);
		do
		{
			System.out.println("Enter number: ");
			numerator = sc.nextInt();
			denominator = sc.nextInt();
		} while(denominator == 0);	
	}
	// ham hien thi phan so theo dang tu/mau hoac -tu/mau
	// tim ucll
	private int ucll(int a, int b)
	{
		if(a == 0 || b % a == 0) return a;
		else return ucll(b%a, a);
	}
	public void show()
	{
		int sign_num = 0, sign_den = 0;
		if(denominator < 0 ) 
		{
			denominator	*= -1;
			sign_den = 1;
		}
		if( numerator < 0)
		{
			numerator *= -1;
			sign_num = 1;
		}
		
		int divisor = ucll(numerator, denominator);
		if(divisor != 1)
		{
			numerator /= divisor;
			denominator /= divisor;
		}		
		if(sign_den == 1 && sign_num != 1 || sign_den != 1 && sign_num == 1)
		{
			numerator *= -1;
		}
		
		if(denominator == 1) System.out.println(numerator);
		else
			System.out.println(numerator+"/"+denominator);
	}


	// ham nghich dao phan so
	public void reverse()
	{
		int tmp = numerator;
		numerator = denominator;
		denominator = tmp;
	}
	// ham tinh ra phan so nghich dao cua 1 phan so
	public Fraction getRev()
	{
		return new Fraction(denominator, numerator);
	}
	// ham tinh ra gia tri thuc cua phan so
	public float getVal()
	{
		return (float)numerator/denominator;
	}
	// ham so sanh lon hon voi phan so A
	public boolean greater(Fraction a)
	{
		return numerator*a.denominator > a.numerator*denominator;
	}
	// ham cong tru nhan chia phan so voi 1 phan so a. Ket qua cua ham la 1 phan so
	public Fraction add(Fraction a)
	{
		int tmp_n = numerator*a.denominator + a.numerator*denominator;
		int tmp_d = denominator*a.denominator;
		return new Fraction(tmp_n, tmp_d);
	}
	public Fraction sub(Fraction a)
	{
		int tmp_n = numerator*a.denominator - a.numerator*denominator;
		int tmp_d = denominator*a.denominator;
		return new Fraction(tmp_n, tmp_d);
	}
	public Fraction mul(Fraction a)
	{
		int tmp_n = numerator * a.numerator; 
		int tmp_d = denominator*a.denominator;
		return new Fraction(tmp_n, tmp_d);
	}
	public Fraction div(Fraction a)
	{
		return mul(a.getRev());
	}
	// ham cong tru nhan chia voi 1 so nguyen. Ket qua la 1 phan so
	public Fraction add(int a)
	{
		int tmp_n = numerator + a*denominator;
		int tmp_d = denominator;
		return new Fraction(tmp_n, tmp_d);
	}
	public Fraction sub(int a)
	{
		int tmp_n = numerator - a*denominator;
		int tmp_d = denominator;
		return new Fraction(tmp_n, tmp_d);
	}
	public Fraction mul(int a)
	{
		int tmp_n = numerator * a; 
		int tmp_d = denominator;
		return new Fraction(tmp_n, tmp_d);
	}
	public Fraction div(int a)
	{
		return mul(new Fraction(1,a));
	}
	
}
