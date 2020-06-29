package com.example.splashscreen1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

        TextView mobile_text,zone_text;
        Animation blink_anim;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            if (getSupportActionBar() != null) {
                getSupportActionBar().hide();
            }

            mobile_text = findViewById(R.id.mobile);
            zone_text = findViewById(R.id.zone);
            blink_anim = AnimationUtils.loadAnimation(getApplicationContext(),
                    R.anim.blink);
            mobile_text.startAnimation(blink_anim);
            zone_text.startAnimation(blink_anim);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(MainActivity.this, Login.class);
                    startActivity(intent);
                    finish();
                }
            }, 700);
        }
    }