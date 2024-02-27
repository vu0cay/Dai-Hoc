package lab3;

import java.util.Scanner;

public class Brick {
	private String id;
	private String color;
	private int quantity, height, width;
	private long price;
	
	// constructor 
	public Brick() {
		id = new String();
		color = new String();
		quantity = 0;
		height = 0;
		width = 0;
		price = 0;
	}
	public Brick(Brick A) {
		id = new String(A.id);		
		color = new String(A.color);
		quantity = A.quantity;
		height = A.height;
		width = A.width;
		price = A.price;
	}
	// input methods
	public void input()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id: "); id = sc.nextLine();
		System.out.println("Enter color: "); color = sc.nextLine();
		System.out.println("Enter height: "); height = sc.nextInt();
		System.out.println("Enter width: "); width = sc.nextInt();
		System.out.println("Enter price: "); price = sc.nextLong();
		
	}
	// show methods
	public void show() {
		System.out.println("id: "+ id +" color: "+color+" height: "+ height+
							" width: "+ width+" price: "+price);
	}
	public void show(String msg) {
		System.out.println(msg + "id: "+ id +" color: "+color+" height: "+ height+
				" width: "+ width+" price: "+price);
	}
	public String toString() {
		return "id: "+ id +" color: "+color+" height: "+ height+
							" width: "+ width+" price: "+price;
	}
	// retail price
	public float retail_price() {
		// price of one brick = total cost / number of brick 
		// result = price of one brick + (price of one brick)*20/100
		return 1.2f*(float)(price/quantity);
	}
	// the maximum of area that a box can cover
	
	// number of box
	public  int boxs(int D, int N) {
		int svd = (D%height == 0) ? D/height : (D/height) + 1;
		int svn = (N%width == 0) ? N/width : (N/width) + 1;
		
		int sh = (svd*svn)/quantity;
		if((svd*svn)%quantity != 0) return sh+1;
		else return sh;
	}
	

}
