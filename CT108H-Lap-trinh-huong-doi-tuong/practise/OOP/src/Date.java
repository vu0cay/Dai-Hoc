package lab2;

import java.util.Scanner;

public class Date {
   private int d;
   private int m;
   private int y;

   public Date() {
   }

   public Date(int day, int month, int year) {
      this.d = day;
      this.m = month;
      this.y = year;
   }

   public void show() {
      System.out.println(this.d + "/" + this.m + "/" + this.y);
   }

   public void input() {
      Scanner sc = new Scanner(System.in);

      do {
         System.out.println("Enter day, month, year: ");
         this.d = sc.nextInt();
         this.m = sc.nextInt();
         this.y = sc.nextInt();
      } while(!this.valid());

   }

   public boolean valid() {
      int[] dayOfMonth = new int[]{0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
      dayOfMonth[2] = (this.y % 4 != 0 || this.y % 100 == 0) && this.y % 400 != 0 ? 28 : 29;
      boolean check = false;
      if (this.d > 0 && this.d <= dayOfMonth[this.m] && this.m > 0 && this.m < 13 && this.y > 0) {
         check = true;
      }

      return check;
   }

   public Date tomorrow() {
      ++this.d;
      if (!this.valid()) {
         this.d = 1;
         ++this.m;
         if (!this.valid()) {
            this.m = 1;
            ++this.y;
         }
      }

      return new Date(this.d, this.m, this.y);
   }

   public Date addDay(int n) {
      for(int i = 1; i <= n; ++i) {
         ++this.d;
         if (!this.valid()) {
            this.d = 1;
            ++this.m;
            if (!this.valid()) {
               this.m = 1;
               ++this.y;
            }
         }
      }

      return new Date(this.d, this.m, this.y);
   }
}
