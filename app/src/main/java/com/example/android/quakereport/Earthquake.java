package com.example.android.quakereport;

import android.util.Log;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class Earthquake {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    // Create constructor.
    public Earthquake(double mag, String place, long time) {
        mMag = mag;
        mPlace = place;
        mTime = time;
    }

    // Earthquake magnitude.
    private double mMag;

    public double getMag() {
        return mMag;
    }

    public String getMagString() {
        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        return decimalFormat.format(mMag);
    }

    public int getMagIntDown() {
        return (int) mMag;
    }

    // Earthquake place.
    private String mPlace;

    public String getPlace() {
        return mPlace;
    }

    public String getPrimaryLocation() {
        String primaryLocation;

        if (mPlace.contains(" of ")) {
            primaryLocation = mPlace.split(" of ")[1];
        } else {
            primaryLocation = mPlace;
        }

        return primaryLocation;
    }

    public String getLocationOffset() {
        String locationOffset;

        if (mPlace.contains(" of ")) {
            locationOffset = mPlace.split(" of ")[0] + " of";
        } else {
            locationOffset = "Near the";
        }

        return locationOffset;
    }

    // Earthquake time.
    private long mTime;

    public long getDateTime() {
        return mTime;
    }

    public String getTimeString() {
        DateFormat timeFormat = new SimpleDateFormat("hh:mm:ss a");
        return timeFormat.format(mTime);
    }

    public String getDateString() {
        DateFormat dateFormat = new SimpleDateFormat("LLL DD, yyyy");
        return dateFormat.format(mTime);
    }
}