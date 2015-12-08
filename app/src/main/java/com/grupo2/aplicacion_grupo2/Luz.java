package com.grupo2.aplicacion_grupo2;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Luz extends AppCompatActivity implements SensorEventListener {

    private TextView lightTxt;
    private SensorManager sensorManager;
    private Sensor lightSensor;
    private final static String sensorFail = "Tu dispositivo no tiene el sensor de temperatura";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luz);

        lightTxt = (TextView) findViewById(R.id.texto);

        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        sensorManager.registerListener(this, lightSensor,SensorManager.SENSOR_DELAY_NORMAL);


        if (lightSensor == null) {
            System.out.println("no eyyyyyy");
            lightTxt.setText(sensorFail);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        synchronized (this){
            switch (event.sensor.getType()){
                case Sensor.TYPE_LIGHT:
                    float light = event.values[0];
                    lightTxt.setText("Luz: " + String.valueOf(light));
                    break;
                default:
                    System.out.print("default");
                    break;
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
