package org.simonwells.preferencesexample;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Map;
import java.util.Random;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Random rnd = new Random();

        Button get_something = (Button) findViewById(R.id.btn1);
        get_something.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = getBaseContext()
                        .getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                Map mp = prefs.getAll();
                Toast.makeText(getBaseContext(), mp.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        Button do_something = (Button) findViewById(R.id.btn2);
        do_something.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = getBaseContext()
                        .getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                int newHighScore = rnd.nextInt(1000);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putInt("0", newHighScore);
                editor.commit();
                Toast.makeText(getBaseContext(), "New High Score: "+newHighScore, Toast.LENGTH_SHORT).show();
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
