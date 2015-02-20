package org.simonwells.consumingjsonws;

import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class MainActivity extends ActionBarActivity {
    EditText etResponse;
    TextView tvConnected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etResponse = (EditText) findViewById(R.id.et1);
        tvConnected = (TextView) findViewById(R.id.tv1);

        if(isConnected())
        {
            tvConnected.setBackgroundColor(0xFF00CC00);
            tvConnected.setText("You are connected");
        }
        else
        {
            tvConnected.setText("Not Connected");
        }
        new HttpAsyncTask().execute("http://jsonip.com");
    }

    public static String GET(String url)
    {
        InputStream inStream = null;
        String result = "";
        try
        {
            HttpClient httpClient = new DefaultHttpClient();
            HttpResponse httpResponse = httpClient.execute(new HttpGet(url));
            inStream = httpResponse.getEntity().getContent();
            if(inStream != null)
                result = convertInputStreamToString(inStream);
            else
                result = "Did not work";
        }
        catch (Exception e)
        {
            Log.d("InputStream", e.getLocalizedMessage());
        }
        return result;
    }

    private static String convertInputStreamToString(InputStream inputStream) throws IOException
    {
        BufferedReader br = new BufferedReader( new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while((line = br.readLine()) != null )
            result += line;
        inputStream.close();
        return result;
    }

    public boolean  isConnected()
    {
        ConnectivityManager cman = (ConnectivityManager) getSystemService(Activity.CONNECTIVITY_SERVICE);
        NetworkInfo netinfo = cman.getActiveNetworkInfo();
        if(netinfo != null && netinfo.isConnected())
            return true;
        else
            return false;
    }

    private class HttpAsyncTask extends AsyncTask<String, Void, String>
    {
        @Override
        protected String doInBackground(String... urls)
        {
            return GET(urls[0]);
        }
        @Override
        protected void onPostExecute(String result)
        {
            Toast.makeText(getBaseContext(), "Received", Toast.LENGTH_SHORT).show();
            etResponse.setText(result);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
