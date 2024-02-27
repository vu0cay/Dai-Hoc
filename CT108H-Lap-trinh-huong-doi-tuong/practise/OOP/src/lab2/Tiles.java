package lab2;

import java.util.Scanner;

public class Tiles {
	private String id;
	private String color;
	private int quantity;
	private int height;	// chieu cao (cm)
	private int width;	// chieu rong (cm)
	private long cost;
	
	// methods
	// constructor
	
	public Tiles() {
		id = "null";
		color = "null";
		quantity = 0;
		height = 0;
		width = 0;
		cost = 0;
	}
	public Tiles(String id, String color, int quantity, 
				int height, int width, int cost) {
		this.id = id;
		this.color = color;
		this.quantity = quantity;
		this.height = height;
		this.width = width;
		this.cost = cost;
	}
	// constructor copy
	public Tiles(Tiles a) {
		id = a.id;
		color = a.color;
		quantity = a.quantity;
		height = a.height;
		width = a.width;
		cost = a.cost;
	}
	// methods for input the information of a tiles box.
	public void input()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the tiles box id: ");
		id = sc.nextLine();
		System.out.println("Enter the tiles box color: ");
		color = sc.nextLine();
		System.out.println("Enter the tiles box quantity: ");
		quantity = sc.nextInt();
		System.out.println("Enter the tiles box height: ");
		height = sc.nextInt();
		System.out.println("Enter the tiles box width: ");
		width = sc.nextInt();
		System.out.println("Enter the tiles box cost: ");
		cost = sc.nextInt();
	}
	// getter & setter
	public long getCost()
	{
		return cost;
	}
	public String getId()
	{
		return id;
	}
	// cost of one tiles 
	public float retail()
	{
		return (float)(cost/quantity) + (float)(cost/quantity)*(float)20/100;
	}
	// maximum areas that the box can offer
	public int maxArea()
	{
		
		//max Area = S*quantity
		return quantity*height*width;
	}
	//
	public int quanOfBox(int D, int N)
	{
		
		int area = D*N;
		int boxArea = maxArea();
		int tmp = boxArea;
		int count = 1;
		while(boxArea <= area)
		{
			boxArea += tmp;
			count++;
		}
		return count;
	}
	
	// show info methods
	public void show()
	{
		System.out.println( 
				"id: " + id +
				"\ncolor: " + color +
				"\nquantity of tiles in a box: " + quantity +
				"\nheight: " + height +
				"\nwidth: "+ width + 
				"\ncost: " + cost
				);
	}
	public void show(String msg)
	{
		System.out.println( 
				msg + "\nid: " + id +
				"\ncolor: " + color +
				"\nquantity of tiles in a box: " + quantity +
				"\nheight: " + height +
				"\nwidth: "+ width + 
				"\ncost: " + cost
				);
	}
	
	// override toString() methods of Object java 
	public String toString()
	{
		return "Box info:" + 
				"\nid: " + id +
				"\ncolor: " + color +
				"\nquantity of tiles in a box: " + quantity +
				"\nheight: " + height +
				"\nwidth: "+ width + 
				"\ncost: " + cost;
	}
	
}
