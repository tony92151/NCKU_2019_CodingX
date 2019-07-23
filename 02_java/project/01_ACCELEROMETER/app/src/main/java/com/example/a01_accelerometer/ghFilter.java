package com.example.a01_accelerometer;

public class ghFilter {

    private double time_step = 0.1; //sec
    private double scale_f = 3./10.;
    //private double initial_guess = 0.;
    private double  gain_rate = 0.003;

    public  double weight = 0;

    public ghFilter(){
        System.out.println("ghFilter initialed !! ");
    }

    public void setTime_step(double set){
        this.time_step = set;
    }

    public void setScale_f(double set){
        this.scale_f = set;
    }

    public void setInitialGuess(double set){
        this.weight = set;
    }

    public double update(double Wnow){
        double prediction = weight + gain_rate*gain_rate;
        weight =  prediction + scale_f * (Wnow - prediction);
        System.out.println("weight update ~");
        return weight;
    }
}
