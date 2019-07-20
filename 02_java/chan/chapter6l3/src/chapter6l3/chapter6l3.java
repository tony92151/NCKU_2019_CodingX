package chapter6l3;

import java.util.Arrays;
import java.util.Scanner;

public class chapter6l3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter numbers : ");
		String num = scan.next();
		char[] Num = num.toCharArray();
		
		int[] number = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		for (int i = 0;i<Num.length;i++) {
			number[(int)Num[i]-48] += 1;
		}
		for (int u = 0; u<number.length ;u++) {
		System.out.println(u+" : "+number[u]);
		}
	}
}
