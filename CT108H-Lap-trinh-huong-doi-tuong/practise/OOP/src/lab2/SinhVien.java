package lab2;

import java.util.Scanner;

public class SinhVien {
	private String id;
	private String name;
	private Date birth_date;
	private int num_course;
	
	private String course_name[];
	private String course_score[];
	
	public SinhVien()
	{
		
	}
	public SinhVien(String id, String name, Date birth_date, int num_course, 
					String course_name[], String course_score[])
	{
		this.id = id;
		this.name = name;
		this.birth_date = birth_date;
		this.num_course = num_course;
		this.course_name = course_name;
		this.course_score = course_score;
	}
	public SinhVien(SinhVien a)
	{
		id = a.id;
		name = a.name;
		birth_date = a.birth_date;
		num_course = a.num_course;
		course_name = a.course_name;
		course_score = a.course_score;
	}
	
	
	//input methods
	public void input()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter ID Students: ");
		id = sc.nextLine();
		System.out.println("Enter Students name: ");
		name = sc.nextLine();
		System.out.println("Enter Students birth: ");
		birth_date.input();
		System.out.println("Enter the number of course be enrollment: ");
		num_course = sc.nextInt();
		
		for(int i = 0; i<num_course; i++)
		{
			System.out.println("Enter course name "+i+": ");
			course_name[i] = sc.nextLine();
		}
	}
	public void input(String course[], int n)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the score of each course: ");
		for(int i = 0; i<n; i++)
		{
			System.out.println("Enter the "+course[i]+" scores: ");
			course_score[i] = sc.nextLine();
		}
	}
	// average of students point on a 4-point scale
	public float average()
	{
		float sum = 0;
		for(var p : course_score)
		{
			sum += (p == "A") ? 4.0 : (p == "B+") ? 3.5 : (p == "B") ? 3.0 :
					(p == "C+") ? 2.5 : (p == "C") ? 2.0 : (p == "D+") ? 1.5 :
						(p == "D") ? 1.0 : 0.0;
		};
		return (float)sum/num_course;
	}
	// enroll course
	public void enroll(String course)
	{
		course_name[num_course] = course;
		course_score[num_course] = "null";
		num_course += 1;
	}
	// withdraw the course
	public void unenroll(String course)
	{
		int i = 0;
		for(; i<num_course;i++)
		{
			if(course_name[i].equals(course)) 
			{
				break;
			}
		}
		
		if(i == num_course) System.out.println("Couldn't find the course of students");
		else 
		{
			for(int k = i; k<num_course-1; k++)
			{
				course_name[k] = course_name[k+1];
				course_score[k] = course_score[k+1];
				
			}
			num_course--;
		}
	}
	
	
	
	// override tosString methods
	public String toString(){
		return 	"Student id: "+id+"\t\tName: "+name+"\t\tbirth: "+birth_date;
	}
	public void show()
	{
		System.out.println("Student id: "+id+"\t\tName: "+name+"\t\tbirth: "+birth_date);
	}
	public void show(String msg)
	{
		System.out.println(msg + "Student id: "+id+"\t\tName: "+name+"\t\tbirth: "+birth_date);
	}
	
}
