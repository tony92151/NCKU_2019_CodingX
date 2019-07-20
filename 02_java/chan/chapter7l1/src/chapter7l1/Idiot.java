package chapter7l1;

//import java.util.Random;

public class Idiot extends Person{
	public Idiot(String name) {
		super(name);
	}
	public boolean ask(boolean question) {
		return (Math.random()>0.5)?false:true;
	}
}