package uk.ac.napier.timepickerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TimePicker tp1;
    private Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tp1 = (TimePicker) findViewById(R.id.tp1);
        btn1 = (Button) findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int h = tp1.getCurrentHour();
                int m = tp1.getCurrentMinute();

                String hour = String.valueOf(h);
                String min = String.valueOf(m);

                Toast.makeText(getApplicationContext(), hour + ":" + min, Toast.LENGTH_LONG).show();
            }
        });
    }
}
