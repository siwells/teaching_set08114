package uk.ac.napier.colourbutton;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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



        Button push_me = (Button) findViewById(R.id.btn_push_me);
        push_me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RelativeLayout rl1 = (RelativeLayout) findViewById(R.id.RL1);
                ColorDrawable viewColour = (ColorDrawable) rl1.getBackground();
                int colourID = viewColour.getColor();
                if(colourID == -65536)
                    rl1.setBackgroundColor(Color.GREEN);
                else
                    rl1.setBackgroundColor(Color.RED);
            }
        });
    }
}
