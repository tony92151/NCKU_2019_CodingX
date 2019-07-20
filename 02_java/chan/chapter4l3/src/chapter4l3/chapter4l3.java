package chapter4l3;
import java.util.Scanner;
public class chapter4l3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.printf("Input n : ");
		int n = scan.nextInt()-1;
		int head = 1;
		int tail = 0;
		int mid = 0;
		
		for(int i=0; i<n; i++) {
			tail = mid;
			mid = head;
			head = mid + tail;
		}
		System.out.print(head);
	}
}
