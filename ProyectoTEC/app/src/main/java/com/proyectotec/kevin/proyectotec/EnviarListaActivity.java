package com.proyectotec.kevin.proyectotec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class EnviarListaActivity extends AppCompatActivity {


    RecyclerView recyclerViewListas;
    AdapterListas adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enviar_lista);

        recyclerViewListas = (RecyclerView)findViewById(R.id.RecyclerView);
        recyclerViewListas.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AdapterListas(this,NuevaListaActivity.Listas,NuevaListaActivity.nombreLista);
        recyclerViewListas.setAdapter(adapter);
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
            startActivity(new Intent(EnviarListaActivity.this,EnviarListaActivity.class));

        }
        return super.onOptionsItemSelected(item);
    }
}
