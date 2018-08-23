package com.proyectotec.kevin.proyectotec;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class ProductosEnCarretaActivity extends AppCompatActivity {

    RecyclerView recyclerViewProductosEnCarreta;
    AdapterProducto adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos_en_carreta);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerViewProductosEnCarreta = (RecyclerView)findViewById(R.id.RecyclerViewListaProductos);
        recyclerViewProductosEnCarreta.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AdapterProducto(this,ListaActivity.listaTemporalCarreta);
        recyclerViewProductosEnCarreta.setAdapter(adapter);


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
            finish();
            startActivity(new Intent(ProductosEnCarretaActivity.this,PrincipalActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}
