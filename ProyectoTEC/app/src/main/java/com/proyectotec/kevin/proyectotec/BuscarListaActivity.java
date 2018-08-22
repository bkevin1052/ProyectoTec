package com.proyectotec.kevin.proyectotec;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BuscarListaActivity extends AppCompatActivity {

    RecyclerView recyclerViewListas;
    AdapterListas adapter;
    EditText buscador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_lista);

        buscador = (EditText) findViewById(R.id.idBuscaLista);

        //Lleva al activity ListaOrdenada
        TextView opcionBuscarLista =(TextView)findViewById(R.id.BuscarLista);
        //Asigna un clicklistener al activity Lista Ordenada
        opcionBuscarLista.setOnClickListener(view -> {
        });

        Button opcionVerTodasListas = (Button) findViewById(R.id.botonVerTodasLista);

        opcionVerTodasListas.setOnClickListener(view->{
            recyclerViewListas = (RecyclerView)findViewById(R.id.RecyclerViewVerTodas);
            recyclerViewListas.setLayoutManager(new LinearLayoutManager(this));
            adapter = new AdapterListas(this,NuevaListaActivity.Listas,NuevaListaActivity.nombreLista);
            recyclerViewListas.setAdapter(adapter);
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
        return super.onOptionsItemSelected(item);
    }
}
