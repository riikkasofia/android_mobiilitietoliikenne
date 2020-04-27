package com.example.asynctaskhttp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements  HttpReader.resultHtml,View.OnClickListener {

    private HttpReader htmlreader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        htmlreader = new HttpReader(this);
        findViewById(R.id.GoBTN).setOnClickListener(this);

    }

    @Override
    public void resulthtml(String s) {
        TextView txt = findViewById(R.id.HTMLView);
        txt.setText(s);
    }

    @Override
    public void onClick(View v) {
        EditText teksti = findViewById(R.id.TextEditor);
        String s = teksti.getText().toString();
        htmlreader.execute(s);

    }
}

