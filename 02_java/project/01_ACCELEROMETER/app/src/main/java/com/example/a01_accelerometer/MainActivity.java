package com.example.a01_accelerometer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;




import net.kibotu.kalmanrx.KalmanRx;

import java.util.ArrayList;

import org.opencv.core.Core;
import org.opencv.video.KalmanFilter;
import org.opencv.core.Mat;
import static org.opencv.core.CvType.CV_32F;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private Button button1;
    private Button button2;
    private Button button2map;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;

    public  double[] accData = {0,0,0};
    public  double[] accDataF = {0,0,0};
    private SensorManager sensorManager;
    Sensor acc;

    //public LineChart mChart = new LineChart(this);
    public LineChart mChart;
    public LineChart mChart2;
    public LineChart mChart3;
    public ArrayList<Entry> valueX = new ArrayList<>();
    public ArrayList<Entry> valueY =  new ArrayList<>();
    public ArrayList<Entry> valueZ = new ArrayList<>();
    public LineDataSet set1 = new LineDataSet(valueX,"X");
    public LineDataSet set2 = new LineDataSet(valueY,"Y");
    public LineDataSet set3 = new LineDataSet(valueZ,"Z");

    public ArrayList<Entry> valueXF = new ArrayList<>();
    public ArrayList<Entry> valueYF =  new ArrayList<>();
    public ArrayList<Entry> valueZF = new ArrayList<>();
    public LineDataSet set1F = new LineDataSet(valueXF,"XF");
    public LineDataSet set2F = new LineDataSet(valueYF,"YF");
    public LineDataSet set3F = new LineDataSet(valueZF,"ZF");

    public ghFilter x_filter =  new ghFilter();
    public ghFilter y_filter =  new ghFilter();
    public ghFilter z_filter =  new ghFilter();


    public LineData Ldata1 = new LineData(set1,set1F);
    public LineData Ldata2 = new LineData(set2,set2F);
    public LineData Ldata3 = new LineData(set3,set3F);
    public double count;

    //public globalVariable gv = (globalVariable)getApplicationContext();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainlayout);



        //button seeting
        //button1 = (Button) findViewById(R.id.t1);
        button1 = (Button) findViewById(R.id.tbn1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueX.clear();
                valueY.clear();
                valueZ.clear();
                //count+=10;
                //textView1.setText(String.valueOf(count));
            }
        });

        button2map = (Button)findViewById(R.id.toMapbt);
        button2map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("accDF",accDataF);
                startActivity(intent);
            }
        });

//        KalmanFilter kf  = new KalmanFilter(3, 4);
//        Mat state = new Mat(2, 1, CV_32F);
//        double[][] t = {{1}};
//        //Mat a = new Mat({{1,0,0,0},{0,1,0,0}});
//        kf.set_measurementMatrix(state);
//        kf.set_transitionMatrix();
//        kf.

        //read sensor
        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        acc = sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);
        sensorManager.registerListener(MainActivity.this,acc,SensorManager.SENSOR_DELAY_NORMAL);

        int i = 0;
        while (i<50){
            accDataF[0] = x_filter.update(accData[0],"X");
            accDataF[1] = y_filter.update(accData[1],"Y");
            accDataF[2] = z_filter.update(accData[2],"Z");
            System.out.println("flush 10 data");
            i++;
        }

        textView1 = (TextView) findViewById(R.id.t1);
        textView2 = (TextView) findViewById(R.id.t2);
        textView3 = (TextView) findViewById(R.id.t3);

        ////////////////////////////////////////////////////////////
        //ArrayList<Entry>  yvalue = new ArrayList<>();
//        valueX.add(new Entry(0,1.9f));
//        valueX.add(new Entry(1,-1.0f));
//        valueX.add(new Entry(2,.7f));
//        valueX.add(new Entry(3,1.4f));

        //LineDataSet set1 = new LineDataSet(yvalue,"X");


        //set1.setCircleColor(Color.BLUE);
//        set1.setDrawCircles(false);
//        set1.setDrawValues(false);
//        set1.setLineWidth(2f);
//        set1.setColor(Color.RED);
        ////////////////////////////////////////////////////////////
        //set1.setDrawCircles(false);
        set1.setCircleColor(Color.BLUE);
        set1.setColor(Color.BLUE);
        set1.setDrawCircleHole(false);
        set1.setDrawValues(false);
        set1.setLineWidth(0f);

        set2.setCircleColor(Color.RED);
        set2.setColor(Color.RED);
        set2.setDrawCircleHole(false);
        set2.setDrawValues(false);
        set2.setLineWidth(0f);

        set3.setCircleColor(Color.GREEN);
        set3.setColor(Color.GREEN);
        set3.setDrawCircleHole(false);
        set3.setDrawValues(false);
        set3.setLineWidth(0f);

        ////////////////////////////////////////////////////////////
        //set1.setDrawCircles(false);
        set1F.setDrawCircles(false);
        set1F.setColor(Color.BLUE);
        set1F.setDrawValues(false);
        set1F.setLineWidth(2f);

        set2F.setDrawCircles(false);
        set2F.setColor(Color.RED);
        set2F.setDrawValues(false);
        set2F.setLineWidth(2f);

        set3F.setDrawCircles(false);
        set3F.setColor(Color.GREEN);
        set3F.setDrawValues(false);
        set3F.setLineWidth(2f);

