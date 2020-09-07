package com.kelvinwachiye.leaderboard.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.kelvinwachiye.leaderboard.R;

public class SplashScreen extends AppCompatActivity {

    public static final int DELAY_MILLIS = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, LaunchActivity.class);
                startActivity(intent);
                finish();
            }
        }, DELAY_MILLIS);
    }
}