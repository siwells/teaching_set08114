package org.simonwells.externalfiles;

import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
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
                String state = Environment.getExternalStorageState();
                if (Environment.MEDIA_MOUNTED.equals(state))
                {
                    File file = new File(getApplicationContext()
                            .getExternalFilesDir(null), "napier.txt");
                    String datetime = new Date().toString();
                    try{
                        OutputStream os = new FileOutputStream(file);
                        os.write(datetime.getBytes());
                        os.close();;
                    } catch (Exception e) {e.printStackTrace();}
                }
            }
        });

        Button btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String state = Environment.getExternalStorageState();
                if(Environment.MEDIA_MOUNTED.equals(state))
                {
                    File file = new File(getApplicationContext()
                            .getExternalFilesDir(null), "napier.txt");
                    StringBuffer inStr = new StringBuffer("");
                    int ch;
                    try{
                        InputStream is = new FileInputStream(file);
                        while((ch = is.read()) != -1) {inStr.append((char) ch);}
                    } catch (Exception e) {e.printStackTrace();}
                    String data = new String(inStr);
                    Toast.makeText(getApplicationContext(), data, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

