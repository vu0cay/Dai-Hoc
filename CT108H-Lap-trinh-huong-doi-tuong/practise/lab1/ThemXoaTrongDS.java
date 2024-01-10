package lab1;

import java.util.ArrayList;
import java.util.Scanner;

public class ThemXoaTrongDS {
	public static ArrayList<Integer> arr = new ArrayList<Integer>();
	public static Scanner sc = new Scanner(System.in);
	public static int inPut()
	{
		int n = 0;
		do
		{
			try {
				n = Integer.parseInt(sc.nextLine());
			}
			catch(Exception e)
			{
				System.out.println("gia tri phai la so nguyen");
				n = Integer.MAX_VALUE;
			}
		} while (n == Integer.MAX_VALUE);
		
		return n;
	}
	public static void outPut()
	{
		System.out.println("Danh sach = ");
		for(var e : arr)
		{
			System.out.print(e+" ");
		}
		System.out.println();
	}
	// 1 2 3 4
	// 1 2 3 4
	// 0 1 2 3 
	public static void inSert(int pos, int val)
	{
		arr.add(pos - 1, val);
	}
	public static void deLete(int pos)
	{
		arr.remove(pos - 1);
	}
	public static void main(String[] args) {
		System.out.println("nhap so luong phan tu = ");
		int leng = inPut();
		
		
		for(int i = 0; i<leng; i++)
		{
			System.out.print("nhap phan tu thu "+ (i+1)+" = ");
			arr.add(inPut());
		}
		outPut();
		System.out.println("Nhap phan tu va vi tri can them");
		int val = inPut();
		int pos = inPut();
		System.out.println("danh sach sau khi them "+val+" tai "+pos);
		inSert(pos, val);
		outPut();
		
		System.out.println("Nhap vi tri ptu can xoa =");
		int pos2 = inPut();
		deLete(pos2);
		outPut();
	}
}
