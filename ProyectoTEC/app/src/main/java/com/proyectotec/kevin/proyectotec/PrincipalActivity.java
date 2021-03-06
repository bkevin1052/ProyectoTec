package com.proyectotec.kevin.proyectotec;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import Preference.PreferenceManager;

public class PrincipalActivity extends AppCompatActivity {

    //public static List<List> ListasUsuario = new ArrayList<>();
    TextView inicioSesion,registro;
    EditText user, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        //Inicia sesion y lleva al activity Menu
        inicioSesion =(TextView)findViewById(R.id.iniciarSesion);
        user = (EditText)findViewById(R.id.idUsuario);
        password = (EditText)findViewById(R.id.idPassword);
        registro = (TextView)findViewById(R.id.registroUsuario);

        //Asigna un clicklistener al activity Menu
        if((PreferenceManager.checkPref(this,PreferenceManager.PREF_USERNAME)) && (PreferenceManager.checkPref(this,PreferenceManager.PREF_PASSWORD)))
        {
            Intent _LogIn = new Intent(PrincipalActivity.this, MenuActivity.class);
            startActivity(_LogIn);
        }
        else {
            //if ((RegistroActivity.nuevoUsuario.getUserName() == PreferenceManager.PREF_USERNAME) && (RegistroActivity.nuevoUsuario.getContrasenia() == PreferenceManager.PREF_PASSWORD)) {
                inicioSesion.setOnClickListener(compoundButton -> {
                    Intent _LogOut = new Intent(PrincipalActivity.this, MenuActivity.class);
                    startActivity(_LogOut);
                    PreferenceManager.setPref(compoundButton.getContext(), PreferenceManager.PREF_USERNAME, "1");
                    PreferenceManager.setPref(compoundButton.getContext(), PreferenceManager.PREF_PASSWORD, "1");
                });
            //}else {
            //  Toast.makeText(getApplicationContext(),"Contraseña o usuario incorrecto",Toast.LENGTH_SHORT).show();
            // user.setText("");
            // password.setText("");
            // user.clearFocus();
           // }
        }
        registro.setOnClickListener(view -> {
            startActivity(new Intent(PrincipalActivity.this,RegistroActivity.class));
        });

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == event.KEYCODE_BACK) {
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

}
