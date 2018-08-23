package com.proyectotec.kevin.proyectotec;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class VistaModificarLista extends AppCompatActivity {

    RecyclerView recyclerViewModificarLista;
    AdapterProducto adapter;
    TextView eliminar,agregar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_modificar_lista);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        eliminar = (TextView)findViewById(R.id.eliminarLista);
        agregar = (TextView)findViewById(R.id.agregarLista);
        recyclerViewModificarLista = (RecyclerView)findViewById(R.id.RecyclerViewModificarProductos);
        recyclerViewModificarLista.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AdapterProducto(this,ModificarListaActivity.listaTemporal);
        recyclerViewModificarLista.setAdapter(adapter);

        eliminar.setOnClickListener(view -> {
            AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
            dlgAlert.setMessage("Esta seguro de eliminar la lista?");
            dlgAlert.setTitle("Eliminar Lista");
            dlgAlert.setPositiveButton("SI", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    NuevaListaActivity.Listas.remove(ModificarListaActivity.numeroLista);
                    NuevaListaActivity.nombreLista.remove(ModificarListaActivity.numeroLista);
                    NuevaListaActivity.contadorListas--;
                    finish();
                    startActivity(new Intent(VistaModificarLista.this,ModificarListaActivity.class));
                }
            });
            dlgAlert.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });
            dlgAlert.setCancelable(true);
            dlgAlert.create().show();
        });

        //FALTA IMPLEMENTAR
        agregar.setOnClickListener(view -> {
            startActivity(new Intent(VistaModificarLista.this,CategoriasActivity.class));
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
            startActivity(new Intent(VistaModificarLista.this,PrincipalActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}
