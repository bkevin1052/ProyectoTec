package com.proyectotec.kevin.proyectotec;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

public class ModificarListaActivity extends AppCompatActivity {

    RecyclerView recyclerViewModificarListas;
    AdapterListas adapter;

    EditText buscadorM;

    public static List<Producto> listaTemporal = new ArrayList<>();
    public static int numeroLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_lista);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerViewModificarListas = (RecyclerView) findViewById(R.id.RecyclerViewModificarLista);
        recyclerViewModificarListas.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AdapterListas(this, NuevaListaActivity.Listas, NuevaListaActivity.nombreLista);
        recyclerViewModificarListas.setAdapter(adapter);

        adapter.setOnClickListener(view -> {
            numeroLista = recyclerViewModificarListas.getChildAdapterPosition(view);
            listaTemporal= NuevaListaActivity.Listas.get(recyclerViewModificarListas.getChildAdapterPosition(view));
            startActivity(new Intent(ModificarListaActivity.this,VistaModificarLista.class));

        });
        buscadorM = (EditText)findViewById(R.id.idBuscaListaM);

        buscadorM.addTextChangedListener(new TextWatcher() {
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
            startActivity(new Intent(ModificarListaActivity.this,PrincipalActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == event.KEYCODE_BACK) {
            startActivity(new Intent(ModificarListaActivity.this,MiListaActivity.class));
        }
        return super.onKeyDown(keyCode, event);
    }
}
