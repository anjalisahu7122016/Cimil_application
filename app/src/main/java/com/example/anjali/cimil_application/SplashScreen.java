package com.example.anjali.cimil_application;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {
    TextView header,subheader;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
       header = (TextView)findViewById(R.id.header);
        subheader = (TextView)findViewById(R.id.sub_header);


        Typeface custom_font = Typeface.createFromAsset(getAssets(),"garamond.ttf");
        header.setTypeface(custom_font);
        subheader.setTypeface(custom_font);
        Thread myThread = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(5000);
                    startActivity(new Intent(SplashScreen.this,RegistrationActivity.class));
                    finish();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

            }
        };myThread.start();


    }
}
