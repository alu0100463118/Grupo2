package com.grupo2.aplicaciongrupo2;

import android.test.InstrumentationTestCase;

/**
 * Created by Bianney on 09/01/2016.
 */
public class SensorTests extends InstrumentationTestCase {

    public void test() throws Exception {
        final int expected = 1;
        final int reality = 5;
        assertEquals(expected, reality);
    }
}