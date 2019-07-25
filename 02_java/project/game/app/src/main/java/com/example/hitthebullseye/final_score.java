package com.example.hitthebullseye;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class final_score extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_score);


        Bundle bundle = getIntent().getExtras();
        String score = bundle.getString("score");

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+score);
    }
}
