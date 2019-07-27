package com.example.hitthebullseye;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class final_score extends AppCompatActivity {

    public TextView scoredis;

    public Button playaga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_final_score);


        Bundle bundle = getIntent().getExtras();
        String score = bundle.getString("score");

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+score);

        scoredis = (TextView)findViewById(R.id.scoreText);
        scoredis.setText(score);

        playaga = (Button)findViewById(R.id.playagain);
        playaga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(final_score.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
