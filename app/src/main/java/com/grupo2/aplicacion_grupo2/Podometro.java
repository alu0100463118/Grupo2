package com.grupo2.aplicacion_grupo2;


import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.List;


/**
 * @class  Podometro
 */
public class Podometro extends AppCompatActivity implements SensorEventListener {

    /**
     * Función principal con el codigo del sensor (Podometro).
     *
     * declaracion de las variables ha emplear usando la biblioteca de Sensores
      */
    private TextView textView;
    private SensorManager sensorManager;

    private Sensor mStepCounterSensor;
    private Sensor mStepDetectorSensor;


    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /**
         * Se llama en la creación de la actividad
         * Llamada a las funciones que vienen implementadas dentro de la clase SensorManager
         * Permite la obtencion de los distintos valores del sensor
         */

        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_podometro);
        textView = (TextView) findViewById(R.id.texto);

        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        mStepCounterSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        mStepDetectorSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);

    }

    /**
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * onSensorChanged
     * @param event
     */
    @Override
    public void onSensorChanged(SensorEvent event) {
        /**
         * Muestreo de los datos una vez se vaya modificando el valor
         */
        Sensor sensor = event.sensor;
        float[] values = event.values;
        int value = -1;

        /**
         * los valores se almacenan en el vector values.
         */
        if (values.length > 0) {
            value = (int) values[0];
        }

        if (sensor.getType() == Sensor.TYPE_STEP_COUNTER) {
            textView.setText("Número de pasos : " + value);
        }
        else if (sensor.getType() == Sensor.TYPE_STEP_DETECTOR) {
            /**
             * Prueba. Sólo permite el valor 1 para el paso dado
             */
            textView.setText("Número de pasos : " + value);
        }
    }

    /**
     *
     * @param sensor
     * @param i
     */
    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
        //Método vacío
    }


    /**
     * onResum
     */
    @Override
    protected void onResume() {
        /**
         * Se llama cuando la actividad va a comenzar a interactuar con el usuario
         */
        super.onResume();
        sensorManager.registerListener(this, mStepCounterSensor,SensorManager.SENSOR_DELAY_FASTEST);
        sensorManager.registerListener(this, mStepDetectorSensor,SensorManager.SENSOR_DELAY_FASTEST);
    }

    @Override
    protected void onStop() {
        /**
         * La actividad ya no va a ser visible para el usuario.
         */
        super.onStop();
        sensorManager.unregisterListener(this, mStepCounterSensor);
        sensorManager.unregisterListener(this, mStepDetectorSensor);
    }


}