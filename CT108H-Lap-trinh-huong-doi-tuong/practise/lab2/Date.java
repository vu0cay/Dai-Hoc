package lab2;

import java.util.Scanner;

public class Date {
	// thuoc tinh ngay, thang, nam
	private int d;
	private int m;
	private int y;
	// constructor
	public Date() {}
	public Date(int day, int month, int year)
	{
		d = day;
		m = month;
		y = year;
	}
	// methods
	public void show()
	{
		System.out.println(d+"/"+m+"/"+y);
	}
	public void input()
	{
		Scanner sc = new Scanner(System.in);
		
		do
		{
			System.out.println("Enter day, month, year: ");
			d = sc.nextInt();
			m = sc.nextInt();
			y = sc.nextInt();
			
		} while (!valid());
	}
	// ham kiem tra xem ngay co hop le khong
	public boolean valid()
	{
		int dayOfMonth[] = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		dayOfMonth[2] = (y % 4 == 0 && y % 100 != 0) || ( y% 400 == 0) ? 29 : 28;
		boolean check = false;
		if(d > 0 && d <= dayOfMonth[m]
			&& m > 0 && m < 13
			&& y > 0)
		{
			check = true;
		}	
		return check;
	}
	// ham tinh ra ngay hom sau
	public Date tomorrow()
	{
		d = d + 1;
		if(!valid())
		{
			d = 1;
			m = m + 1;
			if(!valid())
			{
				m = 1;
				y = y + 1;
			}
		}
		return new Date(d,m,y); 
	}
	// ham cong 1 ngay voi so n nao do
	public Date addDay(int n)
	{
		for(int i = 1; i<=n; i++)
		{
			d = d + 1;
			if(!valid())
			{
				d = 1;
				m = m + 1;
				if(!valid())
				{
					m = 1;
					y = y + 1;
				}
			}
		}	
		return new Date(d,m,y);
	}
	
	
}
