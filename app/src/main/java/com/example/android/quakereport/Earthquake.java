package com.example.android.quakereport;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Earthquake {
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
        return String.valueOf(mMag);
    }

    // Earthquake place.
    private String mPlace;

    public String getPlace() {
        return mPlace;
    }

    // Earthquake time.
    private long mTime;

    public long getTime() {
        return mTime;
    }

    public String getTimeString() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        return dateFormat.format(mTime);
    }
}