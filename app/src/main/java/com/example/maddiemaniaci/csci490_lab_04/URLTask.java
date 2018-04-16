package com.example.maddiemaniaci.csci490_lab_04;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class URLTask extends AsyncTask<String, Void, String> {

    private TextView textView;

    public URLTask(TextView view) {
        this.textView = view;
    }

    @Override
    protected String doInBackground(String... strings) {
        String result = "";
        try {
            URL url = new URL(strings[0]);
            url.openConnection();

            InputStream in = url.openStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            String data = "";
            String line = reader.readLine();
            while (line != null && !line.isEmpty()) {
                data += line;
                line = reader.readLine();
            }

            result = data.substring(10, 23);
            Log.i("Data", result);
        } catch (IOException e) { }
        return result;
    }

    @Override
    protected void onPostExecute(String s) {
        this.textView.setText(s);
    }
}
