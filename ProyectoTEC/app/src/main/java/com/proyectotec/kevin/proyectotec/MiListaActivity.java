package com.proyectotec.kevin.proyectotec;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MiListaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_lista);

        //Lleva al activity  Nueva Lista
        TextView opcion11 =(TextView)findViewById(R.id.menuNuevaLista);
        //Asigna un clicklistener al activity Nueva Lista
        opcion11.setOnClickListener(view -> {
            //Crea un intent para abrir {@link NuevaListaActivity}
            Intent opcion1_1Intent = new Intent(MiListaActivity.this, NuevaListaActivity.class );
            //Inicia el activity Nueva Lista
            startActivity(opcion1_1Intent);
        });

        //Lleva al activity  Modificar Lista
        TextView opcion12 =(TextView)findViewById(R.id.menuModificarLista);
        //Asigna un clicklistener al activity Modificar Lista
        opcion12.setOnClickListener(view -> {
            //Crea un intent para abrir {@link ModificarListaActivity}
            Intent opcion12Intent = new Intent(MiListaActivity.this, ModificarListaActivity.class );
            //Inicia el activity Modificar Lista
            startActivity(opcion12Intent);
        });

        //Lleva al activity  Enviar Lista
        TextView opcion13 =(TextView)findViewById(R.id.menuEnviarLista);
        //Asigna un clicklistener al activity Enviar Lista
        opcion13.setOnClickListener(view -> {
            //Crea un intent para abrir {@link EnviarListaActivity}
            Intent opcion13Intent = new Intent(MiListaActivity.this, EnviarListaActivity.class );
            //Inicia el activity Nueva Lista
            startActivity(opcion13Intent);
        });

        TextView opcion14 = (TextView)findViewById(R.id.menuBuscarLista);
        opcion14.setOnClickListener(view->{
            Intent opcion14Intent = new Intent(MiListaActivity.this, BuscarListaActivity.class );
            startActivity(opcion14Intent);
        });

        TextView opcion15 = (TextView)findViewById(R.id.menuFotoFactura);

        opcion15.setOnClickListener(view -> {
            Intent opcion15Intent = new Intent(MiListaActivity.this, FotoFacturaActivity.class );
            startActivity(opcion15Intent);
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
        return super.onOptionsItemSelected(item);
    }
}
