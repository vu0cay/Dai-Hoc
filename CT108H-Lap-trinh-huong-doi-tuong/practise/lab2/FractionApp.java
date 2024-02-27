package lab2;

import java.util.Scanner;

public class FractionApp {
	public static void Add(Fraction ds[], int n)
	{
		Fraction sumAll = new Fraction();
		for(int i = 0; i<n; i++)
		{
			ds[i] = new Fraction();
			ds[i].input();
			if(i == 0)
			{
				sumAll = ds[i];
			} else sumAll = sumAll.add(ds[i]);
		}
		sumAll.show();
		
	}
	public static void findMax(Fraction ds[], int n)
	{
		Fraction max = ds[0];
		for(int i = 1; i<n; i++)
		{
			if(ds[i].greater(max)) max = ds[i];
		}
		System.out.println("phan so lon nhat la:" );
		max.show();
	}
	public static void Sort(Fraction ds[], int n)
	{
		for(int i = 0; i<n; i++)
		{
			for(int j = i+1; j<n; j++)
			{
				if(ds[i].greater(ds[j]))
				{
					Fraction tmp = ds[i];
					ds[i] = ds[j];
					ds[j] = tmp;
				}
			}
		}
	}
	public static void main(String[] args) {
		
		// tao phan so a = 3/7, b = 4/9 hien thi ra man hinh
		Fraction a = new Fraction(3,7);
		Fraction b = new Fraction(4,9);
		System.out.println("phan so vua nhap la: ");
		a.show();
		b.show();
		// tao 2 phan so x,y. Nhap gia tri cho x va y
		Fraction x = new Fraction();
		Fraction y = new Fraction();
		x.input();
		y.input();
		System.out.println("gia tri 2 phan so x,y: ");
		x.show();
		y.show();
		// hien thi gia tri nghich dao phan so x (ko thay doi gia tri)
		System.out.print("phan so nghich dao cua: "); x.show();
		x.getRev().show();
		// tinh tong cua x + y
		System.out.print("tong cua x + y: ");
		
		Fraction sum = x.add(y);
		sum.show();
		// nhap vao 1 danh sach gom n phan so
		// tinh tong n phan so do
		// tim phan so lon nhat
		// sap xep theo thu tu tang dan
		System.out.println("nhap n= ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Fraction ds[] = new Fraction[n];
		Add(ds, n);		//tinh tong
		findMax(ds, n); // tim max
		System.out.println("Phan so ban dau: ");
		for(var e : ds)
		{
			System.out.print("gia tri: "+e.getVal()+" la: ");
			e.show();
		}
		System.out.println("Phan so sau khi sap xep: ");
		Sort(ds, n);  	// sap xep
		for(var e : ds)
		{
			System.out.print("gia tri: "+e.getVal()+" la: ");
			
			e.show();
		}
		
		
		
	}
}
