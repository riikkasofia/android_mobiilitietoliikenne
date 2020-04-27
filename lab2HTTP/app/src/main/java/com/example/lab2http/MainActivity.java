package com.example.lab2http;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy policy =
                new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        findViewById(R.id.GoBTN).setOnClickListener(this);
        textView = findViewById(R.id.HTMLView);

    }

        @Override
        public void onClick (View v){

            if (v.getId() == R.id.GoBTN) {
                EditText editor = findViewById(R.id.TextEditor);
                String value = editor.getText().toString();
                 loadFromWeb(value);

            }
        }

        private void loadFromWeb (String urlString){

            try {
                URL url = new URL(urlString);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                InputStream in = new BufferedInputStream(connection.getInputStream());
                String htmlText = Utilities.fromStream(in);
                TextView textView = findViewById(R.id.HTMLView);
                textView.setText(htmlText);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



