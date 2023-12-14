package com.example.pizzeria;

import static androidx.core.content.ContextCompat.startActivity;


import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import Modelo.Servicio;


public class MyAdapter extends RecyclerView.Adapter{

    private List mDataset;
    private Context context;

    public MyAdapter(Context c) {
        this.context = c;
        mDataset = new ArrayList();
    }

    public void add(Item i) {
        mDataset.add(i);
        notifyItemInserted(mDataset.indexOf(i));
    }

    public void remove(Item item) {
        int position = mDataset.indexOf(item);

        if(position != -1) {
            mDataset.remove(position);
            notifyItemRemoved(position);
        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final Item item = (Item) mDataset.get(position);
        ViewHolder hold = (ViewHolder) holder;
        //hold.imageView.setImageDrawable(item.getImageSrc());
        hold.mTextView.setText(item.getName());
        Servicio servicio = new Servicio(context);;




        if(hold.mTextView.getText().toString().equals("Rojo")){
            hold.imageView.setBackgroundColor(Color.parseColor("#ffcc0000"));
        }
        if(hold.mTextView.getText().toString().equals("Verde")){

            hold.imageView.setBackgroundColor(Color.parseColor("#ff669900"));
        }
        if(hold.mTextView.getText().toString().equals("Azul")){

            hold.imageView.setBackgroundColor(Color.parseColor("#ff0099cc"));
        }
        if(hold.mTextView.getText().toString().equals("Negro")){

            hold.imageView.setBackgroundColor(Color.parseColor("#ff000000"));
        }
        if(hold.mTextView.getText().toString().equals("Morado")){

            hold.imageView.setBackgroundColor(Color.parseColor("#ffaa66cc"));
        }

        if(hold.mTextView.getText().toString().equals("Blanco")){

            hold.imageView.setBackgroundColor(Color.parseColor("#ffffffff"));
        }


        hold.mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if(hold.mTextView.getText().toString().equals("Rojo")){
                    ActivityAHeredar.colorFondo = android.R.color.holo_red_dark;
                    SharedPreferences preferencias = context.getSharedPreferences("ultimoColor", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferencias.edit();
                    editor.putString("ultimoColor", hold.mTextView.getText().toString() );
                    editor.apply();

                }
                if(hold.mTextView.getText().toString().equals("Verde")){
                    ActivityAHeredar.colorFondo = android.R.color.holo_green_dark;
                    SharedPreferences preferencias = context.getSharedPreferences("ultimoColor", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferencias.edit();
                    editor.putString("ultimoColor", hold.mTextView.getText().toString() );
                    editor.apply();
                }
                if(hold.mTextView.getText().toString().equals("Azul")){
                    ActivityAHeredar.colorFondo = android.R.color.holo_blue_dark;
                    SharedPreferences preferencias = context.getSharedPreferences("ultimoColor", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferencias.edit();
                    editor.putString("ultimoColor", hold.mTextView.getText().toString() );
                    editor.apply();
                }
                if(hold.mTextView.getText().toString().equals("Negro")){
                    ActivityAHeredar.colorFondo = android.R.color.black;
                    SharedPreferences preferencias = context.getSharedPreferences("ultimoColor", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferencias.edit();
                    editor.putString("ultimoColor", hold.mTextView.getText().toString() );
                    editor.apply();
                }
                if(hold.mTextView.getText().toString().equals("Morado")){
                    ActivityAHeredar.colorFondo = android.R.color.holo_purple;
                    SharedPreferences preferencias = context.getSharedPreferences("ultimoColor", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferencias.edit();
                    editor.putString("ultimoColor", hold.mTextView.getText().toString() );
                    editor.apply();
                }

                if(hold.mTextView.getText().toString().equals("Blanco")){
                    ActivityAHeredar.colorFondo = android.R.color.white;
                    SharedPreferences preferencias = context.getSharedPreferences("ultimoColor", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferencias.edit();
                    editor.putString("ultimoColor", hold.mTextView.getText().toString() );
                    editor.apply();
                }

                Intent i = new Intent(context, ActivityMenu.class);
                i.putExtra("usuario", servicio.obtenerUltimoUsuarioIniciado().getUsuario());
                context.startActivity(i);

            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView mTextView;

        public ViewHolder(View v) {
            super(v);
            imageView = (ImageView) v.findViewById(R.id.ivItem);
            mTextView = (TextView) v.findViewById(R.id.tvItem);

        }
    }

}
