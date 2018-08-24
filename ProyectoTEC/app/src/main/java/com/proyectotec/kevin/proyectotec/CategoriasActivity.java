package com.proyectotec.kevin.proyectotec;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import Preference.PreferenceManager;

public class CategoriasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //Lleva al activity FrutaVerdura
        TextView menuFV =(TextView)findViewById(R.id.menuFrutasVerduras);
        //Asigna un clicklistener al activity FrutaVerdura
        menuFV.setOnClickListener(view -> {
            //Crea un intent para abrir {@link FrutaVerduraActivity}
            Intent menuFVIntent = new Intent(CategoriasActivity.this, FrutasVerdurasActivity.class );
            //Inicia el activity FrutaVerdura
            startActivity(menuFVIntent);
        });

        //Lleva al activity Salsas
        TextView menuSalsa =(TextView)findViewById(R.id.menuSalsas);
        //Asigna un clicklistener al activity Salsas
        menuSalsa.setOnClickListener(view -> {
            //Crea un intent para abrir {@link SalsasActivity}
            Intent menuSalsaIntent = new Intent(CategoriasActivity.this, SalsasActivity.class );
            //Inicia el activity FrutaVerdura
            startActivity(menuSalsaIntent);
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
            startActivity(new Intent(CategoriasActivity.this,PrincipalActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == event.KEYCODE_BACK) {
            startActivity(new Intent(CategoriasActivity.this,MiListaActivity.class));
        }
        return super.onKeyDown(keyCode, event);
    }
}
