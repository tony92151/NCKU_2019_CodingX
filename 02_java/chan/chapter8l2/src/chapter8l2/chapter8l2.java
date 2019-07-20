package chapter8l2;

import java.util.Arrays;
import java.util.Scanner;

public class chapter8l2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter n matrix : ");
		int n = scan.nextInt();
		int[][] re =  matrix(n);
		boolean real = SymmetricCheck(re);
		System.out.println((real)?"Yes":"No");
	}
	
	
	public static int[][] matrix(int n) {
		Scanner scan2 = new Scanner(System.in);
		int[][] x =new int[n][n];
		for(int j=0;j<n;j++) {
			for(int i=0;i<n;i++) {
				x[j][i] = scan2.nextInt();
				//System.out.println(x[j][i]);
			}
		}
		//System.out.println(Arrays.deepToString(x));
		if (x[0].length!=n || x.length!=n) {
			System.out.println("Size not match.");
			System.exit(0);
		}
		System.out.println("Original : ");
		for (int d=0;d<n;d++) {
			System.out.println(Arrays.toString(x[d]));
		}
		return x;
	}
	public static boolean SymmetricCheck(int[][] x) {
		int[][] before = x;
		int n = x.length;
		
		
		float mid  = n/2;
		for (int i = 0; i< n; i++) {
			for(int j=0;j<=mid;j++) {
				int tem =  x[i][j];
				x[i][j] =  x[i][n-j-1];
				x[i][n-j-1] = tem;
			}
			//System.out.println("New array : "+Arrays.toString(x[i]));
		}
		for (int j = 0; j< mid; j++) {
			int tem[] =  x[j];
			x[j] =  x[n-j-1];
			x[n-1] = tem;
			//System.out.println("New array : "+Arrays.toString(x));
			}
		System.out.println("Transpose : ");
		for (int d=0;d<n;d++) {
			
			System.out.println(Arrays.toString(x[d]));
		}
		
		return (before==x)?true:false;
	}

}
