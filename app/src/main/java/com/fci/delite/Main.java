package com.fci.delite;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main extends AppCompatActivity {

    /*4second*/
    private static  int Splash_time_out=4000;
    /**/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/* alt+enter to import handler*/
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run()
            {
                Intent homeIntent=new Intent(Main.this,home.class);
                startActivity(homeIntent);
                finish();
            }
        },Splash_time_out);
        /**/

    }
}
