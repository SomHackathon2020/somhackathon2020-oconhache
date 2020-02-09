package com.example.oconh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

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
                //tv1.setText("La edad de " + lv1.getItemAtPosition(i) + " es " + edades[i] + " años" );
            }
        });
    }
    private ArrayList<Entidad> GeTarrayItems(){
        ArrayList<Entidad> listItems=new ArrayList<>();
        //listItems.add(new Entidad(id foto,titulo, descripcion))
        return listItems;
    }

}

