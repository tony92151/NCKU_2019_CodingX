package com.example.a01_accelerometer;

public class ghFilter {

    private double time_step = 0.1; //sec
    private double scale_f = 3./10.;
    //private double initial_guess = 0.;
    private double  gain_rate = 0.003;

    public  double weight = 0;
    public  double old_weight = 0;



    private   double old_v = 0;

    private   double x = 0;
    private   double old_x = 0;


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

    public double update(double Wnow,String d){
        old_weight = weight;
        double prediction = weight + gain_rate*gain_rate;
        weight =  prediction + scale_f * (Wnow - prediction);
        caldir(d);
        //System.out.println("weight update ~");
        return weight;
    }

    private void caldir(String d){

        double new_weight = 0;

        if(d=="Y"){
            //weight = weight+180;
        }

//        if (old_weight>300 && weight<300){
//            new_weight = 360+weight;
//        }else if (old_weight<60 && weight>300){
//            new_weight = -weight;
//        }else{
//            new_weight = weight;
//        }



        double dv = weight - old_weight;

        //double dx =  (-(dv - old_v)/2)*time_step;

        old_weight = weight;


        x = x + dv*10;

        //System.out.println("dx: "+dv);
    }

    public double getdir(){
        return x;
    }
}
