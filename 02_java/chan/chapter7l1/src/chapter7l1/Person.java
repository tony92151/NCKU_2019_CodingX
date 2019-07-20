package chapter7l1;

public class Person {
	public String name;
	public Person(String name) {
		this.name = name;
	}
	public boolean ask(boolean question) {
		return question;
	}
	
	public String whoami() {
		return this.name;
	}
}
