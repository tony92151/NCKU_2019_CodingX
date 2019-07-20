package chapter5l2;

public class cacl {
	
	public int a,b,c;
	public cacl(int a, int b ,int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public int max() {
		return Math.max(Math.max(this.a, this.b),this.c);
	}
	
	public int min() {
		return Math.min(Math.min(this.a, this.b),this.c);
	}
	
	public float avg() {
		return (float) ((this.a+this.b+this.c)/3.0);
	}

}
