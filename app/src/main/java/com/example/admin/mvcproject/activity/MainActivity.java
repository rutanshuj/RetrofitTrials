package com.example.admin.mvcproject.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.admin.mvcproject.R;

public class MainActivity extends AppCompatActivity {

    private Button b1, b2, b3, b4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.nextscreen);
        b2 = (Button) findViewById(R.id.rfs);
        b3 = (Button) findViewById(R.id.button3);
        b4 = (Button) findViewById(R.id.tutorial);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, VideoPlayer.class);
                startActivity(i);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(MainActivity.this, Retrofit.class);
                startActivity(j);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(MainActivity.this, AddEditPost.class);
                startActivity(k);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent l = new Intent(MainActivity.this, RetrofitImageUploadingTutorial.class);
                startActivity(l);
            }
        });
    }
}
