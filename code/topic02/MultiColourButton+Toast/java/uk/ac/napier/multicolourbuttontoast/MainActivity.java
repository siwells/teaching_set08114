package uk.ac.napier.multicolourbuttontoast;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

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
                String msg = "Colour: ";
                RelativeLayout rl1 = (RelativeLayout) findViewById(R.id.rl1);
                if (bg_blue) {
                    bg_blue = false;
                    bg_red = true;
                    bg_green = false;
                    rl1.setBackgroundColor(Color.RED);
                    msg+="red";
                } else if (bg_red) {
                    bg_blue = false;
                    bg_red = false;
                    bg_green = true;
                    rl1.setBackgroundColor(Color.GREEN);
                    msg+="green";
                } else {
                    bg_blue = true;
                    bg_red = false;
                    bg_green = false;
                    rl1.setBackgroundColor(Color.BLUE);
                    msg += "blue";
                }
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }


        });
    }

}
