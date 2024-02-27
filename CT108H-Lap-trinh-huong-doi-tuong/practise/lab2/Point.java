package lab2;

import java.util.Scanner;

public class Point {
	private int x;
	private int y;
	
	// constructor 
	public Point() {}
	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	// methods
	// xay dung toa do cho diem tu ban phim
	public void input()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter x,y: ");
		x = sc.nextInt();
		y = sc.nextInt();
	}
	// hien thi ra man hinh toa do theo dang (x,y)
	public void show()
	{
		System.out.println("("+ x +","+ y +")");
	}
	// doi diem di 1 do doi (dx, dy)
	public void move(int dx, int dy)
	{
		x += dx;
		y += dy;
	}
	// lay ra gia tri hoanh do cua diem
	public int getX()
	{
		return x;
	}
	// lay ra gia tri tung do cua diem
	public int getY()
	{
		return y;
	}
	// tinh khoang cach tu diem do den goc toa do
	public float distance()
	{
		return (float)Math.sqrt(
				Math.pow(x, 2) + Math.pow(y, 2)
				);
	}
	// tinh khoang cach tu diem do den 1 diem khac
	public float distance(Point b)
	{
		return (float)Math.sqrt(
				Math.pow(b.getX() - x, 2) + Math.pow(b.getY() - y, 2)
				);
	}
	
	
	
}
