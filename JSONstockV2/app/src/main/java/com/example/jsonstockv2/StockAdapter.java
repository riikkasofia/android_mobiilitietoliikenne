package com.example.jsonstockv2;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class StockAdapter extends ArrayAdapter <StockData> {

    public StockAdapter(Activity context, ArrayList<StockData> carsDetails){
        super(context, 0, carsDetails);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        StockData stockData = getItem(position);

        TextView ratingTextView = (TextView) listItemView.findViewById(R.id.name);
        ratingTextView.setText(stockData.getId());

        TextView priceTextView = (TextView) listItemView.findViewById(R.id.price);
        priceTextView.setText(stockData.getPrice());


        return listItemView;
    }
}
