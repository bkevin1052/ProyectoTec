package com.proyectotec.kevin.proyectotec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import Preference.PreferenceManager;
import clases.Producto;

public class BuscarListaActivity extends AppCompatActivity {

    RecyclerView recyclerViewListas;
    AdapterListas adapter;
    EditText buscador;
    public static List<Producto> listaTemporalDos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_lista);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        buscador = (EditText) findViewById(R.id.idBuscaListaB);

        recyclerViewListas = (RecyclerView)findViewById(R.id.RecyclerViewVerTodas);
        recyclerViewListas.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AdapterListas(this,NuevaListaActivity.Listas,NuevaListaActivity.nombreLista);
        recyclerViewListas.setAdapter(adapter);

        adapter.setOnClickListener(view -> {
            listaTemporalDos = NuevaListaActivity.Listas.get(recyclerViewListas.getChildAdapterPosition(view));
            startActivity(new Intent(BuscarListaActivity.this,ListaActivity.class));
        });

        buscador.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                filtro(editable.toString());
            }
        });
    }

    private void filtro(String text) {
        List<List> ListaFiltrada = new ArrayList<>();

        int i =0;
        for(String item : NuevaListaActivity.nombreLista){
            if (item.contains(text.toLowerCase())) {
                ListaFiltrada.add(NuevaListaActivity.Listas.get(i));
            }
        }
        adapter.filtrarListas(ListaFiltrada);
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
            startActivity(new Intent(BuscarListaActivity.this,PrincipalActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == event.KEYCODE_BACK) {
            startActivity(new Intent(BuscarListaActivity.this,MiListaActivity.class));
        }
        return super.onKeyDown(keyCode, event);
    }
}
