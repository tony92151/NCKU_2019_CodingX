package chapter6l2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class chapter6l2 {

	public static void main(String[] args) {
		System.out.println("Enter the length : ");
		Scanner scan = new Scanner(System.in);
		int line = scan.nextInt();
		System.out.println("Enter an array and use \",\" to separate them.");
		ArrayList<String> numbers = new ArrayList<String>();
		
		String l = scan.next();
		StringTokenizer st = new StringTokenizer(l,",");
		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			numbers.add(token);				
		}
		if (line!=numbers.size()) {
			System.out.println("Error, length not match.");
			System.exit(0);
		}
		String[] nA = numbers.toArray(new String[numbers.size()]);
		System.out.println("Original : "+Arrays.toString(nA));
		
		float mid  = nA.length/2;
		for (float i = 0; i< mid; i++) {
			String tem =  nA[(int)i];
			nA[(int)i] =  nA[nA.length-(int)i-1];
			nA[nA.length-(int)i-1] = tem;
			//System.out.println("New array : "+Arrays.toString(nA));
		}
		System.out.println("New array : "+Arrays.toString(nA));
	}
}
