package com.example.oconh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class eventCreator extends AppCompatActivity {
    private TextView eventCreationTitle;
    private TextView temaGeneral;
    private TextView tituloTema;
    private TextView description;
    private TextView eventData;
    private TextView dia;
    private TextView hora;
    private TextView lugar;
    private Button aceptarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_creator);



    }
}
