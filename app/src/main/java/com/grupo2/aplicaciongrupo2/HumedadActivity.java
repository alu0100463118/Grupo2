package com.grupo2.aplicaciongrupo2;

/**
 * Created by Sergio on 10/12/2015.
 */

import android.app.Activity;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;

public class HumedadActivity extends Activity implements SensorEventListener {
    LinearLayout fondo;
    TextView texto;
    Sensor s;
    SensorManager sensorM;
    List<Sensor> sensores;

    private static final String SENSOR_FAIL = "Tu dispositivo no tiene el sensor de humedad";

    /**
     *       Primero se le especifica a la clase HumedadActivity que implemente el SensorEventListener, esto
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
        setContentView(R.layout.content_humedad);
        fondo = (LinearLayout) findViewById(R.id.fondo);
        texto = (TextView) findViewById(R.id.humidity);

        sensorM = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorM.registerListener(this,s,sensorM.SENSOR_DELAY_UI);

        if (s == null)
        {
            texto.setText(SENSOR_FAIL);
        }
    }

    /**
     *      El evento que interesa es OnSensorChanged, el código escrito en este evento se ejecuta cada vez que algún valor
     * de la variable cambie. Se coge el valor del sensor y se muestran mediante un objeto TextView especificando
     * el valor del array le pertenece:
     *
     * Medida = evento.values[0]
     *
     * Por otro lado se realiza un cambio de color en el fondo, que parte rojo para valores bajos de humedad, e intercala
     * otros dos valores intermedios en la gama hasta llegar al azul cuando la humedad sumera el 75%.
     * @param evento
     */

    @Override
    public void onSensorChanged(SensorEvent evento) {
        float valor=Float.parseFloat(String.valueOf(evento.values[0]));
        int tRed = 255;
        int tGreen = 255;
        int tBlue = 255;
        int color = Color.rgb(tRed, tGreen, tBlue);

        if(valor <= 25)
        {
            tRed = 255;
            tGreen = 0;
            tBlue = 0;
            fondo.setBackgroundColor(color);
            texto.setText(""+valor);
        }
        else
        if(valor <= 50 && valor > 25)
        {
            tRed = 255;
            tGreen = 0;
            tBlue = 85;
            fondo.setBackgroundColor(color);
            texto.setText("" + valor);
        }
        else
        if(valor <= 75 && valor > 50)
        {
            tRed = 85;
            tGreen = 0;
            tBlue = 255;
            fondo.setBackgroundColor(color);
            texto.setText("" + valor);
        }
        else
        if(valor > 75 && valor <= 100)
        {
            tRed = 0;
            tGreen = 0;
            tBlue = 255;
            fondo.setBackgroundColor(color);
            texto.setText(""+valor);
        }

    }



    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        //Método vacío
    }
}

