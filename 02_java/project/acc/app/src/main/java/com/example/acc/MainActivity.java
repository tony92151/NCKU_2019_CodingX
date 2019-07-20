package com.example.acc;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity
        implements SensorEventListener {
    private Button button1;
    private Button button2;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;

    public double count = 0;
    public ArrayList<Entry>  yvalue = new ArrayList<>();
    public ArrayList<Entry>  yvalue2 = new ArrayList<>();


    public  double[] accData = {0,0,0};//int[] a1 = { 1, 2, 3, 4, 5 };
    public  double timeCount = 0;
    private LineChart mChart;

    private SensorManager sensorManager;
    Sensor acc;

    //private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        button1 = (Button) findViewById(R.id.tbn1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //count+=10;
                //textView1.setText(String.valueOf(count));
            }
        });

        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        acc = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(MainActivity.this,acc,SensorManager.SENSOR_DELAY_NORMAL);

        //List<Sensor> deviceSensors = sensorManager.getSensorList(Sensor.TYPE_ALL);

        textView1 = (TextView) findViewById(R.id.t1);
        textView2 = (TextView) findViewById(R.id.t2);
        textView3 = (TextView) findViewById(R.id.t3);




        //chart Dataset

        ArrayList<Entry>  yvalue = new ArrayList<>();
        yvalue.add(new Entry(0,1.9f));
        yvalue.add(new Entry(1,-1.0f));
        yvalue.add(new Entry(2,.7f));
        yvalue.add(new Entry(3,1.4f));

        LineDataSet set1 = new LineDataSet(yvalue,"X");

        //set1.setCircleColor(Color.BLUE);
        set1.setDrawCircles(false);
        set1.setDrawValues(false);
        set1.setLineWidth(2f);
        set1.setColor(Color.RED);

        ///////////////////////////////////////////////////////////////////////////

//        yvalue2.add(new Entry(0f  ,13f));
//        yvalue2.add(new Entry(0.1f,18f));
//        yvalue2.add(new Entry(0.2f,2f));
//        yvalue2.add(new Entry(0.3f,1f));


        LineDataSet set2 = new LineDataSet(yvalue2,"Y");

        set2.setDrawCircles(false);
        set2.setDrawValues(false);
        set2.setLineWidth(2f);
        set2.setColor(Color.BLUE);

        ///////////////////////////////////////////////////////////////////////////

        //add two data set to dataset
        ArrayList<ILineDataSet>  dataset  = new ArrayList<>();
        dataset.add(set1);
        dataset.add(set2);

        //create chart
        mChart = (LineChart)findViewById(R.id.lineC);
        mChart.setDragEnabled(false);
        mChart.setScaleEnabled(false);
        mChart.setDrawGridBackground(true);
        //add dataset to chart

        LineData ld = new LineData(dataset);
        //ld.addEntry();
        ld.notifyDataChanged();
        mChart.setData(ld);
        mChart.getAxisRight().setAxisMaximum((float)(9.81*2.));
        mChart.getAxisRight().setAxisMinimum((float)(9.81*2.));
        mChart.setMaxVisibleValueCount(150);
        mChart.moveViewToX(ld.getEntryCount());


        Timer timer = new Timer();
        refresh step= new refresh();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                yvalue2.add(new Entry((float)(count*0.1)  ,(float)(accData[1])));
                count+=1;
                System.out.println("Data ++");
                System.out.println((float)(count*0.1));
            }
        }, 100, 100);

        step.acc = accData;


    }


    @Override
    public final void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Do something here if sensor accuracy changes.
    }
    @Override
    public final void onSensorChanged(SensorEvent event) {
        accData[0] = event.values[0];
        accData[1] = event.values[1];
        accData[2] = event.values[2];

        textView1.setText("X: "+event.values[0]);
        textView2.setText("Y: "+event.values[1]);
        textView3.setText("Z: "+event.values[2]);
    }

}
