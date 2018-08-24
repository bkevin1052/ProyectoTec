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
import android.widget.TextView;

import Preference.PreferenceManager;

public class ProductosEnCarretaActivity extends AppCompatActivity {

    RecyclerView recyclerViewProductosEnCarreta;
    AdapterProducto adapter;
    TextView total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos_en_carreta);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        total = (TextView)findViewById(R.id.total);
        recyclerViewProductosEnCarreta = (RecyclerView)findViewById(R.id.RecyclerViewListaProductos);
        recyclerViewProductosEnCarreta.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AdapterProducto(this,ListaActivity.listaTemporalCarreta);
        recyclerViewProductosEnCarreta.setAdapter(adapter);

        total.setText("Total Carreta(Aprox): Q " + ListaActivity.precioTemp);


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
            startActivity(new Intent(ProductosEnCarretaActivity.this,PrincipalActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == event.KEYCODE_BACK) {
            startActivity(new Intent(ProductosEnCarretaActivity.this,ListaActivity.class));
        }
        return super.onKeyDown(keyCode, event);
    }
}
