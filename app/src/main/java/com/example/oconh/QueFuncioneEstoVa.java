package com.example.oconh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class QueFuncioneEstoVa extends AppCompatActivity {


    private ListView lv1;
    private  String eventos []={};
    private  String info []={};
    private Adaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_que_funcione_esto_va);

        lv1 = (ListView)findViewById(R.id.lv1);

        adaptador =new Adaptador(this, GeTarrayItems());

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.list_item_evento,eventos);
        lv1.setAdapter(adaptador);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(getApplicationContext(),eventDetails.class);
                Entidad event = EventService.getInstance().getEvents().get(i);
                intent.putExtra("day",event.getDay() );
                intent.putExtra("hour",event.getHour() );
                intent.putExtra("tema",event.getTema() );
                intent.putExtra("description",event.getDescription() );
                intent.putExtra("place",event.getPlace() );
                startActivity(intent);
            }
        });
    }


    private ArrayList<Entidad> GeTarrayItems(){
        ArrayList events = EventService.getInstance().getEvents();
        return events;
        /*
        ArrayList<Entidad> listItems=new ArrayList<>();
        listItems.add(new Entidad("Dia 12","Quedada","22","Bcn","Programacion"));
        listItems.add(new Entidad("Dia 21","Informacion","22","Bcn","Programacion"));
        listItems.add(new Entidad("Dia 14","Quedada","22","Bcn","Programacion"));
        listItems.add(new Entidad("Dia 15","Quedada","22","Bcn","Programacion"));
        listItems.add(new Entidad("Dia 190","Quedada","22","Bcn","Programacion"));
        return listItems;

         */
    }

}

