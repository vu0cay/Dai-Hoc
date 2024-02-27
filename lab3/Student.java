package lab3;

import java.util.Scanner;

public class Student {
	private String id,name;
	private Date bd;
	private int n;
	private String []course,mark;
	public Student(){}
	public Student(Student s){
		id = new String(s.id);
		name = new String(s.id);
		bd = new Date(s.bd);
		n = s.n;
		course = new String[50];
		mark = new String[50];
		
		for(int i = 0; i<n; i++) {
			course[i] = new String(s.course[i]);
			mark[i] = new String(s.mark[i]);
		}	
	}
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id: "); id = sc.nextLine();
		System.out.println("Enter name: "); name = sc.nextLine();
		System.out.println("Enter birthday: "); bd.input();
	}
	public void inputMark()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter #students: "); n = sc.nextInt();
		// xoa vung dem xoa ky tu xuong dong
		sc.nextLine();
		for(int i = 0; i<n; i++)
		{
				System.out.println("Enter course " + (i+1) +": ");
				course[i]= sc.nextLine();
				System.out.println("Enter mark " + (i+1) +": ");
				mark[i] = sc.nextLine();
		}
	}
	public void show() {
		System.out.println("[" + id + "," +name+","+bd);
		for(int i = 0; i<n; i++) {
			System.out.println(","+course[i]+": "+mark[i]);
		}
		System.out.println("]");
	}
	public String toString() {
		String s = "[" + id + "," +name+","+bd;
		for(int i = 0; i<n; i++) {
			s += ","+course[i]+": "+mark[i];
		}
		s += "]";
		return s;
	}
	
	public float avg() {
		float f = 0.0f;
		for(int i = 0; i<n; i++)
		{
			f += course[i].equals("A") ? 4.0 : course[i].equals("B+") ? 3.5 :
				course[i].equals("B") ? 3.0 : course[i].equals("C+") ? 2.5 :
					course[i].equals("C") ? 2.0 :course[i].equals("D+") ? 1.5 :
							course[i].equals("D") ? 1.0 : 0.0;
		}
		return f/n;
	}
	
	public void add(String c, String m) {
		if(n < 50) {
			course[n] = new String(c);
			mark[n] = new String(m);
			n++;
		} else System.out.println("List is full!");
	}
	public void del(String c) {
		int i = 0;
		for( ; i < n; i++)
				if(course[i].equals(c)) break;
		if( i<n )
		{
			for(int k = i; k<n-1; k++) {
				course[k] = course[k+1];
				mark[k] = mark[k+1];
			}
			n--;
		} else System.out.println("Couldn't found "+c);
	}
	// getter && setter
	// get last name 
	public String getLastName() {
		name = name.trim();
		return name.substring(name.lastIndexOf(" ") + 1);
	}
	public String getID() { return id;}
	public String getName() { return name;}
	public Date getBD() { return bd;}
	
	
	//5 ham co ban
	// ham xay dung
	// ham xay dung sao chep
	// ham nhap
	// ham in
	// ham toString
}
