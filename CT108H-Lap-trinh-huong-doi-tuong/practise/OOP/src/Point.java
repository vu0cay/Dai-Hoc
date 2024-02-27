package lab2;

import java.util.Scanner;

public class Point {
   private int x;
   private int y;

   public Point() {
   }

   public Point(int x, int y) {
      this.x = x;
      this.y = y;
   }

   public void input() {
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter x,y: ");
      this.x = sc.nextInt();
      this.y = sc.nextInt();
   }

   public void show() {
      System.out.println("(" + this.x + "," + this.y + ")");
   }

   public void move(int dx, int dy) {
      this.x += dx;
      this.y += dy;
   }

   public int getX() {
      return this.x;
   }

   public int getY() {
      return this.y;
   }

   public float distance() {
      return (float)Math.sqrt(Math.pow((double)this.x, 2.0D) + Math.pow((double)this.y, 2.0D));
   }

   public float distance(Point b) {
      return (float)Math.sqrt(Math.pow((double)(b.getX() - this.x), 2.0D) + Math.pow((double)(b.getY() - this.y), 2.0D));
   }
}
