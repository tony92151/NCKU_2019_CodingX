package chapter3l2;

import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

public class chapter3l2 {

	public static void main(String[] args) {
		String cwd = new File("").getAbsolutePath();
		FileOutputStream fos = null;

		Scanner scan = new Scanner(System.in);
		System.out.printf("Input p : ");
		float p = scan.nextFloat();
		System.out.printf("Input 3 numbers n1,n2 and n3 : ");
		float a = scan.nextFloat();
		float b = scan.nextFloat();
		float c = scan.nextFloat();
		float value = (float) (Math.pow(a, p) + Math.pow(b, p) + Math.pow(c, p));
		System.out.println("Result : " + value);

		try {
			fos = new FileOutputStream(cwd + "/text/output.txt");
			fos.write(String.valueOf(value).getBytes());
			fos.flush();
			fos.close();
			System.out.printf("Save output to " + cwd + "/text/");
		} catch (Exception ex) {
			System.out.printf("Dir Error");
			System.exit(0);
		}

	}

}
