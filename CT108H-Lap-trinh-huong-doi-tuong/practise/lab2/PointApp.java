package lab2;

public class PointApp {
	public static void main(String[] args) {
		Point A = new Point(3,4);
		System.out.print("Diem A = "); A.show();
		Point B = new Point();
		B.input();
		System.out.print("Diem B = "); B.show();
		// diem C doi xung B qua goc toa do
		Point C = new Point(-B.getX(), - B.getY());
		// khoang cach tu B den tam O
		System.out.println("khoang cach tu B den O: "+ B.distance());
		// khoang cach tu diem A den diem B
		System.out.println("khoang cach tu A den B: "+ A.distance(B));
		
	}
}
