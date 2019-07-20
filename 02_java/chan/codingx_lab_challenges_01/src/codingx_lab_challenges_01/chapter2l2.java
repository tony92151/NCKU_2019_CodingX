package codingx_lab_challenges_01;

import java.util.Scanner;

public class chapter2l2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.printf("Input 3 numbers a,b and c : ");
		float result1 = 0;
		float result2 = 0;
		float a = scan.nextFloat();
		float b = scan.nextFloat();
		float c = scan.nextFloat();
		float mid = (float) (Math.pow(b, 2.) - 4. * a * c);
		// System.out.println(mid);
		if (mid > 0) {
			result1 = (float) (((-1. * b) + mid) / (2. * a));
			result2 = (float) (((-1. * b) - mid) / (2. * a));
		} else if (mid == 0) {
			result1 = (float) ((-1. * b) / (2. * a));
			result2 = result1;
		} else {
			System.out.println("Imaginary number");
			System.exit(0);
		}
		System.out.println("Root1 : " + result1);
		System.out.println("Root1 : " + result2);
	}
}
