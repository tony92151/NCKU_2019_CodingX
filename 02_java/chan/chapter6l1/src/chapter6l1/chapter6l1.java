package chapter6l1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class chapter6l1 {

	public static void main(String[] args) {
		Calculator cal = new Calculator();
		Scanner scan = new Scanner(System.in);
		String fu ;
		ArrayList<String> numbers = new ArrayList<String>();
		System.out.println("Type in : add, sub, mul, div and numbers.");
		System.out.println("Use \",\" to separate them. EX: add,1,3,4");
		String line = scan.next();
		StringTokenizer st = new StringTokenizer(line,",");
		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			numbers.add(token);				

		}
		int length = numbers.size()-1;
		//System.out.println(numbers);
		if(length>4) {
			System.out.println("Error, limited 4 numbers.");
			System.exit(0);
		}
		String[] nA = numbers.toArray(new String[numbers.size()]);
		switch(nA[0]) {
			case("add"):
				if(length<2) {
					System.out.println("Add, need at least 2 numbers.");
					System.exit(0);
				}else if(length==2){
					System.out.println("result : "+cal.add((int)Integer.parseInt(nA[1]), (int)Integer.parseInt(nA[2])));
				}else if(length==3){
					System.out.println("result : "+cal.add((int)Integer.parseInt(nA[1]), (int)Integer.parseInt(nA[2]), (int)Integer.parseInt(nA[3])));
				}else if(length==4){
					System.out.println("result : "+cal.add((int)Integer.parseInt(nA[1]), (int)Integer.parseInt(nA[2]), (int)Integer.parseInt(nA[3]), (int)Integer.parseInt(nA[4])));
				}
				break;
			case("sub"):
				if(length!=2) {
					System.out.println("Sub, need 2 numbers.");
					System.exit(0);
				}else {
					System.out.println("result : "+cal.sub((int)Integer.parseInt(nA[1]), (int)Integer.parseInt(nA[2])));
				}
				break;
			case("mul"):
				if(length<2) {
					System.out.println("Mul, need at least 2 numbers.");
					System.exit(0);
				}else if(length==2){
					System.out.println("result : "+cal.mul((int)Integer.parseInt(nA[1]), (int)Integer.parseInt(nA[2])));
				}else if(length==3){
					System.out.println("result : "+cal.mul((int)Integer.parseInt(nA[1]), (int)Integer.parseInt(nA[2]), (int)Integer.parseInt(nA[3])));
				}else if(length==4){
					System.out.println("result : "+cal.mul((int)Integer.parseInt(nA[1]), (int)Integer.parseInt(nA[2]), (int)Integer.parseInt(nA[3]), (int)Integer.parseInt(nA[4])));
				}
				break;
			case("div"):
				if(length!=2) {
					System.out.println("Div, need 2 numbers.");
					System.exit(0);
				}else {
					System.out.println("result : "+cal.div((int)Integer.parseInt(nA[1]), (int)Integer.parseInt(nA[2])));
				}
				break;
		}
	}

}
