package com.clabuyakchai.user.ui.fragment.navigation.station.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import com.clabuyakchai.user.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.ClusterManager;
import com.google.maps.android.clustering.view.DefaultClusterRenderer;
import com.google.maps.android.ui.IconGenerator;

public class ClusterRenderer extends DefaultClusterRenderer<StationItem> {
    private final int markerWidth;
    private final int markerHeight;
    private Context context;

    public ClusterRenderer(Context context, GoogleMap map, ClusterManager<StationItem> clusterManager) {
        super(context, map, clusterManager);

        this.context = context;
        markerWidth = (int) context.getResources().getDimension(R.dimen.custom_marker_width);
        markerHeight = (int) context.getResources().getDimension(R.dimen.custom_marker_height);
    }

    @Override
    protected void onBeforeClusterItemRendered(StationItem item, MarkerOptions markerOptions) {
        IconGenerator iconGenerator = new IconGenerator(context);
        Drawable marker = context.getResources().getDrawable(R.drawable.bg_marker);
        iconGenerator.setBackground(marker);

        Bitmap icon = Bitmap.createScaledBitmap(iconGenerator.makeIcon(), markerWidth, markerHeight, false);
        markerOptions.icon(BitmapDescriptorFactory.fromBitmap(icon));
    }
}
