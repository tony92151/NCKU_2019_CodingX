package chapter8l1;

import java.util.Scanner;

public class chapter8l1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter X : ");
		int x = scan.nextInt();
		System.out.println("Enter Y : ");
		int y = scan.nextInt();
		System.out.printf( "---- x=%d \t ----y=%d         \n",x,y);
		System.out.println("\\        \t \\               ");
		System.out.println(" \\       \t  \\       j   ---");
		System.out.println(" /        \t  /     i     ---");
		System.out.println("/         \t /                ");
		System.out.println("---- i=1  \t ---- j=1         ");
		int total = 0;
		for(int i=1;i<=x;i++) {
			for(int j=1;j<=y;j++) {
				total = (int) (total+ Math.pow(i, j));
			}
		}
		System.out.println(total);
	}

}
