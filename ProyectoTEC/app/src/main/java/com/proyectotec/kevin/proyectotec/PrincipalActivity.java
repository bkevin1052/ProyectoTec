package com.proyectotec.kevin.proyectotec;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import Preference.PreferenceManager;

public class PrincipalActivity extends AppCompatActivity {

    //public static List<List> ListasUsuario = new ArrayList<>();
    TextView InicioSesion;
    EditText user, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        //Inicia sesion y lleva al activity Menu
        InicioSesion =(TextView)findViewById(R.id.iniciarSesion);
        user = (EditText)findViewById(R.id.idUsuario);
        password = (EditText)findViewById(R.id.idPassword);


        //Asigna un clicklistener al activity Menu

        if((PreferenceManager.checkPref(this,PreferenceManager.PREF_USERNAME)) && (PreferenceManager.checkPref(this,PreferenceManager.PREF_PASSWORD)))
        {
            Intent _LogIn = new Intent(PrincipalActivity.this, MenuActivity.class);
            startActivity(_LogIn);
        }
        else {
            InicioSesion.setOnClickListener(compoundButton -> {
                Intent _LogOut = new Intent(PrincipalActivity.this, MenuActivity.class);
                startActivity(_LogOut);
                PreferenceManager.setPref(compoundButton.getContext(),PreferenceManager.PREF_USERNAME,"1");
                PreferenceManager.setPref(compoundButton.getContext(),PreferenceManager.PREF_PASSWORD,"1");
            });
        }

    }

}
