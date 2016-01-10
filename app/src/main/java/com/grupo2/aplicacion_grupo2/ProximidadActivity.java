package com.grupo2.aplicacion_grupo2;

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

/**
 * Created by ManuelAlejandro on 16/11/2015.
 */
public class ProximidadActivity extends Activity implements SensorEventListener{
    LinearLayout fondo;
    TextView texto;
    Sensor s;
    SensorManager sensorM;
    List<Sensor> sensores;

    /**
     *       Primero se le especifica a la clase ProximidadActivity que implemente el SensorEventListener, esto
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
        setContentView(R.layout.activity_proximidad);
        fondo = (LinearLayout) findViewById(R.id.fondo);
        this.texto =(TextView) findViewById(R.id.proximidad);

        sensorM = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensores = sensorM.getSensorList(Sensor.TYPE_PROXIMITY);
        if (!sensores.isEmpty()){
            s = sensores.get(0);
            sensorM.registerListener(this,s,sensorM.SENSOR_DELAY_UI);
        }
        else
        {
            this.texto.setText("NO HAY SENSOR ACTIVO");
            this.texto.setBackgroundColor(Color.rgb(255, 0, 0));
        }
    }
    /**
     *      El evento que interesa es OnSensorChanged, el código escrito en este evento se ejecuta cada vez que algún valor
     * de distancia cambia. Primero se captura en forma de número flotante el valor de proximidad del sensor. Si el número
     * que devuelve es menor o igual que 2.5 se activa la App cambiando el fondo de la misma a un color aleatorio,
     * en caso contrario se deja el color negro en la pantalla.
     *
     * @param evento
     */

    @Override
    public void onSensorChanged(SensorEvent evento) {
        float valor=Float.parseFloat(String.valueOf(evento.values[0]));
        if (valor <= 2.5) {
            int t_red =(int) (Math.random()*255+1);
            int t_green =(int)(Math.random()*255+1);
            int t_blue =(int)(Math.random()*255+1);
            int color = Color.rgb(t_red, t_green, t_blue);
            fondo.setBackgroundColor(color);
        }
        else{
            fondo.setBackgroundColor(Color.BLACK);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        //Método vacío
    }
}
