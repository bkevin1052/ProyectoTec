package com.proyectotec.kevin.proyectotec;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import clases.Producto;

public class AdapterProducto extends RecyclerView.Adapter<AdapterProducto.ProductoViewHolder> {

    private Context miContexto;
    private List<Producto> listaProductos;

    public AdapterProducto(Context miContexto, List<Producto> listaProductos) {
        this.miContexto = miContexto;
        this.listaProductos = listaProductos;
    }


    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(miContexto);
        View view = inflater.inflate(R.layout.costume_row,null);
        ProductoViewHolder holder = new ProductoViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position) {

        Producto producto = listaProductos.get(position);
        holder.textViewTitulo.setText(producto.getMarca());
        holder.textViewPrecio.setText(String.valueOf(producto.getPrecio()));

    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }

    class ProductoViewHolder extends RecyclerView.ViewHolder{
        TextView textViewTitulo, textViewPrecio;

        public ProductoViewHolder(View itemView) {
            super(itemView);

            textViewTitulo = itemView.findViewById(R.id.titulo);
            textViewPrecio = itemView.findViewById(R.id.precio);
        }
    }
}