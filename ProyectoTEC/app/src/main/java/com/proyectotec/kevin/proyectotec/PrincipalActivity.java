package com.proyectotec.kevin.proyectotec;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        //Inicia sesion y lleva al activity Menu
        TextView sesion =(TextView)findViewById(R.id.iniciarSesion);
        //Asigna un clicklistener al activity Menu
        sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Crea un intent para abrir {@link MenuActivity}
                Intent sesionIntent = new Intent(PrincipalActivity.this,MenuActivity.class );
                //Inicia un nuevo activity
                startActivity(sesionIntent);
            }
        });

    }

}
