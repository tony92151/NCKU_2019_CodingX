package chapter5l1;

import java.util.Scanner;

public class chapter5l1 {

	public static void main(String[] args) {
		Drink d = new Drink();
		Scanner scan = new Scanner(System.in);
		System.out.printf("Beverage to brink : ");
		int n = scan.nextInt();
		int[] x = {0,n,0}; 
		x = d.dring(x[0], x[1], x[2]);
		System.out.println("Drink "+x[0]+" bottles ");
	}
}
