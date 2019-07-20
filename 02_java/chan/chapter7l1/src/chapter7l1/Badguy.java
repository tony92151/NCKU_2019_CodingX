package chapter7l1;

public class Badguy extends Person{
	public Badguy(String name) {
		super(name);
	}
	public boolean ask(boolean question) {
		return !question;
	}
}
