package com.thepriest.andrea.zramtool;

import android.os.Bundle;
import android.os.Debug;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;


public class About extends ActionBarActivity {
    TextView textUp;//, textViewAppName;
    Button buttonClose;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //finish();
        return super.onTouchEvent(event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  this.setTheme(R.style.Black);
        setContentView(R.layout.activity_about);
        this.setTitle(R.string.app_name);
/*
        textViewAppName = (TextView) findViewById(R.id.textViewAppName);
        textViewAppName.setText("");
*/
        textUp = (TextView) findViewById(R.id.textUp);
        int versionCode = BuildConfig.VERSION_CODE;
        String aboutText = "Programming: ThePriest\nMade in Italy\n\nVersion: ";
        String versionName = BuildConfig.VERSION_NAME;
        aboutText += versionName;
        aboutText += "\n\nKernel version: " + getKernelVersion() + "\n";
        //aboutText+="\n\n" + "zram (also called zRAM and, initially, compcache) is a Linux kernel feature that provides a form of virtual memory compression.";
        textUp.setText(aboutText);
        buttonClose = (Button) findViewById(R.id.buttonClose);
        buttonClose.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_about, menu);
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

    public String getKernelVersion() {
        try {
            String string, sVersion;
            sVersion = "";
            FileInputStream fileInputStream = new FileInputStream("/proc/version");
            BufferedReader bufferedReader = new BufferedReader((Reader) new InputStreamReader((InputStream) fileInputStream));
            while ((string = bufferedReader.readLine()) != null) {
                sVersion = string;
            }
            fileInputStream.close();
            return sVersion;
        } catch (IOException var3_4) {
            Log.e((String) "CpuSpyApp", (String) "Problem reading kernel version file");
            return "";
        }
    }
}