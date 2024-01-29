package MyFraction;

import java.awt.geom.Arc2D.Float;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
		Fraction a = new Fraction(3,7);
		Fraction b = new Fraction(4,9);
		a.show();
		b.show();
		
		Fraction x = new Fraction();
		x.input();
		Fraction y = new Fraction();
		y.input();
		System.out.println("Gia tri nghich dao ps X: ");
		x.reverseValue().show();
		System.out.println("Tong X + Y: ");
		x.add(y).show();
		// dsach n phan so
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Fraction sum = new Fraction();
		Fraction arr[] = new Fraction[n];
		for(int i = 0; i<n; i++)
		{
			arr[i] = new Fraction();
			arr[i].input();
			if(i == 0)
				sum = arr[0].mul(1);
			else
				sum = sum.add(arr[i]);
		}
		System.out.println("tong n pso = ");
		sum.show();
		// phan so lon nhat max
		Fraction max = arr[0];
		for(int i = 1; i<n; i++)
		{
			if(arr[i].greater(max))
				max = arr[i];
		}
		max.show();
		for(int i = 0; i<n-1; i++)
		{
			for(int j = i+1; j<n; j++)
			{
				if(arr[i].greater(arr[j]))
				{
					Fraction tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
		for(var e : arr)
		{
			System.out.print("voi gia tri "+e.fracValue()+ ":");
			e.show();
		}
		
	}
}