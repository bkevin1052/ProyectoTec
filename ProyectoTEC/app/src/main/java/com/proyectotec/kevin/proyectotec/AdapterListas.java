package com.proyectotec.kevin.proyectotec;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class AdapterListas extends RecyclerView.Adapter<AdapterListas.ListasViewHolder> implements View.OnClickListener {

    private Context miContexto;
    private List<List> listasUsuario;
    private List<String> listasNombre;
    private View.OnClickListener listener;


    public AdapterListas(Context miContexto, List<List> listasUsuario,List<String> listasNombre) {
        this.miContexto = miContexto;
        this.listasUsuario = listasUsuario;
        this.listasNombre = listasNombre;
    }

    public void filtrarListas(List<List> listaFiltrada) {
        listasUsuario = listaFiltrada;
        notifyDataSetChanged();
    }


    @Override
    public ListasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(miContexto);
        View view = inflater.inflate(R.layout.costume_row_listas,null);
        ListasViewHolder holder = new ListasViewHolder(view);
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListasViewHolder holder, int position) {

        String listaNombre = listasNombre.get(position).toString();
        holder.textViewTitulo.setText(listaNombre);
    }

    @Override
    public int getItemCount() {
        return listasUsuario.size();
    }

    class ListasViewHolder extends RecyclerView.ViewHolder{

        TextView textViewTitulo;

        public ListasViewHolder(View itemView) {
            super(itemView);
            textViewTitulo = itemView.findViewById(R.id.titulo);
        }
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {

        if(listener!= null){
            listener.onClick(view);
        }
    }



}