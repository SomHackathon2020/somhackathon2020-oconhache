package com.example.oconh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class eventCreator extends AppCompatActivity {
    private TextView eventCreationTitleCreator;
    private TextView temaGeneralCreator;
    private TextView tituloTemaCreator;
    private TextView descriptionCreator;
    private TextView eventDataCreator;
    private TextView diaCreator;
    private TextView horaCreator;
    private TextView lugarCreator;
    private Button aceptarButtonCreator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_creator);



    }
}
