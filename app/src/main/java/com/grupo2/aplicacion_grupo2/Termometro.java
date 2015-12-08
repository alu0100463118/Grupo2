package com.grupo2.aplicacion_grupo2;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Clase que utiliza el sensor de temperatura del dispositivo y muestra por pantalla el valor obtenido
 * @author   Bianney Cabrera, Joshua García, Hilario Pérez y Antonio Suárez
 * @version  1.0
 */
public class Termometro extends AppCompatActivity implements SensorEventListener {

    // Declaracion de las variables que vamos a utilizar

    private TextView textoTemperaturaC, textoTemperaturaK, textoTemperaturaF ;
    private SensorManager mSensorManager;
    private Sensor mTemperature;
    private final static String falloSensor = "Tu dispositivo no tiene el sensor de temperatura.";

    /**
     * Método que se ejecuta al lanzar la actividad.
     * Inicializa el Sensor, el SensorManager y establece un mensaje de error si no
     * se encuentra el sensor de temperatura.
     * @param savedInstanceState Representa un buffer en el que se guarda el estado de la aplicación
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_termometro);

        // Asignamos los textViews que declaramos en el fichero activity_main a los que declaramos

        textoTemperaturaC = (TextView) findViewById(R.id.texto);
        textoTemperaturaK = (TextView) findViewById(R.id.textoKelvin);
        textoTemperaturaF = (TextView) findViewById(R.id.textoFarenheit);

        // Seleccionamos el sensor que lee la temperatura

        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        mTemperature= mSensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);

        // Si no detectamos el sensor, mostramos el mensaje de fallo

        if (mTemperature == null) {
            textoTemperaturaK.setText(falloSensor);
        }
    }

    /**
     * Método que recoge el valor que detecta el sensor y lo actualiza en los TextViews cada vez que
     * se detecta un cambio en el sensor.
     * @param event Parámetro que representa un cambio en el sensor de luz.
     */
    @Override
    public void onSensorChanged(SensorEvent event) {
        float temperatura = event.values[0];
        textoTemperaturaC.setText("Temperatura 1: " + String.valueOf(temperatura) + "ºC");
        textoTemperaturaK.setText("Temperatura 2: " + String.valueOf(temperatura + 273.15) + "ºK");
        textoTemperaturaF.setText("Temperatura 3: " + String.valueOf((temperatura * 1.8) + 32) + "ºF");
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {}
}
