package com.proyectotec.kevin.proyectotec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;

import clases.Usuario;

public class RegistroActivity extends AppCompatActivity {

    EditText nombre,usuario,contrasenia,confContrasenia;
    TextView registro;
    public static Usuario nuevoUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nombre = (EditText)findViewById(R.id.idNombre);
        usuario = (EditText)findViewById(R.id.idUsuario);
        contrasenia = (EditText)findViewById(R.id.idPassword);
        confContrasenia = (EditText)findViewById(R.id.idConfirmarPassword);
        registro = (TextView)findViewById(R.id.registrar);

        registro.setOnClickListener(view -> {
            String nNombre,nUsuario,nContrsenia;
            nNombre = nombre.getText().toString();
            nUsuario = usuario.getText().toString();
            nContrsenia = contrasenia.getText().toString();
            nuevoUsuario = new Usuario(nNombre,nUsuario,nContrsenia);
            startActivity(new Intent(RegistroActivity.this,PrincipalActivity.class));
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == event.KEYCODE_BACK) {
            startActivity(new Intent(RegistroActivity.this,PrincipalActivity.class));
        }
        return super.onKeyDown(keyCode, event);
    }
}
