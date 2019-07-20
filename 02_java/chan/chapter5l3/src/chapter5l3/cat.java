package chapter5l3;

public class cat {
	
	private int HP = 0;
	
	public boolean dd = false;
	
	public cat(int hp) {
		this.HP = hp;
	}
	
	
	public void eat() {
		this.HP +=5;
		System.out.println("HP : "+this.HP);
		this.check();
	}
	
	public void drink(){
		this.HP +=3;
		System.out.println("HP : "+this.HP);
		this.check();
		
	}
	public void meow(){
		this.HP -=10;
		System.out.println("HP : "+this.HP);
		this.check();
	}
	public void sleep(){
		this.HP -=5;
		System.out.println("HP : "+this.HP);
		this.check();
	}
	public void play(){
		this.HP -=30;
		System.out.println("HP : "+this.HP);
		this.check();
	}
	
	public void check() {
		if (this.HP<=0) {
			this.dd = true;
			System.out.println("Your cat is dead.");
		}
	}
	
	
}
