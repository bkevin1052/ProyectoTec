package com.proyectotec.kevin.proyectotec;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import clases.Producto;

public class ListaActivity extends AppCompatActivity {

    RecyclerView recyclerViewLista;
    AdapterProducto adapter;
    TextView carreta;
    TextView total;
    public static double precioTemp;
    public static List<Producto> listaTemporalCarreta  = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        carreta = (TextView)findViewById(R.id.carreta);
        total = (TextView)findViewById(R.id.total);

        recyclerViewLista = (RecyclerView)findViewById(R.id.RecyclerViewListaProductos);
        recyclerViewLista.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AdapterProducto(this,BuscarListaActivity.listaTemporalDos);
        recyclerViewLista.setAdapter(adapter);

        adapter.setOnClickListener(view -> {
            precioTemp += BuscarListaActivity.listaTemporalDos.get(recyclerViewLista.getChildAdapterPosition(view)).getPrecio();
            listaTemporalCarreta.add(BuscarListaActivity.listaTemporalDos.remove(recyclerViewLista.getChildAdapterPosition(view)));
            Toast.makeText(getApplicationContext(),"ELEMENTO AGREGADO A CARRETA" ,Toast.LENGTH_LONG).show();
            adapter.eliminar(BuscarListaActivity.listaTemporalDos);
            recyclerViewLista.setAdapter(adapter);
            total.setText("TOTAL: Q " + String.valueOf(precioTemp));
        });

        carreta.setOnClickListener(view -> {
            startActivity(new Intent(ListaActivity.this,ProductosEnCarretaActivity.class));
        });


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
            startActivity(new Intent(ListaActivity.this,PrincipalActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}
