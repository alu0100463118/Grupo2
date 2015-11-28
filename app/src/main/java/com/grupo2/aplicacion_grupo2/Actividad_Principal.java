package com.grupo2.aplicacion_grupo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Actividad_Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_principal);
    }

    public void lanzar_Termometro(View v) {
        Button button = (Button) v;
        startActivity(new Intent(getApplicationContext(), Termometro.class));
    }

    public void lanzar_Pulsometro(View v) {
        Button button = (Button) v;
        startActivity(new Intent(getApplicationContext(), Pulsometro.class));
    }

    public void lanzar_Luz(View v) {
        Button button = (Button) v;
        startActivity(new Intent(getApplicationContext(), Luz.class));
    }
}
