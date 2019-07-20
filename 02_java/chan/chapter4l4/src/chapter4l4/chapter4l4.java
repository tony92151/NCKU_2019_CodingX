package chapter4l4;
import java.util.Scanner;
public class chapter4l4 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.printf("Input times : ");
		int t = scan.nextInt();
		
		while(t!=0) {
			System.out.printf("Input year : ");
			int n = scan.nextInt();
			System.out.println((n%4!=0 || (n%100==0 && n%400!=0))?">> not leap year":">> leap year");
			t = t-1;
		}
		
	}
}
