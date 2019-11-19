package com.example.android.quakereport;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    // Create constructor.
    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    // Override View method.
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the view is being reused, otherwise inflate the view.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the object located at this position in the list.
        Earthquake currentQuake = getItem(position);

        // Set the earthquake magnitude.
        TextView magTextView = listItemView.findViewById(R.id.mag_text_view);
        magTextView.setText(currentQuake.getMagString());

        // Set the earthquake place.
        TextView placeTextView = listItemView.findViewById(R.id.place_text_view);
        placeTextView.setText(currentQuake.getPlace());

        // Set the earthquake time.
        TextView timeTextView = listItemView.findViewById(R.id.time_text_view);
        timeTextView.setText(currentQuake.getTimeString());

        return listItemView;
    }
}