package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

// Loads a list of earthquakes by using an AsyncTask to perform the network request to the given URL.
public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {

    // Tag for log messages.
    private static final String LOG_TAG = EarthquakeLoader.class.getName();

    // Query URL.
    private String mUrl;

    // Constructs a new EarthquakeLoader.
    public EarthquakeLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        Log.v(LOG_TAG, "onStartLoading");
        forceLoad();
    }

    // This is on a background thread.
    @Override
    public ArrayList<Earthquake> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        Log.v(LOG_TAG, "loadInBackground");

        // Perform the network request, parse the response, and extract a list of earthquakes.
        String jsonResponse = QueryUtils.getEarthquakeJson(mUrl);
        return QueryUtils.extractEarthquakes(jsonResponse);
    }
}