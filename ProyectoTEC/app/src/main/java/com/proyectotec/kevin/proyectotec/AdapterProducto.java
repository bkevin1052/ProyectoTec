package com.proyectotec.kevin.proyectotec;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import clases.Producto;

public class AdapterProducto extends RecyclerView.Adapter<AdapterProducto.ProductoViewHolder> implements View.OnClickListener{

    private Context miContexto;
    private List<Producto> listaProductos;
    private View.OnClickListener listener;

    public AdapterProducto(Context miContexto, List<Producto> listaProductos) {
        this.miContexto = miContexto;
        this.listaProductos = listaProductos;
    }


    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(miContexto);
        View view = inflater.inflate(R.layout.costume_row,null);
        ProductoViewHolder holder = new ProductoViewHolder(view);
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position) {

        Producto producto = listaProductos.get(position);
        holder.textViewTitulo.setText(producto.getMarca());
        holder.textViewPrecio.setText(String.valueOf(producto.getPrecio()));
        holder.textViewDetalles.setText(producto.getCategoria()+ "\n" +
        producto.getFechaCaducidad() + "\n" + producto.getTamanio());
        holder.imageView.setImageDrawable(miContexto.getResources().getDrawable(producto.getImagen()));
    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
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


    class ProductoViewHolder extends RecyclerView.ViewHolder{
        TextView textViewTitulo, textViewPrecio, textViewDetalles;

        ImageView imageView;

        public ProductoViewHolder(View itemView) {
            super(itemView);


            textViewTitulo = itemView.findViewById(R.id.titulo);
            textViewPrecio = itemView.findViewById(R.id.precio);
            imageView = itemView.findViewById(R.id.imageView);
            textViewDetalles = itemView.findViewById(R.id.detalles);
        }

    }
}
