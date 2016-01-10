package com.grupo2.aplicaciongrupo2;

import android.graphics.Color;
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
    private static final String FALLO_SENSOR = "Tu dispositivo no tiene el sensor de temperatura.";

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
        mSensorManager.registerListener(this, mTemperature,SensorManager.SENSOR_DELAY_NORMAL);

        // Si no detectamos el sensor, mostramos el mensaje de fallo

        if (mTemperature == null) {
            textoTemperaturaK.setText(FALLO_SENSOR);
            textoTemperaturaK.setTextColor(Color.rgb(255, 0, 0));
        }
    }

    public void temperatureSensor(SensorEvent event){
        float temperatura = event.values[0];
        String temperaturaC = String.format("%.2f", temperatura);
        String temperaturaK = String.format("%.2f", temperatura + 273.15);
        String temperaturaF = String.format("%.2f", (temperatura * 1.8) + 32);
        textoTemperaturaC.setText("Temperatura 1: " + temperaturaC + "ºC");
        textoTemperaturaK.setText("Temperatura 2: " + temperaturaK + "ºK");
        textoTemperaturaF.setText("Temperatura 3: " + temperaturaF + "ºF");
    }
    /**
     * Método que recoge el valor que detecta el sensor y lo actualiza en los TextViews cada vez que
     * se detecta un cambio en el sensor.
     * @param event Parámetro que representa un cambio en el sensor de temperatura.
     */
    @Override
    public void onSensorChanged(SensorEvent event) {

        synchronized (this){
            if (event.sensor.getType() == Sensor.TYPE_AMBIENT_TEMPERATURE){
                temperatureSensor(event);
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        //Método vacío
    }
}
