package com.example.user.lab1_ex2_tempconverter;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void convertClick(View v) {

        double out;
        RadioGroup rgFrom = (RadioGroup)findViewById(R.id.rgFrom);
        RadioGroup rgTo = (RadioGroup)findViewById(R.id.rgTo);

        int selFrom = rgFrom.getCheckedRadioButtonId();
        int selTo = rgTo.getCheckedRadioButtonId();

        EditText etInput = (EditText) findViewById(R.id.etInput);
        String s = etInput.getText().toString();
        double in = Double.parseDouble(s);

        if (selFrom == R.id.rbFrmC) {

            if (selTo == R.id.rbToC) {
                out = in;
            } else if (selTo == R.id.rbToF) {
                out = in * (9.0 / 5.0) + 32;
            } else {
                out = in + 273.15;
            }

        } else if (selFrom == R.id.rbFrmF) {

            if (selTo == R.id.rbToC) {
                out = (in - 32) * (5.0 / 9.0);
            } else if (selTo == R.id.rbToF) {
                out = in;
            } else {
                out = (in+459.67)*(5.0/9.0);
            }

        } else {

            if (selTo == R.id.rbToC) {
                out = in - 273.15;
            } else if (selTo == R.id.rbToF) {
                out = in * (5.0 / 9.0) -459.67;
            } else {
                out = in;
            }
        }

        TextView tvOut = (TextView) findViewById(R.id.tvOutput);
        tvOut.setText(Double.toString(out));

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
