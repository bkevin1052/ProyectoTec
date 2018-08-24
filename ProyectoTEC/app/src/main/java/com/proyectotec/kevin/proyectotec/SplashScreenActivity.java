package com.proyectotec.kevin.proyectotec;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreenActivity extends Activity {

    ImageView imagen;
    TextView superior,inferior;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        imagen = (ImageView)findViewById(R.id.logoImagen);
        superior = (TextView)findViewById(R.id.tituloSuperior);
        inferior = (TextView)findViewById(R.id.tituloInferior);

        Animation animation = AnimationUtils.loadAnimation(this,R.anim.up_to_down);

        imagen.setAnimation(animation);
        superior.setAnimation(animation);
        inferior.setAnimation(animation);

        new Handler().postDelayed(() -> startActivity(new Intent(SplashScreenActivity.this,PrincipalActivity.class)),5300);
    }
}
