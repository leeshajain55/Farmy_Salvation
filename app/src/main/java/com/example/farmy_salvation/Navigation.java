package com.example.farmy_salvation;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;

import android.widget.TextView;

import android.os.Bundle;

public class Navigation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        final TextView home = findViewById(R.id.home);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "Hello World", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getApplicationContext(),dashboard.class);
                startActivity(i);

            }
        });

        final TextView about = findViewById(R.id.about);

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "Hello World", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getApplicationContext(),About.class);
                startActivity(i);

            }
        });

        final TextView fcr = findViewById(R.id.fcr);

        fcr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "Hello World", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(i);

            }
        });
//
        final TextView mort = findViewById(R.id.mort);

        mort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "Hello World", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getApplicationContext(),MainActivity3.class);
                startActivity(i);

            }
        });

        final TextView record = findViewById(R.id.record);

        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "Hello World", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getApplicationContext(),MainActivity4.class);
                startActivity(i);

            }
        });
    }

}

