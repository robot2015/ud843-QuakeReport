package com.example.android.quakereport;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Earthquake {

    // Create constructor.
    Earthquake(double mag, String place, long time, String url) {
        mMag = mag;
        mPlace = place;
        mTime = time;
        mUrl = url;
    }

    // Earthquake magnitude.
    private double mMag;

    public double getMag() {
        return mMag;
    }

    String getMagString() {
        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        return decimalFormat.format(mMag);
    }

    int getMagIntDown() {
        return (int) mMag;
    }

    // Earthquake place.
    private String mPlace;

    public String getPlace() {
        return mPlace;
    }

    String getPrimaryLocation() {
        String primaryLocation;

        if (mPlace.contains(" of ")) {
            primaryLocation = mPlace.split(" of ")[1];
        } else {
            primaryLocation = mPlace;
        }

        return primaryLocation;
    }

    String getLocationOffset() {
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

    String getTimeString() {
        DateFormat timeFormat = new SimpleDateFormat("hh:mm a", Locale.US);
        return timeFormat.format(mTime);
    }

    String getDateString() {
        DateFormat dateFormat = new SimpleDateFormat("LLL DD, yyyy", Locale.US);
        return dateFormat.format(mTime);
    }

    // Earthquake URL.
    private String mUrl;

    String getUrl() {
        return mUrl;
    }
}