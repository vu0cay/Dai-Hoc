package lab2;

import java.util.Scanner;

public class TilesApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter positive integer: ");
		int n = sc.nextInt();
		Tiles list[] = new Tiles[n];
		System.out.println("Enter element of list: ");
		for(int i = 0; i<n; i++)
		{
			list[i] = new Tiles();
			list[i].input();
		}
		
		
		for(var e : list)
		{
			System.out.println(e);
		}
		
		double min = Double.MAX_VALUE;
		Tiles Min_Tiles = new Tiles();
		for(int i = 0; i<n; i++)
		{
			double tmp = (double)list[i].getCost()/list[i].maxArea();
			if(tmp < min) {
				min = tmp;
				Min_Tiles = new Tiles(list[i]);
			}
		}
		System.out.println(Min_Tiles);
		
		for(int i = 0; i<n; i++)
		{
			double boxNeed = list[i].quanOfBox(500, 2000);
			double tiles_redundant = (double)(1000000) % list[i].maxArea();
			
			System.out.println("Cost of tiles id: " +list[i].getId()
					+ "= " + boxNeed*list[i].getCost() + (double)tiles_redundant*list[i].getCost()/list[i].maxArea());
			
		}
		
		
	}
}
