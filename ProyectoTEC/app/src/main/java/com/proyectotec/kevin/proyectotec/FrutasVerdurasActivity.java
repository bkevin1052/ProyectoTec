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

public class FrutasVerdurasActivity extends AppCompatActivity {

    RecyclerView recyclerViewProductos;
    AdapterProducto adapter;

    List<Producto> listaFrutasVerduras = new ArrayList<>();
    Date fecha = new Date();

    //Simulacion de objetos o base de datos
    Producto fruta1 = new Producto("Frutas y Verduras",10.00,"Manzana","5oz",0,fecha.toString(),R.drawable.manzana);
    Producto fruta2 = new Producto("Frutas y Verduras",12.00,"Banano","32oz",0,fecha.toString(),R.drawable.banano);
    Producto fruta3 = new Producto("Frutas y Verduras",15.00,"Guayaba","5oz",0,fecha.toString(),R.drawable.guayaba);
    Producto fruta4 = new Producto("Frutas y Verduras",11.00,"Sandia","64oz",0,fecha.toString(),R.drawable.sandia);

    public static double totalPrecioFrutaVerdura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frutas_verduras);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        listaFrutasVerduras.add(fruta1);
        listaFrutasVerduras.add(fruta2);
        listaFrutasVerduras.add(fruta3);
        listaFrutasVerduras.add(fruta4);


        recyclerViewProductos = (RecyclerView)findViewById(R.id.RecyclerViewFrutaVerdura);
        recyclerViewProductos.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AdapterProducto(this,listaFrutasVerduras);
        adapter.setOnClickListener(view -> {
            totalPrecioFrutaVerdura += listaFrutasVerduras.get(recyclerViewProductos.getChildAdapterPosition(view)).getPrecio();
            NuevaListaActivity.Listas.get(NuevaListaActivity.contadorListas).add(listaFrutasVerduras.get(recyclerViewProductos.getChildAdapterPosition(view)));
            Toast.makeText(getApplicationContext(),"ELEMENTO AGREGADO CORRECTAMENTE" ,Toast.LENGTH_SHORT).show();
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
            startActivity(new Intent(FrutasVerdurasActivity.this,PrincipalActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == event.KEYCODE_BACK) {
            startActivity(new Intent(FrutasVerdurasActivity.this,MiListaActivity.class));
        }
        return super.onKeyDown(keyCode, event);
    }
}
