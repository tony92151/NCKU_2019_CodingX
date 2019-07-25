package com.example.hitthebullseye;

public class score {
    public int score = 0;


    public double[] target1 = new double[] {243.29, 354.33};
    public double[] target2 = new double[] { 283.53,392.99};
    public double[] target3 = new double[] { 255.21,431.145};


    public void play(double[] location, boolean shoot) {

        if (aimed(location) == true && shoot == true) {
            score = score + 1;
            System.out.println("You got points!");

        }

        else if (aimed(location) == true && shoot == false) {
            System.out.println("Good chance!");
        }

        else if (aimed(location) == false && shoot == true) {
            System.out.println("Opps! Try again.");

        }
    }

    public boolean aimed(double[] location) { // location是位移後的座標位置
        boolean yes_or_no=false;
        double dx1 = Math.pow(location[0] - (target1[0]), 2);
        double dy1 = Math.pow(location[1] - (target1[1]), 2);
        double dir1 = Math.pow(dx1 + dy1, 0.5);
        if (dir1< 10) {
            yes_or_no = true;
        }
        double dx2 = Math.pow(location[0] - (target2[0]), 2);
        double dy2 = Math.pow(location[1] - (target2[1]), 2);
        double dir2 = Math.pow(dx2 + dy2, 0.5);
        if (dir2 < 10) {
            yes_or_no = true;
        }
        double dx3 = Math.pow(location[0] - (target3[0]), 2);
        double dy3 = Math.pow(location[1] - (target3[1]), 2);
        double dir3 = Math.pow(dx3 + dy3, 0.5);
        if (dir3 < 10) {
            yes_or_no=true;
        }
           return yes_or_no;
    }


}
