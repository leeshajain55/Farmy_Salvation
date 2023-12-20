package com.example.farmy_salvation;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class MainActivity4 extends AppCompatActivity {
    Button button;
    EditText Record , Date, Feed, Mort, Med;
    String server_url = "http://10.1.82.247/Smart_Poultry/daily_records.php";
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        button = (Button) findViewById(R.id.btid1);
        Record = (EditText) findViewById(R.id.e1);
        Date = (EditText) findViewById(R.id.e2);
        Feed = (EditText) findViewById(R.id.e3);
        Mort = (EditText) findViewById(R.id.e4);
        Med = (EditText) findViewById(R.id.e5);
        builder = new AlertDialog.Builder(MainActivity4.this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String record_no , date, feed, mort, med ;
                record_no =Record.getText().toString();
                date =Date.getText().toString();
                feed =Feed.getText().toString();
                mort =Mort.getText().toString();
                med =Med.getText().toString();
                StringRequest stringRequest = new StringRequest(Request.Method.POST, server_url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        builder.setTitle("Server Response");
                        builder.setMessage("Response :"+response);
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Record.setText("");
                                Date.setText("");
                                Feed.setText("");
                                Mort.setText("");
                                Med.setText("");
                            }
                        });
                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();

                    }
                }

                        , new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity4.this,"some error found .....",Toast.LENGTH_SHORT).show();
                        error.printStackTrace();
                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map <String,String> Params = new HashMap<String, String>();
                        Params.put("record_no",record_no);
                        Params.put("date",date);
                        Params.put("feed",feed);
                        Params.put("mort",mort);
                        Params.put("med",med);
                        return Params;

                    }
                };
                Mysingleton.getInstance(MainActivity4.this).addTorequestque(stringRequest);
            }
        });

    }
}