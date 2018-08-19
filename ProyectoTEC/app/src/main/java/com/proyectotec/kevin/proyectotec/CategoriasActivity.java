package com.proyectotec.kevin.proyectotec;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CategoriasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);

        //Lleva al activity FrutaVerdura
        TextView menuFV =(TextView)findViewById(R.id.menuFrutasVerduras);
        //Asigna un clicklistener al activity FrutaVerdura
        menuFV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Crea un intent para abrir {@link FrutaVerduraActivity}
                Intent menuFVIntent = new Intent(CategoriasActivity.this, FrutasVerdurasActivity.class );
                //Inicia el activity FrutaVerdura
                startActivity(menuFVIntent);
            }
        });

        //Lleva al activity Salsas
        TextView menuSalsa =(TextView)findViewById(R.id.menuSalsas);
        //Asigna un clicklistener al activity Salsas
        menuSalsa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Crea un intent para abrir {@link SalsasActivity}
                Intent menuSalsaIntent = new Intent(CategoriasActivity.this, SalsasActivity.class );
                //Inicia el activity FrutaVerdura
                startActivity(menuSalsaIntent);
            }
        });


    }
}
