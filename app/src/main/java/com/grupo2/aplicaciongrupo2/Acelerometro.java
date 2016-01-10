package com.grupo2.aplicaciongrupo2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


/**
 * @class  Acelerometro
 */

public  class Acelerometro extends AppCompatActivity implements SensorEventListener {
    /** The texto. */
    TextView texto;

    /** The sensor manager. */
    SensorManager sensorManager;

    /** The accelerometer. */
    private Sensor sensor;

    private static final String FALLO_SENSOR = SensorFail.sensorFail + "ACELERÓMETRO.";
    private static final String MS = " m/s ";

    /**
     * On create.
     *
     * @param savedInstanceState the saved instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_acelerometro);


        texto = (TextView)findViewById(R.id.texto);

        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);


        // Si no detectamos el sensor, mostramos el mensaje de fallo
        if (sensor == null) {
            texto.setText(FALLO_SENSOR);
        }

    }

    /**
     * On create options menu.
     *
     * @param menu the menu
     * @return true, if successful
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * On options item selected.
     *
     * @param item the item
     * @return true, if successful
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * On sensor changed.
     *
     * @param event the event
     */
    @Override
    public void onSensorChanged(SensorEvent event) {
        float x,y,z;

        /**
         * Valores de los ejes X,Y,Z.
         *
         * @variable values esta por defecto dentro de la librería de los sensores.
         */
        x = event.values[0];
        y = event.values[1];
        z = event.values[2];

        /**
         * @variable texto muestra los valores de los tres ejes en metros/segundos.
         */
        texto.setText("\n" + " Valor de X: " + x +MS+ "\n" + " Valor de Y: " + y +MS+  "\n" + " Valor de Z: " + z + MS);


    }

    /**
     * On accuracy changed.
     *
     * @param sensor the sensor
     * @param accuracy the accuracy
     */
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        //Método vacío
    }

    /**
     * On resume. Registro del listener para conocer si se ha minimizado la actividad
     */
    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    /**
     * On pause.Para no sobrecargar la batería y parar la actividad cuando se salga de ella.
     */
    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

}