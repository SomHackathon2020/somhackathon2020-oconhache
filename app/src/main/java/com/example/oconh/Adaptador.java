package com.example.oconh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {
    private Context context;

    public Adaptador(Context context, ArrayList<Entidad> listItems) {
        this.context = context;
        this.listItems = listItems;
    }

    private ArrayList<Entidad>listItems;
    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public Object getItem(int position) {
        return listItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Entidad item = (Entidad) getItem(position);

        convertView = LayoutInflater.from(context).inflate(R.layout.list_item_evento,null);
        ImageView imgFoto =convertView.findViewById(R.id.imgFoto);
        TextView titulo= convertView.findViewById(R.id.nombreEvento);
        TextView descripcion= convertView.findViewById(R.id.descripcionEvento);


        titulo.setText(item.getTema());
        descripcion.setText(item.getDescription());


        return convertView;
    }
}
