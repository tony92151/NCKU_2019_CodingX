package codingx_lab_challenges_02;

import java.util.Scanner;

public class chapter3l2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.printf("Input p : ");
		float p = scan.nextFloat();
		System.out.printf("Input 3 numbers n1,n2 and n3 : ");
		float a = scan.nextFloat();
		float b = scan.nextFloat();
		float c = scan.nextFloat();
		float value = (float)(Math.pow(a, p)+Math.pow(b, p)+Math.pow(c, p));
		System.out.printf("Result : "+value);
	}

}
