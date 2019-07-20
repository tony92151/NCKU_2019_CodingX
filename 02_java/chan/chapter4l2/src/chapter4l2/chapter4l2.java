package chapter4l2;

import java.util.Scanner;

public class chapter4l2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.printf("Input n : ");
		int n = scan.nextInt();
		int w = 1+2*(n-1);
		int W = n-1;
		for (int h=0; h<n;h++) {
			for (int k=0; k<w;k++) {
				if(k>=(W-h) && k<=(W+h)) {
					System.out.printf("*");
				}else {
					System.out.printf(" ");
				}	
			}
			System.out.println();	
		}
		System.out.println("output : "+Math.pow(n, 2));
	}
}
