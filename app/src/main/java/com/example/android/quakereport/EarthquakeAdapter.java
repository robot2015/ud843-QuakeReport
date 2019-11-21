package com.example.android.quakereport;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    // Create constructor.
    EarthquakeAdapter(Activity context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    // Override View method.
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the view is being reused, otherwise inflate the view.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_list_item, parent, false);
        }

        // Get the object located at this position in the list.
        Earthquake currentQuake = getItem(position);

        // Set the earthquake magnitude.
        TextView magTextView = listItemView.findViewById(R.id.mag_text_view);
        magTextView.setText(currentQuake.getMagString());

        // Set the proper background color on the magnitude circle.
        GradientDrawable magnitudeCircle = (GradientDrawable) magTextView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude.
        int magnitudeColor = getMagnitudeColor(currentQuake.getMagIntDown());

        // Set the color on the magnitude circle.
        magnitudeCircle.setColor(magnitudeColor);

        // Set the earthquake location offset.
        TextView locationOffsetTextView = listItemView.findViewById(R.id.location_offset_text_view);
        locationOffsetTextView.setText(currentQuake.getLocationOffset());

        // Set the earthquake primary location.
        TextView primaryLocationTextView = listItemView.findViewById(R.id.primary_location_text_view);
        primaryLocationTextView.setText(currentQuake.getPrimaryLocation());

        // Set the earthquake date.
        TextView dateTextView = listItemView.findViewById(R.id.date_text_view);
        dateTextView.setText(currentQuake.getDateString());

        // Set the earthquake time.
        TextView timeTextView = listItemView.findViewById(R.id.time_text_view);
        timeTextView.setText(currentQuake.getTimeString());

        return listItemView;
    }

    private int getMagnitudeColor(int magnitude) {

        int magColor;

        switch (magnitude) {
            case 0:
            case 1:
                magColor = R.color.magnitude1;
                break;
            case 2:
                magColor = R.color.magnitude2;
                break;
            case 3:
                magColor = R.color.magnitude3;
                break;
            case 4:
                magColor = R.color.magnitude4;
                break;
            case 5:
                magColor = R.color.magnitude5;
                break;
            case 6:
                magColor = R.color.magnitude6;
                break;
            case 7:
                magColor = R.color.magnitude7;
                break;
            case 8:
                magColor = R.color.magnitude8;
                break;
            case 9:
                magColor = R.color.magnitude9;
                break;
            default:
                magColor = R.color.magnitude10plus;
        }

        return ContextCompat.getColor(getContext(), magColor);
    }
}