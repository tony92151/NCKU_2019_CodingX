package chapter5l1;

public class Drink {
	public int[] dring(int a, int b, int c) {//drunk , can drink, bottle
		int[] x = {a,b,c}; 
			
		if (x[2]<=2 && x[1]==0) {
			if (x[2]==2) {
				x[0] += 1;
				x[2] = 0;
				//System.out.println(x[0]+" "+x[1]+" "+x[2]+ " > 1");
				return x;
			}
			//System.out.println(x[0]+" "+x[1]+" "+x[2]+ " > 2");
			return x;
		}else {
			x[0] += x[1];
			x[2] += x[1];
			x[1] = x[2]/3;
			x[2] = x[2]%3;
			Drink d = new Drink();
			//System.out.println(x[0]+" "+x[1]+" "+x[2]+" >> and go on");
			x = d.dring(x[0], x[1], x[2]);
			//System.out.println(x[0]+" "+x[1]+" "+x[2]+ " > 3");
			return x;
		}
	}
}
