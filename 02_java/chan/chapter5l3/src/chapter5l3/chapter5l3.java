package chapter5l3;

import java.util.Scanner;

public class chapter5l3 {

	public static void main(String[] args) {
		cat cat = new cat(100);
		Scanner scan = new Scanner(System.in);
		System.out.println("What you want your cat do?");
		System.out.println("Type in : eat, drink ,meow ,sleep ,play and exit to leave");
		while (!cat.dd) {
			String n1 = scan.nextLine();
			switch(n1) {
				case("eat"):
					cat.eat();
					break;
				case("drink"):
					cat.drink();
					break;
				case("meow"):
					cat.meow();
					break;
				case("sleep"):
					cat.sleep();
					break;
				case("play"):
					cat.play();
					break;
				case("exit"):
					cat.dd = true;
					break;
				default:
					break;
			}
		}
		scan.close();
	}
}
