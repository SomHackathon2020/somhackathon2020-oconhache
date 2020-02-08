package com.example.oconh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Logo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String entrado="";
        Intent ii=new Intent(getApplicationContext(), MainActivity.class);
        ii.putExtra("name", entrado);
        startActivity(ii);

    }
}
