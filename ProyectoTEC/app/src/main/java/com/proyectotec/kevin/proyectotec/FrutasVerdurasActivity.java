package com.proyectotec.kevin.proyectotec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import clases.Producto;

public class FrutasVerdurasActivity extends AppCompatActivity {

    RecyclerView recyclerViewProductos;
    AdapterProducto adapter;

    List<Producto> listaFrutasVerduras = new ArrayList<>();
    Date fecha;

    //Simulacion de objetos o base de datos
    Producto fruta1 = new Producto("Frutas y Verduras",10.00,"Manzana","5oz",0,fecha);
    Producto fruta2 = new Producto("Frutas y Verduras",12.00,"Banano","32oz",0,fecha);
    Producto fruta3 = new Producto("Frutas y Verduras",15.00,"Guayaba","5oz",0,fecha);
    Producto fruta4 = new Producto("Frutas y Verduras",11.00,"Sandia","64oz",0,fecha);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frutas_verduras);

        listaFrutasVerduras.add(fruta1);
        listaFrutasVerduras.add(fruta2);
        listaFrutasVerduras.add(fruta3);
        listaFrutasVerduras.add(fruta4);


        recyclerViewProductos = (RecyclerView)findViewById(R.id.RecyclerView);
        recyclerViewProductos.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AdapterProducto(this,listaFrutasVerduras);
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
            startActivity(new Intent(FrutasVerdurasActivity.this,EnviarListaActivity.class));

        }
        return super.onOptionsItemSelected(item);
    }
}
