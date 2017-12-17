package com.fci.delite;


import android.app.ActionBar;
import android.content.Intent;
import android.net.wifi.hotspot2.pps.HomeSp;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class home extends AppCompatActivity {


    private static  int Splash_time_out=4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run()
            {
                Intent homeIntent=new Intent(home.this,SignU.class);
                startActivity(homeIntent);
                finish();
            }
        },Splash_time_out);


    }
}
