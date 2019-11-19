/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        // Create a fake list of earthquake locations.
        ArrayList<Earthquake> earthquakes = new ArrayList<>();
        earthquakes.add(new Earthquake(7.2, "San Francisco", 3221683200L));
        earthquakes.add(new Earthquake(6.1, "London", 3520195200L));
        earthquakes.add(new Earthquake(3.9, "Tokyo", 3498422400L));
        earthquakes.add(new Earthquake(5.4, "Mexico City", 3481920000L));
        earthquakes.add(new Earthquake(2.8, "Moscow", 3442435200L));
        earthquakes.add(new Earthquake(4.9, "Rio de Janeiro", 3428179200L));
        earthquakes.add(new Earthquake(1.6, "Paris", 3402777600L));

        // Create EarthquakeAdapter.
        EarthquakeAdapter adapter = new EarthquakeAdapter(this, earthquakes);

        // Create the ListView object and attach the adapter.
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}