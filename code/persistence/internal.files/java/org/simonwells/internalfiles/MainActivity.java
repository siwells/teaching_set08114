package org.simonwells.internalfiles;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String filename = "napierfile";
                String outString = new Date().toString();
                FileOutputStream outStream;

                try {
                    outStream = getApplicationContext().openFileOutput(filename, Context.MODE_PRIVATE);
                    outStream.write(outString.getBytes());
                    outStream.close();
                } catch(Exception e) { e. printStackTrace(); }
            }
        });

        Button btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int ch;
                String filename = "napierfile";
                StringBuffer inString = new StringBuffer("");
                FileInputStream inStream;

                try {
                    inStream = getApplicationContext().openFileInput(filename);
                    try {
                        while ((ch = inStream.read()) != -1)
                            inString.append((char) ch);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String data = new String(inString);
                Toast.makeText(getBaseContext(), data, Toast.LENGTH_SHORT).show();
            }
        });
    }
}

