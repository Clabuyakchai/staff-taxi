package com.clabuyakchai.user.ui.fragment.navigation.station.map;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterItem;

public class StationItem implements ClusterItem {
    private LatLng latLng;
    private String title;
    private String snippet;

    public StationItem(String lat, String lng, String title, String snippet) {
        this.latLng = new LatLng(Double.parseDouble(lat), Double.parseDouble(lng));
        this.title = title;
        this.snippet = snippet;
    }


    @Override
    public LatLng getPosition() {
        return latLng;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getSnippet() {
        return snippet;
    }
}
