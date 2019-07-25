package com.example.a01_accelerometer;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity2 extends AppCompatActivity implements SensorEventListener {

    //private int accDataF = ((MainActivity) this.MainActivity2()).getacc();
    public Button buttonBack;

    public ImageView imgv;
    public ImageView eye;

    public  double[] accDataF = {0,0,0};
    public  double[] accData = {0,0,0};

    private SensorManager sensorManager;
    Sensor acc;
    public double count;

    public ghFilter x_filter =  new ghFilter();
    public ghFilter y_filter =  new ghFilter();
    public ghFilter z_filter =  new ghFilter();

    //public globalVariable gv = (globalVariable)getApplicationContext();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //flush 10 data


        super.onCreate(savedInstanceState);
        setContentView(R.layout.moving_against);

        int i = 0;
        while (i<50){
            accDataF[0] = x_filter.update(accData[0],"X");
            accDataF[1] = y_filter.update(accData[1],"Y");
            accDataF[2] = z_filter.update(accData[2],"Z");
            System.out.println("flush 10 data");
            i++;
        }

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            accDataF = extras.getDoubleArray("accDF");
        }


        buttonBack = (Button)findViewById(R.id.backbt);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });

        imgv = (ImageView)findViewById(R.id.imgview);

        eye = (ImageView)findViewById(R.id.eye);
        imgv.setX((int)(accDataF[0]*100));
        imgv.setY((int)(accDataF[1]*100));
        System.out.println("move");

        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        acc = sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);
        sensorManager.registerListener(MainActivity2.this,acc,SensorManager.SENSOR_DELAY_NORMAL);

        //flush 10 data
//        for (int i = 0;i<10;i++){
//            accDataF[0] = x_filter.update(accData[0],"X");
//            accDataF[1] = y_filter.update(accData[1],"Y");
//            accDataF[2] = z_filter.update(accData[2],"Z");
//            System.out.println("flush 10 data");
//        }

        x_filter.setTime_step(0.05);
        y_filter.setTime_step(0.05);
        z_filter.setTime_step(0.05);




    }

    protected void onResume() {
        super.onResume();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<100000;i++){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            accDataF[0] = x_filter.update(accData[0],"X");
                            accDataF[1] = y_filter.update(accData[1],"Y");
                            accDataF[2] = z_filter.update(accData[2],"Z");
                            count++;
                            imgv.setX((int)y_filter.getdir()*250-2000);
                            eye.setX((int)y_filter.getdir()*250-2000);
                            System.out.println("X dir = " +(x_filter.getdir()*10+200));
                            imgv.setY((int)x_filter.getdir()*250-2500);
                            eye.setY((int)x_filter.getdir()*250-2500);
                            System.out.println("y dir = " +(y_filter.getdir()*10+400));
                            //System.out.println("move");
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

    @Override
    public final void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Do something here if sensor accuracy changes.
    }
    @Override
    public final void onSensorChanged(SensorEvent event) {
        accData[0] = event.values[0];
        accData[1] = event.values[1];
        accData[2] = event.values[2];
    }
}
