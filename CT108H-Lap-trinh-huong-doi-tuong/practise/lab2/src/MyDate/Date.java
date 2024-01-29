package MyDate;

import java.util.Scanner;

public class Date
{
	// attribute
	private int d;
	private int m;
	private int y;
	// constructor
	public Date() {
		d = 1;
		m = 1;
		y = 1;
	}
	public Date(int day, int month, int year) {
		d = day;
		m = month;
		y = year;
	}
	// method
	//
	// showing the information 
	public void show()
	{
		System.out.println(d+"/"+m+"/"+y);
	}
	// input the d,m,y if it doesn't right type again
	public void input()	
	{
		Scanner sc = new Scanner(System.in);
		do
		{
			System.out.println("Enter d,m,y = ");
			d = Integer.parseInt(sc.nextLine());
			m = Integer.parseInt(sc.nextLine());
			y = Integer.parseInt(sc.nextLine());
		} while (!valid());
		
		//sc.close();
	} 
	// check if the components is right or not
	private boolean valid() 
	{
		int numofday[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		numofday[2] = (y % 4 == 0) && (y%100 != 0)
						|| (y%400 == 0) ? 29 : 28;
		boolean check = false;
		if( m > 0 && m < 13 && d > 0)
		{
			if(d <= numofday[m]) check = true;
		}
		return check;		
	}
	// print the next day
	public Date tomorrow()
	{
		d = d + 1;
		if(!valid())
		{
			d = 1;
			m++;
			if(!valid())
			{
				m = 1;
				y++;
			}
		}
		return new Date(d, m, y);
	}
	// sum day with a number n
	public Date sumday(int n)
	{
		for(int i = 1; i<=n; i++)
		{
			d = d + 1;
			if(!valid())
			{
				d = 1;
				m++;
				if(!valid())
				{
					m = 1;
					y++;
				}
			}
		}
		return new Date(d,m,y);
	}
}