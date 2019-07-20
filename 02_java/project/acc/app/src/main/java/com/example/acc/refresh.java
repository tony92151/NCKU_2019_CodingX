package com.example.acc;

import com.github.mikephil.charting.data.Entry;

import java.util.ArrayList;
import java.util.Date;
import java.util.TimerTask;

public class refresh extends TimerTask {
    public double[] acc = {0,0,0};

    public boolean toAdd = false;
    @Override
    public void run() {
        this.toAdd = true;
    }
//    public void run(ArrayList<Entry> arr) {
//        arr.add(new Entry(0f  ,(float)(acc[0]));
//        this.toAdd = true;
//        System.out.println("Data ++ true");
//    }

//    public double[] add2chart(){
//        double[] ac = {0,0,0};
//        return
//    }
}
