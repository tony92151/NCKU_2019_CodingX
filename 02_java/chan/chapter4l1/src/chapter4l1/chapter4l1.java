package chapter4l1;

import java.util.ArrayList;
import java.util.Scanner;

public class chapter4l1 {

	public static void main(String[] args) {
		
		                       //a   b   c    d   e   f   g   h  i   j   k   l   m   n 
		int[] local = new int[]{ 10, 11, 12, 13, 14, 15, 16, 17, 34, 18, 19, 20, 21, 22, 
				                 35, 23, 24, 25, 26, 27, 28, 29, 32, 30, 31, 33};
		                       //o   p   q   r   s   t   u   v   w   x   y   z
		
		
		int[] andTo = new int[]{1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 1};
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Input ID : ");
		String ID = scan.next().toUpperCase();
		if (ID.length()!=10) {
			System.out.printf("ID ERROR. Please try again.");
			System.exit(0);
		}
		char[] IDC = ID.toCharArray();
		int en2num =  local[(int)IDC[0]-65];
		
		int total = 0;
		
		for (int i = 0; i<9; i++) {
			total = total + ((int)IDC[i+1]-48) * andTo[i+2];
		}
		
		total = total + (en2num/10)*andTo[0] +  (en2num%10)*andTo[1];
		
		System.out.printf((total % 10 == 0)?"valid":"invalid");

	}

}
