package com.example.oconh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class eventCreator extends AppCompatActivity {
    public EditText event_description;
    public EditText event_day;
    public EditText event_hour;
    public EditText event_place;
    public EditText event_tema;
    private Button create_event;

    private EventService eventService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
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


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_creator);

        eventService = EventService.getInstance();

        event_day = findViewById(R.id.dia);
        event_description = findViewById(R.id.description);
        event_hour = findViewById(R.id.hora);
        event_place = findViewById(R.id.lugar);
        event_tema = findViewById(R.id.tema);
        create_event = findViewById(R.id.aceptarButton);

        create_event.setOnClickListener( new View.OnClickListener(){
            public void onClick (View v){
                try{

                    String day = event_day.getText().toString();
                    String description = event_description.getText().toString();
                    String hour = event_hour.getText().toString();
                    String place = event_place.getText().toString();
                    String tema = event_tema.getText().toString();

                    eventService.register(day,description,hour,place,tema);


                    Intent intent=new Intent(getApplicationContext(),QueFuncioneEstoVa.class);
                    //Intent intent=new Intent(getApplicationContext(),EventsActivity.class);
                    startActivity(intent);
                }catch(Exception e){

                }
            }
        });

    }
}
