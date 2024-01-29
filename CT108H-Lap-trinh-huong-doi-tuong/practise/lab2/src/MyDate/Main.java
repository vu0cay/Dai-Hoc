package MyDate;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		//*******************************************************
		Date today = new Date();
		today.input();
		today.show();
		//*******************************************************
		System.out.println("ngay mai la: ");
		Date tomorrow = today.tomorrow();
		tomorrow.show();
		//*******************************************************
		//set to day
		
		today = new Date(28,1,2024);
		System.out.println("nhap so ngay tiep theo: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println("ngay cong them n la: ");
		Date ndaynext = today.sumday(n);
		ndaynext.show();
	}
}
