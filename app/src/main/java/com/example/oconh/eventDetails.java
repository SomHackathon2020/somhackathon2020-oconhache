package com.example.oconh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class eventDetails extends AppCompatActivity {

    private TextView textView_tema;
    private TextView textView_dia;
    private TextView textView_hora;
    private TextView textView_place;
    private TextView textView_people;
    private TextView textView_puntuation;
    private TextView textView_description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        String tema = getIntent().getStringExtra("tema");
        String description = getIntent().getStringExtra("description");
        String hour = getIntent().getStringExtra("hour");
        String day = getIntent().getStringExtra("day");
        String place = getIntent().getStringExtra("place");

        textView_tema = findViewById(R.id.temaGeneralDetails);
        textView_dia = findViewById(R.id.day_value);
        textView_hora = findViewById(R.id.hour_value);
        textView_place = findViewById(R.id.lugar_value);
        textView_people= findViewById(R.id.people_value);
        textView_puntuation = findViewById(R.id.puntuation_value);
        textView_description = findViewById(R.id.description);

        textView_tema.setText(tema);
        textView_dia.setText(day);
        textView_hora.setText(hour);
        textView_place.setText(place);
        textView_people.setText("20");
        textView_puntuation.setText("7");
        textView_description.setText(description);
    }
}
