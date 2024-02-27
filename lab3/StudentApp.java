package lab3;

import java.util.Scanner;

public class StudentApp {
	public static void main(String[] args) {
//		Student a = new Student();
//		System.out.println("Enter information of: ");
//		a.input();
//		a.add("LTHDT", "0.0");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Student list[] = new Student[n];
		
		for(int i = 0; i<n; i++) {
			list[i] = new Student();
			System.out.println("Enter information of " +(i+1)+": ");
			list[i].input();
		}
		
		// tim cac sinh vien bi canh bao hoc vu
		
		for(var e : list)
		{
			if(e.avg() <= 1.0) {
				System.out.println(e );
			}
		}
		// tim cac sinh vien co diem trung binh cao nhat
		float max = -1;
		Student veledictorian = new Student();
		for(int i = 0; i<n; i++)
		{
			if(list[i].avg() > max) {
				max = list[i].avg();
				veledictorian = new Student(list[i]);
			}
		}
		System.out.println("Student have the highest averange mark: "+ veledictorian);
		
		// hien thi danh sasch sinh vien theo thu tu alphabet
		
		for(int i = 0; i<n-1; i++)
		{
			for(int j = i+1; j<n; j++) {
				String list_i = list[i].getLastName();
				String list_j = list[j].getLastName();
				if(list_i.compareTo(list_j) > 0 )
				{
					Student tmp = list[i];
					list[i] = list[j];
					list[j] = tmp;
				}
			}
		}
		
		

		
	}
}
