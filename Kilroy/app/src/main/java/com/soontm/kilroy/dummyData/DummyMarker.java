package com.soontm.kilroy.dummyData;

import android.location.Location;

import com.google.android.gms.maps.model.LatLng;
import com.soontm.kilroy.domain.MarkerItem;

import java.util.ArrayList;

/**
 * Created by Wintermute on 07.09.2015.
 */
public class DummyMarker {



    public ArrayList getDummyMarkers () {
       LatLng location1 = new LatLng(49.019916, 12.093047);
        MarkerItem marker1 = new MarkerItem("Arcaden", location1,"am brunnen unter der ersten stufe",1);

        LatLng location2 = new LatLng(49.021210, 12.096888);
        MarkerItem marker2 = new MarkerItem("Steinerne Brücke", location2,"am baugerüst blalbla fülltext following exemple demonstrates",2);

        LatLng location3 = new LatLng(49.019353, 12.098003);
        MarkerItem marker3 = new MarkerItem("DomTAG", location3, "füll füll abcdefg lalla mehr text test test ",3);

        ArrayList <MarkerItem> markerArrayList = new ArrayList();

        markerArrayList.add(marker1);
        markerArrayList.add(marker2);
        markerArrayList.add(marker3);

        return markerArrayList;
    }



}
