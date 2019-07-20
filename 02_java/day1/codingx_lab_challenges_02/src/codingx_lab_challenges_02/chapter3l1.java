package codingx_lab_challenges_02;

import java.util.Scanner;

public class chapter3l1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Input 2 numbers, weight(kg) and height(m) : ");
		float k = scan.nextFloat();
		float m = scan.nextFloat();
		float bmi = (float) ((k)/(Math.pow(m, 2)));
		System.out.printf("BMI : %.2f %n",bmi);
	}

}
