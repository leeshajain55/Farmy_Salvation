package com.example.farmy_salvation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtPoultry;
    RelativeLayout relativeLayout;
    Animation txtAnimation,layoutAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtAnimation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.fall_down);
        layoutAnimation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.bottom_to_top);

        txtPoultry = findViewById(R.id.txtPoultry);
        relativeLayout = findViewById(R.id.relMain);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                relativeLayout.setVisibility(View.VISIBLE);
                relativeLayout.setAnimation(layoutAnimation);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        txtPoultry.setVisibility(View.VISIBLE);
                        txtPoultry.setAnimation(txtAnimation);
                    }
                }, 900);
            }
        }, 500);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,dashboard.class);
                startActivity(intent);
            }
        }, 6000);
    }
}