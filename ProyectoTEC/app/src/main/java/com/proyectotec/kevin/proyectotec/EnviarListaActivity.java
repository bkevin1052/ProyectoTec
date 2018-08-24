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

import java.util.List;

import Preference.PreferenceManager;
import clases.Producto;

public class EnviarListaActivity extends AppCompatActivity {


    RecyclerView recyclerViewListas;
    AdapterEnviarLista adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enviar_lista);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        recyclerViewListas = (RecyclerView)findViewById(R.id.RecyclerViewEnviarLista);
        recyclerViewListas.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AdapterEnviarLista(this,NuevaListaActivity.Listas,NuevaListaActivity.nombreLista);
        recyclerViewListas.setAdapter(adapter);

        adapter.setOnClickListener(view -> {
            Intent compartir = new Intent(Intent.ACTION_SEND);
            List<Producto> tempLista = NuevaListaActivity.Listas.get(recyclerViewListas.getChildAdapterPosition(view));
            compartir.setType("text/plain");
            compartir.putExtra(Intent.EXTRA_SUBJECT,"LISTA: " + NuevaListaActivity.nombreLista.get(recyclerViewListas.getChildAdapterPosition(view)));

            String listaCompartir = "";
            for (int i =0; i< tempLista.size();i++){
                Producto tempProducto = tempLista.get(i);
                listaCompartir += "\n\n*Categoria: " +tempProducto.getCategoria() +"\n"+
                        "Marca: " + tempProducto.getMarca() +"\n"+
                        "Precio: q" + tempProducto.getPrecio() +"\n"+
                        "Tamaño: " + tempProducto.getTamanio();
            }
            compartir.putExtra(Intent.EXTRA_TEXT, listaCompartir.toString());
            startActivity(Intent.createChooser(compartir,"Compartir"));
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
            PreferenceManager.delPref(getApplicationContext(),PreferenceManager.PREF_USERNAME);
            PreferenceManager.delPref(getApplicationContext(), PreferenceManager.PREF_PASSWORD);
            startActivity(new Intent(EnviarListaActivity.this,PrincipalActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == event.KEYCODE_BACK) {
            startActivity(new Intent(EnviarListaActivity.this,MiListaActivity.class));
        }
        return super.onKeyDown(keyCode, event);
    }
}
