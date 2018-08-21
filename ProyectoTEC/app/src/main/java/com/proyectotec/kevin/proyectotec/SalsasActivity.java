package com.proyectotec.kevin.proyectotec;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import clases.Producto;

public class SalsasActivity extends AppCompatActivity {

    RecyclerView recyclerViewProductos;
    AdapterProducto adapter;

    List<Producto> listaSalsas = new ArrayList<>();
    Date fecha;

    //Simulacion de objetos o base de datos
    Producto salsa1 = new Producto("Salsas",10.00,"Kerns","16oz",0,fecha);
    Producto salsa2 = new Producto("Salsas",12.00,"Heinz","16oz",0,fecha);
    Producto salsa3 = new Producto("Salsas",15.00,"McCormick","16oz",0,fecha);
    Producto salsa4 = new Producto("Salsas",11.00,"B&B","16oz",0,fecha);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salsas);
        listaSalsas.add(salsa1);
        listaSalsas.add(salsa2);
        listaSalsas.add(salsa3);
        listaSalsas.add(salsa4);

        recyclerViewProductos = (RecyclerView)findViewById(R.id.RecyclerView);
        recyclerViewProductos.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AdapterProducto(this,listaSalsas);
        recyclerViewProductos.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public  boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id==R.id.menu_acerca){

        }
        if(id==R.id.menu_configuracion){

        }
        if(id==R.id.menu_contacto){

        }
        if(id==R.id.menu_compartir){
            startActivity(new Intent(SalsasActivity.this,EnviarListaActivity.class));

        }
        return super.onOptionsItemSelected(item);
    }
}
