package lab1;

import java.util.Scanner;

public class Bai_8_SapXepDanhSach {
	public static int[] arr;
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
	public static int countX(int x)
	{
		
		int count = 0;
		for(var e : arr)
		{
			if(e == x) count++; 
		}
		return count;
	}
	public static void Sort()
	{
		for(int i = 0; i<arr.length - 1; i++)
		{
			for(int j = i + 1; j<arr.length; j++)
			{
				if(arr[i] > arr[j])
				{
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
	}
	public static void main(String[] args) {
		
		System.out.println("nhap so luong phan tu = ");
		int leng = inPut();
		arr = new int[leng];
		
		
		for(int i = 0; i<leng; i++)
		{
			System.out.print("nhap phan tu thu "+ (i+1)+" = ");
			arr[i] = inPut();
		}
		outPut();
		//******************
		System.out.print("Nhap so nguyen x = ");
		int x = inPut();
		System.out.println("trong danh sach co "+countX(x)+" so "+x);
		//******************
		Sort();
		outPut();
		sc.close();
	}
}
