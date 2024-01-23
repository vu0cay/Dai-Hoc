package MyData;
import java.util.Scanner;
public class Date {
	private int day;
	private int month;
	private int year;
	
	// ham xay dung
	public Date()		
	{
		day = 1;
		month = 1;
		year = 2024;
	}
	// tai dinh nghia ham xay dung
	public Date(int day, int month, int year)
	{
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public void show()
	{
		System.out.println(day+"/"+month+"/"+year);
	}
	
	public void input()
	{
		Scanner sc = new Scanner(System.in);
		do
		{
			day = sc.nextInt();
			month = sc.nextInt();
			year = sc.nextInt();
		}while(!valid());
	}
	public boolean valid()
	{
		boolean check = false;
		int max[] = {0, 31 ,28 , 31 , 30 , 31,
					30, 31, 31, 30, 31, 30, 31};
		if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0) max[2] = 29;
		if(day > 0 && month > 0 && year > 0 && month < 13 && day < max[month])
		check = true;
		
		return check;
	}
	
	
	public Date add()
	{
		Date c = new Date(day, month, year);
		c.day++;
		if(!valid())
		{
			c.day = 1;
			c.month++;
			if(!valid())
			{
				c.month = 1;
				c.year++;
			}
		}
		return c;
	}
	public Date add(int n)
	{
		Date c = new Date(day, month, year);
		for(int i = 0; i<n; i++)
		{
			c = c.add();
		}
		return c;
	}

	
	
}
