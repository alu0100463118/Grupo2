package com.grupo2.aplicacion_grupo2;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.util.logging.Logger;

/**
 * Clase que utiliza el sensor de luz del dispositivo y muestra por pantalla el valor obtenido.
 * @author   Bianney Cabrera, Joshua García, Hilario Pérez y Antonio Suárez.
 * @version  1.0
 */

public class Luz extends AppCompatActivity implements SensorEventListener {

    // Declaracion de las variables que vamos a utilizar

    private TextView lightTxt;
    private SensorManager sensorManager;
    private Sensor lightSensor;
    private final static String sensorFail = "Tu dispositivo no tiene el sensor de luz";

    /**
     * Método que se ejecuta al lanzar la actividad.
     * Inicializa el SensorManager, el escuchador del sensor y establece el mensaje de error si no
     * se encuentra el sensor de luz.
     * @param savedInstanceState Representa un buffer en el que se guarda el estado de la aplicación
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luz);

        //se asigna el TextView que se declara en el activity_luz
        lightTxt = (TextView) findViewById(R.id.texto);

        //se establece el SensorManager, el Sensor de luz y el observador
        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        sensorManager.registerListener(this, lightSensor,SensorManager.SENSOR_DELAY_NORMAL);

        //Si no se encuentra el sensor, se muestra un mensaje de error
        if (lightSensor == null) {
            lightTxt.setText(sensorFail);
        }
    }

    public void lightSensor(SensorEvent event){
        float light = event.values[0];
        lightTxt.setText("Luz: " + String.valueOf(light));
        int color;
        if (light > 255){
            color = 255;
        }
        else {
            color = (int) light;
        }
        lightTxt.setBackgroundColor(Color.rgb(255-color, 255-color, 255-color));
        lightTxt.setTextColor(Color.rgb(color, color, color));
    }
    /**
     * Método que recoge el valor que detecta el sensor y lo actualiza en el TextView cada vez que
     * se detecta un cambio en el sensor.
     * @param event Parámetro que representa un cambio en el sensor de luz.
     */
    @Override
    public void onSensorChanged(SensorEvent event) {
        synchronized (this){
            switch (event.sensor.getType()){
                case Sensor.TYPE_LIGHT:
                    lightSensor(event);
                    break;
                default:

                    break;
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        //Método vacío
    }
}
