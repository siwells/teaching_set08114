package uk.ac.napier.multicolourbuttontextview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Boolean bg_blue = false;
    Boolean bg_red = false;
    Boolean bg_green = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button push_me = (Button) findViewById(R.id.btn_push_me);
        push_me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RelativeLayout rl1 = (RelativeLayout) findViewById(R.id.rl1);
                TextView tv1 = (TextView) findViewById(R.id.tv_colour);
                if (bg_blue) {
                    bg_blue = false;
                    bg_red = true;
                    bg_green = false;
                    rl1.setBackgroundColor(Color.RED);
                    tv1.setText("RED");
                } else if (bg_red) {
                    bg_blue = false;
                    bg_red = false;
                    bg_green = true;
                    rl1.setBackgroundColor(Color.GREEN);
                    tv1.setText("GREEN");
                } else {
                    bg_blue = true;
                    bg_red = false;
                    bg_green = false;
                    rl1.setBackgroundColor(Color.BLUE);
                    tv1.setText("BLUE");
                }
            }
        });
    }
}
