package chapter8l3;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//import javax.swing.im

import chapter8l3.MyButtonListener;

//import class5.MyButtonListener;

public class chapter8l3 {

	public static void main(String[] args) {
		int toSleep = 5;
		Color myColor = new Color(0, 64, 128);
		JFrame frame = new JFrame();
		//Color c = Color.get
		frame.setSize(800 ,600);
		frame.setDefaultCloseOperation(JFrame. EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		JButton btnPlay = new JButton ("PLay");
		btnPlay.setSize(100,50);
		JButton btnStop = new JButton ("Stop");
		btnStop.setSize(100,50);
		JButton btnUp = new JButton ("⬆︎︎");
		btnUp.setSize(100,30);
		JButton btnDown = new JButton ("⬇︎");
		btnDown.setSize(100,30);
		//btnPlay.addActionLister(listener);

		//btnPlay.addActionListener(this);
		MyButtonListener mblistenerP = new MyButtonListener();
		MyButtonListener mblistenerS = new MyButtonListener();
		MyButtonListener mblistenerU = new MyButtonListener();
		MyButtonListener mblistenerD = new MyButtonListener();
		
		
		
		
		ImageIcon image = new ImageIcon("/Users/tonyguo/eclipse-workspace/chapter8l3/src/google.png");
		/////////
		Image newimg = image.getImage().getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH);
		image = new ImageIcon(newimg);
		JLabel imglabel = new JLabel(image);
		/////////
		
		JPanel panel = new JPanel();
		panel.setSize(100,100);
		panel.setLayout(new GridLayout());
//		panel.setBackground(Color.ORANGE);
		panel.add(imglabel);
//		panel.add(btn2);
		//panel.add(lb);
		
		JPanel butpanel = new JPanel();
		butpanel.setSize(300,50);
		butpanel.setLayout(new GridLayout());
		butpanel.add(btnPlay);
		butpanel.add(btnStop);
		butpanel.add(btnUp);
		butpanel.add(btnDown);
		butpanel.setLocation(20 ,520);
		butpanel.setBackground(myColor);
		
		
		
		frame.setLayout(null);
		frame.add(butpanel);
		frame.add(panel);
		
		panel.setBackground (myColor);
		frame.getContentPane().setBackground (myColor);
		frame.setVisible(true);
		movement ball = new movement(panel,800,600,100,toSleep);
		boolean star = true;
		
//		btnPlay.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//            	//star = true;
//            	}});
//
//		btnStop.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//            	ball.dirY+=1;
//            	}});
//		btnUp.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//            	ball.dirY+=1;
//            	}});
//		btnDown.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//            	ball.dirY-=1;
//            	}});
		
		while(star) {
			//btnPlay.addActionListener(mblistenerP);
			ball.moving();
			panel.setLocation(ball.locX, ball.locY);
		}

	}
	
	private Image getScaledImage(Image srcImg, int w, int h){
	    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2 = resizedImg.createGraphics();

	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(srcImg, 0, 0, w, h, null);
	    g2.dispose();

	    return resizedImg;
	}

}
