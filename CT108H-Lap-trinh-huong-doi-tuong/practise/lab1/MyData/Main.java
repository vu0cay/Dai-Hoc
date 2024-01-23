package MyData;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		System.out.println("Enter date a");
		Date a = new Date(23,1,2024);
		a.show();
		System.out.println("Enter date b");
		Date b = new Date();
		b.input();
		b.show();
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		b = b.add(n);
		b.show();
		
	}
}
