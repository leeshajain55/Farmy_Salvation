package com.example.farmy_salvation;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;

public class MainActivity2 extends AppCompatActivity {
    private EditText id1;
    private EditText id2;
    private Button btid;
    private TextView id3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        id1 = (EditText) findViewById(R.id.id1);
        id2 = (EditText) findViewById(R.id.id2);
        btid = (Button) findViewById(R.id.btid);
        id3 = (TextView) findViewById(R.id.id3);

        btid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double a = Double.parseDouble(id1.getText().toString());
                double b = Double.parseDouble(id2.getText().toString());

                double divide = a/b;
                id3.setText(String.valueOf(divide));
            }
        });
    }
}