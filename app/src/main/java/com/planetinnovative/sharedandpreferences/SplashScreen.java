package com.planetinnovative.sharedandpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    String loginSystem = "LoginSystem";
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                SharedPreferences pref = getSharedPreferences(loginSystem, MODE_PRIVATE);
                username = pref.getString("username", "NoValue");
                Intent intent;
                if (username.equals("NoValue")) {
                    intent = new Intent(getApplicationContext(), LoginActivity.class);
                } else {
                    intent = new Intent(getApplicationContext(), SecondActivity.class);
                }
                startActivity(intent);
                finish();
            }
        };
        Handler handler = new Handler();
        handler.postDelayed(runnable, 2000);
    }
}
