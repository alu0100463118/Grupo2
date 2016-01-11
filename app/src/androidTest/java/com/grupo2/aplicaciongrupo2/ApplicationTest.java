package com.grupo2.aplicaciongrupo2;

import android.app.Application;
import android.content.Intent;
import android.test.ApplicationTestCase;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    /**
     * Test para el acelerómetro
     */
    public void testAcelerometro() throws Exception {
        Acelerometro acelerometro = new Acelerometro();
        assertNotNull("Hay sensor", acelerometro.getSensor() != null);
    }

    /**
     * Test para el giroscopio
     */
    public void testGiroscopio() throws Exception {
        Giroscopio giroscopio = new Giroscopio();
        assertNotNull("Hay sensor", giroscopio.getSensor() != null);
    }

    /**
     * Test para el sensor de humedad
     */
    public void testHumedad() throws Exception {
        HumedadActivity humedad = new HumedadActivity();
        assertNotNull("Hay Sensor", humedad.getSensores() != null);
    }

    /**
     * Test para el sensor de luz
     */
    public void testLuz() throws Exception {
        Luz luz = new Luz();
        assertNotNull("Hay Sensor", luz.getLightSensor() != null);
    }

    /**
     * test para el magnómetro
     */
    public void testMagnometro() throws Exception {
        MagnometroActivity magnometro = new MagnometroActivity();
        assertNotNull("Hay Sensor", magnometro.getSensores() != null);
    }

    /**
     * test para el podómetro
     */
    public void testPodometro() throws Exception {
        Podometro podometro = new Podometro();
        assertNotNull("Hay Sensor", ((podometro.getmStepCounterSensor() != null)&&(podometro.getmStepDetectorSensor() != null)));
    }

    /**
     * Test para el sensor de proximidad
     */
    public void testProximidad() throws Exception {
        ProximidadActivity proximidad = new ProximidadActivity();
        assertNotNull("Hay sensor", proximidad.getSensores() != null);
    }

    /**
     * Test para el pulsómetro
     */
    public void testPulsometro() throws Exception {
        Pulsometro pulsometro = new Pulsometro();
        assertNotNull("Hay sensor", pulsometro.getmHeartRate() != null);
    }

    /**
     * Test para el termómetro
     */
    public void testTermometro() throws Exception {
        Termometro termometro = new Termometro();
        assertNotNull("Hay sensor", termometro.getmTemperature() != null);
    }
}