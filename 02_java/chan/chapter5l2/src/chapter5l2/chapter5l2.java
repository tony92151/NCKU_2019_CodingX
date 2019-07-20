package chapter5l2;

import java.util.Scanner;

public class chapter5l2 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.printf("Enter three number : ");
		int n1 = scan.nextInt();
		int n2 = scan.nextInt();
		int n3 = scan.nextInt();
		cacl ca = new cacl(n1,n2,n3);
		
		System.out.println("Max : "+ca.max());
		System.out.println("Min : "+ca.min());
		System.out.printf("Avg : %.2f",ca.avg());

	}

}
