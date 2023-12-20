package com.example.farmy_salvation;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;



import android.util.JsonReader;
import android.util.Log;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;



import com.android.volley.Request;

import com.android.volley.RequestQueue;

import com.android.volley.Response;

import com.android.volley.VolleyError;

import com.android.volley.toolbox.StringRequest;

import com.android.volley.toolbox.Volley;



import java.util.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
import org.json.*;


import com.android.volley.toolbox.JsonObjectRequest;


public class dashboard extends AppCompatActivity {

    private RequestQueue mRequestQueue;

    private StringRequest mStringRequest;

    private String url = "https://api.thingspeak.com/channels/1092649/feeds.json?results=2";
    public String field1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        getData();

        final ImageView img = findViewById(R.id.img);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "Hello World", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getApplicationContext(),Navigation.class);
                startActivity(i);

            }
        });
    }
//    Fetching data from thingspeak code...
    private void getData() {

        // RequestQueue initialized

        mRequestQueue = Volley.newRequestQueue(this);



        // String Request initialized

        mStringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

            @Override

            public void onResponse(String response) {
                final TextView textView3 = findViewById(R.id.txt1);
                final TextView textView4 = findViewById(R.id.txt2);
                final TextView textView5 = findViewById(R.id.txt3);
                String newRespone= response.toString();
                int index1=newRespone.indexOf("feeds");
                String newResponse=response.substring(index1);

                int index2=newResponse.indexOf("field1");
                String newResponse1=newResponse.substring(index2+8);
                String[] sentences = newResponse1.split("\\,");
                textView3.setText(sentences[0]);

                int index3=newResponse.indexOf("field2");
                String newResponse2=newResponse.substring(index3+8);
                String[] sentences2 = newResponse2.split("\\,");
                textView4.setText(sentences2[0]);

                int index4=newResponse.indexOf("field3");
                String newResponse3=newResponse.substring(index4+8);
                String[] sentences3 = newResponse3.split("\\}");
                textView5.setText(sentences3[0]);




                //Object obj = new JSONParser.parse(response.toString());
                /*JSONObject srk = response.get;
                String Temp = (String) srk.get("field1");*/



                Toast.makeText(getApplicationContext(), "Response :" + response.toString(), Toast.LENGTH_LONG).show();//display the response on screen

            }

        }, new Response.ErrorListener() {

            @Override

            public void onErrorResponse(VolleyError error) {

                Log.i(TAG, "Error :" + error.toString());

            }

        });



        mRequestQueue.add(mStringRequest);

    }



}