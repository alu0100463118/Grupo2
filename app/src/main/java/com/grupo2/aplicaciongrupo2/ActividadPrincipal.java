package com.grupo2.aplicaciongrupo2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Clase que representa la actividad principal de la aplicación
 * Permite seleccionar el tipo de sensor del que queremos obtener información
 * y lanzar la actividad correspondiente.
 * @author   Bianney Cabrera, Joshua García, Hilario Pérez y Antonio Suárez
 * @version  1.0
 */

public class ActividadPrincipal extends Activity {

    /**
     * Método que crea el hilo principal de la actividad
     * @param savedInstanceState Representa un buffer en el que se guarda el estado de la aplicación
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_principal);
    }

    /**
     * Método que se ejecuta al lanzar la actividad.
     * @param v El parámetro v representa la vista asociada a esta actividad
     */
    public void lanzar_Termometro(View v) {
        startActivity(new Intent(getApplicationContext(), Termometro.class));
    }

    /**
     * Método encargado de lanzar la actividad relativa al sensor de pulsómetro
     * @param v El parámetro v representa la vista asociada a esta actividad
     */
    public void lanzar_Pulsometro(View v) {
        startActivity(new Intent(getApplicationContext(), Pulsometro.class));
    }

    /**
     * Método encargado de lanzar la actividad relativa al sensor de luz
     * @param v El parámetro v representa la vista asociada a esta actividad
     */
    public void lanzar_Luz(View v) {
        startActivity(new Intent(getApplicationContext(), Luz.class));
    }

    public void lanzar_Acelerometro(View v) {
        startActivity(new Intent(getApplicationContext(), Acelerometro.class));
    }

    public void lanzar_Giroscopio(View v) {
        startActivity(new Intent(getApplicationContext(), Giroscopio.class));
    }

    public void lanzar_Humedad(View v) {
        startActivity(new Intent(getApplicationContext(), HumedadActivity.class));
    }

    public void lanzar_Magnometro(View v) {
        startActivity(new Intent(getApplicationContext(), MagnometroActivity.class));
    }

    public void lanzar_Proximidad(View v) {
        startActivity(new Intent(getApplicationContext(), ProximidadActivity.class));
    }

    public void lanzar_Podometro(View v) {
        startActivity(new Intent(getApplicationContext(), Podometro.class));
    }
}
