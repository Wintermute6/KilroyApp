package com.soontm.kilroy.domain;

import android.location.Location;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Wintermute on 07.09.2015.
 */
public class MarkerItem {

    private String name;
    private LatLng markerLocation;
    private String description;
    private int id;


    public MarkerItem(String name, LatLng markerLocation, String description, int id) {
        this.name = name;
        this.markerLocation = markerLocation;
        this.description = description;
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public LatLng getMarkerLocation() {
        return markerLocation;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }
}
