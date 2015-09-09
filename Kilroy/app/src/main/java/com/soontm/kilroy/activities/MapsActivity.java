package com.soontm.kilroy.activities;

import android.content.Context;
import android.location.Location;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import com.soontm.kilroy.R;
import com.soontm.kilroy.domain.MarkerItem;
import com.soontm.kilroy.dummyData.DummyMarker;
import com.soontm.kilroy.location.LocationUpdater;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements LocationUpdater.locationUpdateListener {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.

    private static final int FIX_UPDATE_TIME = 500; // milliseconds
    private static final int FIX_UPDATE_DISTANCE = 5; // meters

    private LocationUpdater locationUpdater;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setUpMapIfNeeded();
        requestLocationUpdates();
        initMapCamera();

    }


    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }


    private void setUpMap() {
        //mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
        mMap.setMyLocationEnabled(true);
        setupMarkers();
    }


    private void setupMarkers() {
        DummyMarker dummys = new DummyMarker();
        ArrayList <MarkerItem> dummyMarkers = dummys.getDummyMarkers();

        for (int i =0 ; i< dummyMarkers.size()-1;i++) {
            MarkerItem m = dummyMarkers.get(i);
            MarkerOptions options = new MarkerOptions().position(m.getMarkerLocation()).title(m.getName());
            mMap.addMarker(options);

        }
    }


    private void requestLocationUpdates() {
        locationUpdater = new LocationUpdater(Context.LOCATION_SERVICE, FIX_UPDATE_TIME, FIX_UPDATE_DISTANCE, this);
        locationUpdater.setLocationUpdateListener(this);
        locationUpdater.requestLocationUpdates();

    }


    // sets the initial position of the camera when activity is opened.
    private void initMapCamera() {
        Location location = locationUpdater.getLastKnownLocation();

        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(new LatLng(latitude, longitude), 13);
        mMap.animateCamera(update);
    }


    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();

    }


    //updates the map when the user moves a certain distance or after a certain time.
    @Override
    public void onLocationUpdateReceived(Location location) {
        if (location != null) {
            updateMap(location);
        }
    }


    private void updateMap(Location location) {
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLng(new LatLng(latitude, longitude));
        mMap.animateCamera(cameraUpdate);
    }
}
