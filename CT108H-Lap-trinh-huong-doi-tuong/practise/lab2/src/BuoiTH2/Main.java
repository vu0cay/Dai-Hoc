package BuoiTH2;

public class Main {
	public static void main(String[] args) {
		Point a = new Point(3,4);
		System.out.print("the Pointing of a: "); a.show();
		Point b = new Point();
		b.inPut();
		System.out.print("the Pointing of b: "); b.show();
		
		Point c = new Point(-b.getx(), -b.gety());
		System.out.print("the Pointing of c: "); c.show();
		System.out.println("the dist between b and O is: "+b.distance());
		System.out.println("the dist between a and b is: "+a.distance(b));
		
	}
}
