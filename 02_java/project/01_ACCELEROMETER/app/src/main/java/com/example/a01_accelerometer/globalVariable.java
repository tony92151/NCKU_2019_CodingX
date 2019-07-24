package com.example.a01_accelerometer;

import android.app.Application;
public class globalVariable extends Application {

    public globalVariable(){
        System.out.println("GlobalVariable initialed !! ");
    }
    private double[] accDF = {0,0,0};

    public double[] getacc() {
        return accDF;
    }
    public void setacc(double[] acc){
        this.accDF = acc;
    }

}

