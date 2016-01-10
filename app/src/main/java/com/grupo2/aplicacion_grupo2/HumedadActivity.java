package com.grupo2.aplicacion_grupo2;

/**
 * Created by Sergio on 10/12/2015.
 */

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DialogFragment;
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

    private final static String sensorFail = "Tu dispositivo no tiene el sensor de humedad";

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
            texto.setText(sensorFail);
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
        int t_red =(int) (255);
        int t_green =(int)(255);
        int t_blue =(int)(255);
        int color = Color.rgb(t_red, t_green, t_blue);

        if(valor <= 25)
        {
            t_red = 255;
            t_green = 0;
            t_blue = 0;
            fondo.setBackgroundColor(color);
            texto.setText(""+valor);
        }
        else
        if(valor <= 50 && valor > 25)
        {
            t_red = 255;
            t_green = 0;
            t_blue = 85;
            fondo.setBackgroundColor(color);
            texto.setText("" + valor);
        }
        else
        if(valor <= 75 && valor > 50)
        {
            t_red = 85;
            t_green = 0;
            t_blue = 255;
            fondo.setBackgroundColor(color);
            texto.setText("" + valor);
        }
        else
        if(valor > 75 && valor <= 100)
        {
            t_red = 0;
            t_green = 0;
            t_blue = 255;
            fondo.setBackgroundColor(color);
            texto.setText(""+valor);
        }

    }



    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}

