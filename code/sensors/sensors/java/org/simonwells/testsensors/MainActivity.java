package org.simonwells.testsensors;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    private long lastUpdate = 0;
    private float last_x, last_y, last_z = 0;
    private static final int SHAKE_THRESHOLD = 600;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SensorManager mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        Sensor sensorAccel;
        //List<Sensor> deviceSensors = mSensorManager.getSensorList(Sensor.TYPE_ALL);
        //List<Sensor> deviceSensors = mSensorManager.getSensorList(Sensor.TYPE_GYROSCOPE);
        //List<Sensor> deviceSensors = mSensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER);
        //List<Sensor> deviceSensors = mSensorManager.getSensorList(Sensor.TYPE_AMBIENT_TEMPERATURE);
        //List<Sensor> deviceSensors = mSensorManager.getSensorList(Sensor.TYPE_LIGHT);

        if (mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null) {
            Toast.makeText(getBaseContext(), "HAS ACCELEROMETER", Toast.LENGTH_LONG).show();

            sensorAccel = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            mSensorManager.registerListener(new SensorEventListener() {
                @Override
                public void onSensorChanged(SensorEvent event) {
                    Sensor localSensor = event.sensor;

                    if (localSensor.getType() == Sensor.TYPE_ACCELEROMETER){
                        float x = event.values[0];
                        float y = event.values[1];
                        float z = event.values[2];

                        long curTime = System.currentTimeMillis();

                        if ((curTime - lastUpdate) > 100)
                        {
                            long diffTime = (curTime - lastUpdate);
                            lastUpdate = curTime;

                            float speed = Math.abs(x + y + z - last_x - last_y - last_z)/ diffTime * 10000;

                            if (speed > SHAKE_THRESHOLD)
                            {
                                String str = String.valueOf(x) + String.valueOf(y) + String.valueOf(z);
                                Toast.makeText(getBaseContext(), str, Toast.LENGTH_SHORT).show();
                            }
                            last_x = x;
                            last_y = y;
                            last_z = z;
                        }
                    }
                }

                @Override
                public void onAccuracyChanged(Sensor sensor, int accuracy) {

                }
            }, sensorAccel, SensorManager.SENSOR_DELAY_NORMAL);

        }
        else
            Toast.makeText(getBaseContext(), "NOPE",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

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
}
