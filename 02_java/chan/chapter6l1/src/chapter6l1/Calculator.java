package chapter6l1;

public class Calculator {
	
	public int count = 0;
	public double add(double n1, double n2) {
		this.count += 1;
		return n1+n2;
	}
	public double add(double n1, double n2, double n3) {
		this.count += 1;
		return n1+n2+n3;
	}
	public double add(double n1, double n2, double n3 , double n4) {
		this.count += 1;
		return n1+n2+n3+n4;
	}
	
	
	public double sub(double n1, double n2) {
		this.count += 1;
		return n1-n2;
	}
	
	public double mul(double n1, double n2) {
		this.count += 1;
		return n1*n2;
	}
	public double mul(double n1, double n2, double n3) {
		this.count += 1;
		return n1*n2*n3;
	}
	public double mul(double n1, double n2, double n3 , double n4) {
		this.count += 1;
		return n1*n2*n3*n4;
	}
	public double div(double n1, double n2) {
		this.count += 1;
		return n1/n2;
	}
	
	public int getCount() {
		return count;
	}

}
