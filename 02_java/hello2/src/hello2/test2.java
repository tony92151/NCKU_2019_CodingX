package hello2;

import java.util.Scanner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class test2 {

	public static void main(String[] args) {
		//test1
//		double value = 12.123;
//		System.out.printf("Start%8.2fEnd", value);
//		System.out.println();
//		System.out.printf("Start%-8.2fEnd", value);
//		System.out.println();
		
		//test2
//		String s = "abc";
//		System.out.println("String output: ");
//		System.out.println("START123456789");
//		System.out.printf("START%sEND %n ",s);
		
		//test3
//		Scanner scanner = new Scanner(System.in);
//		String line1 = scanner.nextLine();
//		int num = Integer.valueOf(line1);
//		System.out.println("num="+num);
//		String line2 = scanner.nextLine();
//		System.out.println("line:"+line2);
		
		//test4
		try {
			Scanner scannerFile = new Scanner(new FileInputStream("/Users/tonyguo/eclipse-workspace/hello2/text/file.txt"));
			String name = scannerFile.nextLine();
			String name2 = scannerFile.nextLine();
			String name3 = scannerFile.nextLine();
			System.out.println(name);
			System.out.println(name2);
			System.out.println(name3);
		}catch(Exception e){
			System.out.println("Error");
			System.exit(0);
		}
		
		

	}

}
