package com.proyectotec.kevin.proyectotec;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //Lleva al activity Mi Lista
        TextView opcion1 =(TextView)findViewById(R.id.menuMiLista);
        //Asigna un clicklistener al activity Mi Lista
        opcion1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Crea un intent para abrir {@link MiListaActivity}
                Intent opcion1Intent = new Intent(MenuActivity.this, MiListaActivity.class );
                //Inicia el activity Mi Lista
                startActivity(opcion1Intent);
            }
        });

        //Lleva al activity Ubicacion
        TextView opcion2 =(TextView)findViewById(R.id.menuUbicacion);
        //Asigna un clicklistener al activity Ubicacion
        opcion2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Crea un intent para abrir {@link UbicacionActivity}
                Intent opcion2Intent = new Intent(MenuActivity.this, UbicacionActivity.class );
                //Inicia el activity Ubicacion
                startActivity(opcion2Intent);
            }
        });

        //Lleva al activity Ofertas
        TextView opcion3 =(TextView)findViewById(R.id.menuOfertas);
        //Asigna un clicklistener al activity Ofertas
        opcion3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Crea un intent para abrir {@link OfertasActivity}
                Intent opcion3Intent = new Intent(MenuActivity.this, OfertasActivity.class );
                //Inicia el activity Ofertas
                startActivity(opcion3Intent);
            }
        });
    }
}
