package uk.ac.napier.multicolourbuttons;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button red_btn = (Button) findViewById(R.id.button_red);
        red_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RelativeLayout rl1  = (RelativeLayout) findViewById(R.id.rl1);
                rl1.setBackgroundColor(Color.RED);
            }
        });

        Button blue_btn = (Button) findViewById(R.id.button_blue);
        blue_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RelativeLayout rl1 = (RelativeLayout) findViewById(R.id.rl1);
                rl1.setBackgroundColor(Color.BLUE);
            }
        });

        Button green_btn = (Button) findViewById(R.id.button_green);
        green_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RelativeLayout rl1 = (RelativeLayout) findViewById(R.id.rl1);
                rl1.setBackgroundColor(Color.GREEN);
            }
        });
    }
}
