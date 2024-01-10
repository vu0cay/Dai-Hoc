package lab1;
import java.util.Scanner;
public class Bai_7_Name {
	public static String splitName(String name)
	{
		String lastName = name.substring(name.lastIndexOf(" "));
		
		return lastName;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ho va ten: ");
		String name = sc.nextLine();
		name = name.trim();
		System.out.println("ho va ten day du = "+name);
		System.out.println("Ten = "+ splitName(name));
		sc.close();
	}
}
