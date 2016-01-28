package org.simonwells.actionbartest;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
            Toast.makeText(getApplicationContext(), "SETTINGS", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (id == R.id.action_lincrea){
            //Toast.makeText(getApplicationContext(), "LINCREA", Toast.LENGTH_SHORT).show();
            Intent l_act = new Intent(getBaseContext(), LincreaActivity.class);
            startActivity(l_act);
            return true;
        }
        else if (id == R.id.action_napier){
            //Toast.makeText(getApplicationContext(), "NAPIER", Toast.LENGTH_SHORT).show();
            Intent n_act = new Intent(getBaseContext(), NapierActivity.class);
            startActivity(n_act);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
