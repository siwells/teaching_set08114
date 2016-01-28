package org.simonwells.userinput;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText nameTxt = (EditText) findViewById(R.id.et1);
        nameTxt.setFilters(new InputFilter[]{
                new InputFilter.LengthFilter(10),
                new InputFilter.AllCaps()
        });

        final EditText pwfield = (EditText) findViewById(R.id.et3);
        Button go_button = (Button) findViewById(R.id.btn1);
        go_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = pwfield.getText().toString();

                boolean valid = true;
                boolean hasNumbers = false;
                boolean hasLetters = false;

                for (int i=0; i<text.length(); i++) {
                    char x = text.charAt(i);
                    if (Character.isDigit(x))
                    {
                        hasNumbers = true;
                    }
                    else if (Character.isLetter(x)) {
                        hasLetters = true;
                    }
                    else {
                        valid = false;
                        break;
                    }
                if (valid && hasLetters && hasNumbers){
                    Toast.makeText(getBaseContext(), "Password " + text + " is valid.", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getBaseContext(), "Password " + text + " is not valid.", Toast.LENGTH_SHORT).show();
                }

                }
                }

        });
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
