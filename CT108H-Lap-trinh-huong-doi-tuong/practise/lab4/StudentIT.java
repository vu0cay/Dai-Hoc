package lab4;

import java.util.Scanner;

import lab3.Student;

public class StudentIT extends Student{
	String account;
	String password;
	String email;
	
	// methods
	public StudentIT() {
		super();
		account = new String();
		password = new String();
		email = new String();
	}
	public StudentIT(String acc, String pass, String mail ) {
		super();
		account = new String(acc);
		password = new String(pass);
		email = new String(mail);
	}	
	public StudentIT(StudentIT S) {
		super((Student)S);
		account = new String();
		password = new String();
		email = new String();
	}
	// input
	public void input() {
		Scanner sc = new Scanner(System.in);
		super.input();
		super.inputMark();
		System.out.println("Enter account's name: ");
		account = sc.nextLine();
		System.out.println("Enter account's password: ");
		password = sc.nextLine();
		System.out.println("Enter account's mail: ");
		email = sc.nextLine();
	}
	// override toString
	@Override
	public String toString() {
		return super.toString() + "\nacc: "+account+" email: "+email+"\n";
	}
	public void changePass(String newpass) {
		password = new String(newpass);
	}
	public String getMail() {
		return email;
	}
	
	
	
}
