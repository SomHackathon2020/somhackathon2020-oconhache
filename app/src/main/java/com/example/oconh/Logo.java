package com.example.oconh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Logo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);


        String entrado="";
        Intent ii=new Intent(getApplicationContext(), MainActivity.class);
        ii.putExtra("name", entrado);
        try {
            Thread.sleep(1200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        startActivity(ii);

    }
}
