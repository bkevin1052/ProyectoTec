package com.proyectotec.kevin.proyectotec;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MiListaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_lista);

        //Lleva al activity  Nueva Lista
        TextView opcion11 =(TextView)findViewById(R.id.menuNuevaLista);
        //Asigna un clicklistener al activity Nueva Lista
        opcion11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Crea un intent para abrir {@link NuevaListaActivity}
                Intent opcion1_1Intent = new Intent(MiListaActivity.this, NuevaListaActivity.class );
                //Inicia el activity Nueva Lista
                startActivity(opcion1_1Intent);
            }
        });

        //Lleva al activity  Modificar Lista
        TextView opcion12 =(TextView)findViewById(R.id.menuModificarLista);
        //Asigna un clicklistener al activity Modificar Lista
        opcion12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Crea un intent para abrir {@link ModificarListaActivity}
                Intent opcion12Intent = new Intent(MiListaActivity.this, ModificarListaActivity.class );
                //Inicia el activity Modificar Lista
                startActivity(opcion12Intent);
            }
        });

        //Lleva al activity  Enviar Lista
        TextView opcion13 =(TextView)findViewById(R.id.menuEnviarLista);
        //Asigna un clicklistener al activity Enviar Lista
        opcion13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Crea un intent para abrir {@link EnviarListaActivity}
                Intent opcion13Intent = new Intent(MiListaActivity.this, EnviarListaActivity.class );
                //Inicia el activity Nueva Lista
                startActivity(opcion13Intent);
            }
        });


    }
}
