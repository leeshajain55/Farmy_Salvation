package com.example.farmy_salvation;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;

public class MainActivity3 extends AppCompatActivity {
    private EditText id4;
    private EditText id5;
    private Button btid1;
    private TextView id6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        id4 = (EditText) findViewById(R.id.id4);
        id5 = (EditText) findViewById(R.id.id5);
        btid1 = (Button) findViewById(R.id.btid1);
        id6 = (TextView) findViewById(R.id.id6);

        btid1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double a = Double.parseDouble(id4.getText().toString());
                double b = Double.parseDouble(id5.getText().toString());

                double divide = (a/b)/100;
                id6.setText(String.valueOf(divide));
            }
        });
    }
}