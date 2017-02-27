package org.simonwells.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Random rnd = new Random();

        Button get_something = (Button) findViewById(R.id.btn1);
        get_something.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences prefs = getBaseContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                Map mp = prefs.getAll();
                Toast.makeText(getBaseContext(), mp.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        Button do_something = (Button) findViewById(R.id.btn2);
        do_something.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences prefs = getBaseContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                int newHighScore = rnd.nextInt(1000);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putInt("0", newHighScore);
                editor.commit();
                Toast.makeText(getBaseContext(), "New High Score: "+newHighScore, Toast.LENGTH_SHORT).show();
            }
        });
    }
}