//        Ldata = new LineData();
//        Ldata.addDataSet(set1);
//        Ldata2.addDataSet(set2);
//        Ldata3.addDataSet(set3);

        mChart = new LineChart(this);
        mChart = (LineChart)findViewById(R.id.lineC);
        mChart.setData(Ldata1);

        mChart.setDragEnabled(false);
        mChart.setTouchEnabled(false);
        mChart.setScaleEnabled(false);
        mChart.setPinchZoom(true);
        mChart.setDrawGridBackground(true);



        mChart2 = new LineChart(this);
        mChart2 = (LineChart)findViewById(R.id.lineC2);
        mChart2.setData(Ldata2);

        mChart2.setDragEnabled(false);
        mChart2.setTouchEnabled(false);
        mChart2.setScaleEnabled(false);
        mChart2.setPinchZoom(true);
        mChart2.setDrawGridBackground(true);



        mChart3 = new LineChart(this);
        mChart3 = (LineChart)findViewById(R.id.lineC3);
        mChart3.setData(Ldata3);

        mChart3.setDragEnabled(false);
        mChart3.setTouchEnabled(false);
        mChart3.setScaleEnabled(false);
        mChart3.setPinchZoom(true);
        mChart3.setDrawGridBackground(true);
        //LineData data = new LineData();
        //data.addDataSet(set1);
        //data.notifyDataChanged();
        //mChart.setData(Ldata);
//        mChart.setData(Ldata2);
//        mChart.setData(Ldata3);

//        mChart.getAxisRight().setEnabled(false);
//        mChart.getAxisLeft().setAxisMinimum((float)(9.81*2.));

        //System.out.println("chart ++");

//        KalmanRx.createFrom1D()

//        KalmanRx.createFrom1D(floatObservable..map(e -> e.value))
//        .subscribe(value->{}, Throwable::printStackTrace);

        x_filter.setTime_step(0.05);
        y_filter.setTime_step(0.05);
        z_filter.setTime_step(0.05);

    }

    @Override
    protected void onResume() {
        super.onResume();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<100000;i++){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            addentry();
                            accDataF[0] = x_filter.update(accData[0],"X");
                            accDataF[1] = y_filter.update(accData[1],"Y");
                            accDataF[2] = z_filter.update(accData[2],"Z");
                            count++;
                            //gv.setacc(accDataF);
                        }
                    });
                    try {
                        //System.out.println("sleep");
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    private void addentry(){
        //LineData data = mChart.getData();
        if (Ldata1!=null){
//            System.out.println("data ++");
//            System.out.println(set1);
//            System.out.println("coun: "+count);
            valueX.add(new Entry((float)(count*0.05),(float)accData[0]));
            valueY.add(new Entry((float)(count*0.05),(float)accData[1]));
            valueZ.add(new Entry((float)(count*0.05),(float)accData[2]));

            valueXF.add(new Entry((float)(count*0.05),(float)accDataF[0]));
            valueYF.add(new Entry((float)(count*0.05),(float)accDataF[1]));
            valueZF.add(new Entry((float)(count*0.05),(float)accDataF[2]));

            if (valueX.size()>40){
                valueX.remove(0);
                valueY.remove(0);
                valueZ.remove(0);
            }
            //valueX.notify();
            //Ldata.addEntry(new Entry(0.5f,19f),0);
            //System.out.println("data --");
            set1.notifyDataSetChanged();
            Ldata1.notifyDataChanged();
            mChart.notifyDataSetChanged();

            set2.notifyDataSetChanged();
            Ldata2.notifyDataChanged();
            mChart2.notifyDataSetChanged();

            set3.notifyDataSetChanged();
            Ldata3.notifyDataChanged();
            mChart3.notifyDataSetChanged();

        }
        //mChart.setVisibleXRange(-1,1);
        mChart.moveViewToX((float)(Ldata1.getDataSetCount()));
        mChart2.moveViewToX((float)(Ldata2.getDataSetCount()));
        mChart3.moveViewToX((float)(Ldata3.getDataSetCount()));


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
