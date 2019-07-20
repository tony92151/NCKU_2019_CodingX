package codingx_lab_challenges_01;

import java.util.Scanner;

public class chapter2l1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Calculate the average of these numbers.");
		System.out.printf("Input 5 numbers from keyboard : ");
		int n1 = scan.nextInt();
		int n2 = scan.nextInt();
		int n3 = scan.nextInt();
		int n4 = scan.nextInt();
		int n5 = scan.nextInt();
		float avg = (float) ((n1+n2+n3+n4+n5)/5.0);
		System.out.println("Sample Output : "+avg);

	}

}
