package chapter7l1;

public class chapter7l1 {

	public static void main(String[] args) {
		Person John = new Person("John");
		
		Idiot bob = new Idiot("Bob");
		
		Badguy tony = new Badguy("Tony");
		
		System.out.printf("John : "+John.ask(1>1)+"\n");
		System.out.printf("Bob : "+bob.ask(1>1)+"\n");
		System.out.printf("Tony : "+tony.ask(1>1)+"\n");

	}

}
