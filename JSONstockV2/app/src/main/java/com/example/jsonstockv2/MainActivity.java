package com.example.jsonstockv2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private StockAdapter stockAdapter;
    private ArrayList<StockData> stocklist;
    ListView lista;
    String url = "https://financialmodelingprep.com/api/company/price/NOK?datatype=json";
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stocklist = new ArrayList<>();

        lista = findViewById(R.id.list);
        stockAdapter = new StockAdapter(this, stocklist);
        lista.setAdapter(stockAdapter);

        findViewById(R.id.Button).setOnClickListener(this);


        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading....");
        dialog.show();

        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String string) {
                parseJsonData(string);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(getApplicationContext(), "Some error occurred", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        RequestQueue rQueue = Volley.newRequestQueue(MainActivity.this);
        rQueue.add(request);
    }

    void parseJsonData(String jsonString) {
        try {
            JSONObject object = new JSONObject(jsonString);
            JSONObject appleStockElement = object.getJSONObject("NOK");
            String stockPrice = appleStockElement.getString("price");

            StockData stockData = new StockData("NOK", stockPrice);

            stockAdapter.add(stockData);


        } catch (JSONException e) { e.printStackTrace(); }

        dialog.dismiss();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.Button){
            EditText editor = findViewById(R.id.SearchID);
            String id = editor.getText().toString();

            EditText editor2 = findViewById(R.id.SearchName);
            String name = editor2.getText().toString();

            StockData stockData = new StockData(id, name);


        }
    }
}
