package com.example.a01_accelerometer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity2 extends AppCompatActivity {

    //private int accDataF = ((MainActivity) this.MainActivity2()).getacc();
    public Button buttonBack;

    public ImageView imgv;

    public  double[] accDataF = {0,0,0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.moving_against);

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
        imgv.setX((int)(accDataF[0]*200));
        imgv.setY((int)(accDataF[1]*200));
        System.out.println("move");



    }
}
