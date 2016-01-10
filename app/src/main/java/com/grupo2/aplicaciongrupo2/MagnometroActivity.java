package com.grupo2.aplicaciongrupo2;

import android.app.Activity;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ManuelAlejandro on 30/11/2015.
 */
public class MagnometroActivity extends Activity implements SensorEventListener{
    TextView magneticView;
    Sensor s;
    SensorManager sensorM;
    List<Sensor> sensores;

    /**
     *       Primero se le especifica a la clase MagnometroActivity que implemente el SensorEventListener, esto
     *  se hace para manipular los eventos del sensor y ejecutar nuestro código cuando cambie.
     *  @param savedInstanceState
     *
     */

    /**
     * Constructor de la clase Activity,
     * @param savedInstanceState guarda una instancia de la actividad pasada por parametro
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_magnometro);
        this.magneticView = (TextView) findViewById(R.id.magnetic);

        sensorM = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensores = sensorM.getSensorList(Sensor.TYPE_MAGNETIC_FIELD);
        if (!sensores.isEmpty()){
            s = sensores.get(0);
            sensorM.registerListener(this,s,sensorM.SENSOR_DELAY_UI);
        }
        else
        {
            this.magneticView.setText("NO HAY SENSOR ACTIVO");
            this.magneticView.setBackgroundColor(Color.rgb(255, 0, 0));
        }
    }
    /**
     *      El evento que interesa es OnSensorChanged, el código escrito en este evento se ejecuta cada vez que algún valor
     * de las coordenadas cambien. Se cogen las coordenadas X, Y y Z del sensor y se muestran mediante un objeto TextView especificando
     * el valor del array le pertenece:
     * X = evento.values[0]
     * Y = evento.values[1]
     * Z = evento.values[2]
     * @param evento
     */

    @Override
    public void onSensorChanged(SensorEvent evento) {
        this.magneticView.setText(String.format("Coordenada X: %f%nCoordenada Y: %f%nCoordenada Z %f", evento.values[0], evento.values[1], evento.values[2]));
    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        //Método vacío
    }
}
