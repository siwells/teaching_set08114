package uk.ac.napier.imageswitcher;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView iv;
    Button btn;
    int current;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switch_image_listener();
    }

    public void switch_image_listener()
    {
        iv = (ImageView) findViewById(R.id.image_switch_view);
        btn = (Button) findViewById(R.id.image_switch_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(iv.getDrawable() == null) {
                    iv.setImageResource(R.drawable.moon);
                    current = R.drawable.moon;
                }
                else {
                    if(current == R.drawable.moon)
                    {
                        iv.setImageResource(R.drawable.sun);
                        current = R.drawable.sun;
                    }
                    else
                    {
                        iv.setImageResource(R.drawable.moon);
                        current = R.drawable.moon;
                    }
                }
            }
        });
    }
}
