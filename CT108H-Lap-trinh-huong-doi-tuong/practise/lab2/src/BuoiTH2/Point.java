package BuoiTH2;
import java.util.Scanner;
public class Point {
	private int x;
	private int y;
	
	public Point() {}
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
		
	}
	
	
	public void inPut() {
		Scanner sc = new Scanner(System.in);
		x = Integer.parseInt(sc.nextLine());
		y = Integer.parseInt(sc.nextLine());
		
		sc.close();
	}
	public void show()
	{
		System.out.println("("+x+","+y+")");
	}
	public void move(int dx, int dy)
	{
		x += dx;
		y += dy;
	}
	// getter & setter
	public int getx()
	{
		return x;
	}
	public int gety()
	{
		return y;
	}
	// khoang cach tu 1 diem den goc toa do O(0,0)
	public float distance()
	{
		return (float)Math.sqrt(
				Math.pow(x, 2) + Math.pow(y, 2)
		);
	}
	// khoang cach tu 1 diem den diem b
	public float distance(Point b)
	{
		return (float)Math.sqrt(
				Math.pow(b.x - x, 2) + Math.pow(b.y - y, 2)
		);
	}	
	
	
}
