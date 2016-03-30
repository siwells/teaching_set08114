package uk.ac.napier.datepickerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DatePicker dp1;
    private Button btn1;
    private Button btn2;
    private Button btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dp1 = (DatePicker) findViewById(R.id.dp1);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int d = dp1.getDayOfMonth();
                int m = dp1.getMonth();
                int y = dp1.getYear();

                String day = String.valueOf(d);
                String month = String.valueOf(m);
                String year = String.valueOf(y);

                Toast.makeText(getApplicationContext(),
                        day+":"+month+":"+year, Toast.LENGTH_LONG).show();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean status = !dp1.getCalendarViewShown();
                dp1.setCalendarViewShown(status);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean status = !dp1.getSpinnersShown();
                dp1.setSpinnersShown(status);
            }
        });
    }
}
