package chapter8l3;

import javax.swing.JPanel;

public class movement {
	
	private JPanel panel;
	private int boundX;
	private int boundY;
	private int toSleep;
	public int dirX = 10;
	public int dirY = 12;
	public int locX;
	public int locY;
	public movement(JPanel panel,int boundX ,int boundY,int imageWH, int toSleep) {
		this.panel = panel;
		this.boundX = boundX-imageWH;
		this.boundY  =boundY-imageWH;
		this.toSleep = toSleep;
		this.locX = imageWH/2;
		this.locY = imageWH/2;
	}
	public void moving() {
		try {
			Thread.sleep (this.toSleep);
		}catch (Exception e) {
			e.printStackTrace();
		}
		this.locX += dirX*0.1;
		this.locY += dirY*0.1;
		if (this.locX>this.boundX || this.locX<0) {
			this.dirX = -this.dirX;
		}
		if (this.locY>this.boundY || this.locY<0) {
			this.dirY = -this.dirY;
		}
	}
	
}
