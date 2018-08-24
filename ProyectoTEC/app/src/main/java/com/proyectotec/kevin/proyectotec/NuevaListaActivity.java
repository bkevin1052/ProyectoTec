package com.proyectotec.kevin.proyectotec;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import Preference.PreferenceManager;
import clases.Producto;

public class NuevaListaActivity extends AppCompatActivity {


    EditText nombreNuevaLista;
    TextView crearLista;

    //Lista a crear
    List<Producto> nuevaLista;

    //Listas creadas almacenadas
    public static List<List> Listas = new ArrayList<>();
    public static List<String> nombreLista = new ArrayList<>();
    public static int contadorListas = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_lista);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        nombreNuevaLista = (EditText)findViewById(R.id.idNombreLista);
        crearLista = (TextView)findViewById(R.id.crearLista);
        crearLista.setOnClickListener(view ->{
            String nNuevaLista = nombreNuevaLista.getText().toString();
            if(nNuevaLista.isEmpty()){
                Toast.makeText(getApplicationContext(),"No se pudo crear la lista, por favor\n" +" inserte un nombre a su lista",Toast.LENGTH_SHORT).show();
            }else {
                nuevaLista = new ArrayList<>();
                Listas.add(nuevaLista);
                nombreLista.add(nNuevaLista);
                Intent _Categorias = new Intent(NuevaListaActivity.this, CategoriasActivity.class);
                startActivity(_Categorias);
                contadorListas++;
                SalsasActivity.totalPrecioSalsas = 0;
                FrutasVerdurasActivity.totalPrecioFrutaVerdura = 0;
            }
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
            startActivity(new Intent(NuevaListaActivity.this,PrincipalActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == event.KEYCODE_BACK) {
            startActivity(new Intent(NuevaListaActivity.this,MiListaActivity.class));
        }
        return super.onKeyDown(keyCode, event);
    }
}
