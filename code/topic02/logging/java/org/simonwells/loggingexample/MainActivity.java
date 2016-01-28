package org.simonwells.loggingexample;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;


public class MainActivity extends ActionBarActivity {

    //private static final String TAG = "LoggingExample";
    private static final String TAG = "LINCREA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Log.i(TAG, "In onCreate() in LoggingExample App");
        //Log.v(TAG, "In onCreate() in LoggingExample App"); // VERBOSE
        //Log.d(TAG, "In onCreate() in LoggingExample App"); // DEUBG
        //Log.w(TAG, "In onCreate() in LoggingExample App"); // WARNING
        //Log.e(TAG, "In onCreate() in LoggingExample App"); // ERROR

        //Toast
          //      .makeText(getApplicationContext(), "HELLO NAPIER!!!", Toast.LENGTH_LONG)
            //    .show();

        Button hello_btn = (Button) findViewById(R.id.hello_button);
        hello_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Hello Napier", Toast.LENGTH_LONG).show();
                Log.i(TAG, "Handling a button click for the first time");

                TextView tv1 = (TextView) findViewById(R.id.date_display);
                tv1.setText(new Date().toString());
            }
        });

        Button second_screen_btn = (Button) findViewById(R.id.button);
        second_screen_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), SecondScreen.class);
                startActivity(i);
            }
        });

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
