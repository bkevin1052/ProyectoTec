package com.proyectotec.kevin.proyectotec;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class UbicacionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubicacion);

        //Lleva al activity Buscar Lista
        TextView opcionBuscar =(TextView)findViewById(R.id.opcionBuscarLista);
        //Asigna un clicklistener al activity Buscar Lista
        opcionBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Crea un intent para abrir {@link BuscarActivity}
                Intent opcionBuscarIntent = new Intent(UbicacionActivity.this, BuscarListaActivity.class );
                //Inicia el activity Mi Lista
                startActivity(opcionBuscarIntent);
            }
        });

    }
}
