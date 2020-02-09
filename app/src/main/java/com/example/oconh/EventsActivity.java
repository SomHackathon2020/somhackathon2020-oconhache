package com.example.oconh;

import android.content.Intent;
import android.os.Bundle;
import android.util.EventLog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EventsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        /*
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_creator);
        aceptarButtonCreator=findViewById(R.id.aceptarButton);
        aceptarButtonCreator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),QueFuncioneEstoVa.class);
                startActivity(intent);
            }
        });
         */
    }


}
