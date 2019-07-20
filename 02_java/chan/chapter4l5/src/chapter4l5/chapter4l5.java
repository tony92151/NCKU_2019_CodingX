package chapter4l5;

import java.util.Scanner;

public class chapter4l5 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.printf("Money : ");
		int n2 = scan.nextInt();
		int n = scan.nextInt();
		if (n2>n) {
			System.out.printf("Insufficient amount");
			System.exit(0);
		}
		
		n = n-n2;
		
		int thou = n/1000;
		n = n - 1000*thou;
		
		int fiveh = n/500;
		n = n - 500*fiveh;
		
		int han = n/100;
		n = n - 100*han;
		
		int fivty = n/50;
		n = n - 50*fivty;
		
		int ten = n/10;
		n = n - 10*ten;
		
		int five = n/5;
		n = n - 5*five;
		
		if (thou>0)
			System.out.printf("Give you %d*$1000 ",thou);
		
		if (fiveh>0)
			System.out.printf("%d*$500 ",fiveh);
		
		if (han>0)
			System.out.printf("%d*$100 ",han);
		
		if (fivty>0)
			System.out.printf("%d*$50 ",fivty);
		
		if (ten>0)
			System.out.printf("%d*$10 ",ten);
		
		if (five>0)
			System.out.printf("%d*$5 ",five);
		
		if (n>0)
			System.out.printf("%d*$1 ",n);
		//System.out.printf("Give you %d $1000 %d $500 %d $100 %d $50 %d $10 %d $5 %d $1",thou,fiveh,han,fiveh,ten,five,n);

	}

}
