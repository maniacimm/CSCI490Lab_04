package com.example.maddiemaniaci.csci490_lab_04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public String createURL(String string) throws IOException {
        URL url = new URL(string);
        url.openConnection();

        InputStream in = url.openStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        String data = reader.readLine();
        Log.i("Data", data);
        return data;
    }
}
