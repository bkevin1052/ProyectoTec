package com.proyectotec.kevin.proyectotec;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Preference.PreferenceManager;
import clases.Producto;

public class SalsasActivity extends AppCompatActivity {

    RecyclerView recyclerViewProductos;
    AdapterProducto adapter;
    List<Producto> listaSalsas = new ArrayList<>();
    Date fecha = new Date();

    //Simulacion de objetos o base de datos
    Producto salsa1 = new Producto("Salsas",10.00,"Kerns","16oz",0,fecha.toString(),R.drawable.kerns);
    Producto salsa2 = new Producto("Salsas",12.00,"Heinz","16oz",0,fecha.toString(),R.drawable.heinz);
    Producto salsa3 = new Producto("Salsas",15.00,"McCormick","16oz",0,fecha.toString(),R.drawable.mccormink);
    Producto salsa4 = new Producto("Salsas",11.00,"B&B","16oz",0,fecha.toString(),R.drawable.byb);

    public static double totalPrecioSalsas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salsas);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        listaSalsas.add(salsa1);
        listaSalsas.add(salsa2);
        listaSalsas.add(salsa3);
        listaSalsas.add(salsa4);

        recyclerViewProductos = (RecyclerView)findViewById(R.id.RecyclerViewSalsas);
        recyclerViewProductos.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AdapterProducto(this,listaSalsas);
        adapter.setOnClickListener(view -> {
                totalPrecioSalsas += listaSalsas.get(recyclerViewProductos.getChildAdapterPosition(view)).getPrecio();
                NuevaListaActivity.Listas.get(NuevaListaActivity.contadorListas).add(listaSalsas.get(recyclerViewProductos.getChildAdapterPosition(view)));
                Toast.makeText(getApplicationContext(), "ELEMENTO AGREGADO CORRECTAMENTE", Toast.LENGTH_SHORT).show();
        });
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
        if(id==R.id.menu_cerrarSesion)
        {
            PreferenceManager.delPref(getApplicationContext(),PreferenceManager.PREF_USERNAME);
            PreferenceManager.delPref(getApplicationContext(), PreferenceManager.PREF_PASSWORD);
            startActivity(new Intent(SalsasActivity.this,PrincipalActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == event.KEYCODE_BACK) {
            startActivity(new Intent(SalsasActivity.this,CategoriasActivity.class));
        }
        return super.onKeyDown(keyCode, event);
    }
}
