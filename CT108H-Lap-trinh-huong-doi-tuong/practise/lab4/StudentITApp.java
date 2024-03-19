package lab4;

import java.util.Scanner;

public class StudentITApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of students: ");
		int n = sc.nextInt();
		StudentIT list[] = new StudentIT[n];
		
		for(int i = 0; i<n; i++) {
			list[i] = new StudentIT();
			list[i].input();
		}
		sc.nextLine();
		System.out.println("Enter email name of student:\n");
		String e = sc.nextLine();
		
		boolean check = false;
		for(var s : list) {
			if(s.getMail().equalsIgnoreCase(e)) {
				System.out.println("Student info: " );
				s.showMark();
				System.out.println("averange mark: "+s.avgMark());
				System.out.println("\n mail: "+s.getMail());
				check = true;
				break;
			}
		}
		if(check == false) 
				System.out.println("Not found!");
//		System.out.println("List of students:\n");
//		
//		// in danh sach
//		int count = 0;
//		for(var e : list) {
//			System.out.println("sinh vien "+count+"\n"+ e);
//			count++;
//		}
	}
}
