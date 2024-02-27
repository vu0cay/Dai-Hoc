package lab2;

import java.util.Scanner;

public class DateApp {
	public static void main(String[] args) {
		// nhap ngay A va in ngay A
		Date A = new Date(30,1,2024);
		A.show();
		// Nhap ngay B in ngay B
		Date B = new Date();
		B.input();
		B.show();
		// Tinh ngay tiep theo cua B
		System.out.print("the next day of B ");
		Date C = B.tomorrow();
		C.show();
		
		// Nhap ngay D in ra ngay khi D cong them n ngay 
		Date D = new Date();
		D.input();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter #n day add: ");
		int n = sc.nextInt();
		
		System.out.print("init day: ");
		D.show();
		Date E = D.addDay(n);
		System.out.print("after add D with #n: "); 
		E.show();
	}
}
