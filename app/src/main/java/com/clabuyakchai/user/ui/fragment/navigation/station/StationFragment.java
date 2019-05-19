package com.clabuyakchai.user.ui.fragment.navigation.station;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.clabuyakchai.user.data.remote.request.StationDto;
import com.clabuyakchai.user.ui.base.BaseFragment;
import com.clabuyakchai.user.ui.fragment.navigation.station.dialog.StationDialog;
import com.clabuyakchai.user.ui.fragment.navigation.station.dialog.StationDialogListener;
import com.clabuyakchai.user.ui.fragment.navigation.station.map.ClusterRenderer;
import com.clabuyakchai.user.ui.fragment.navigation.station.map.StationItem;
import com.clabuyakchai.user.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterManager;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class StationFragment extends BaseFragment implements StationView, OnMapReadyCallback, StationDialogListener {
    private static final String TAG_DIALOG = "dialog_station";
    private GoogleMap map;
    private MapView mapView;
    private EditText cityEdt;
    private LatLng latLng;
    private ClusterManager<StationItem> clusterManager;
    @Inject
    Context context;

    @Inject
    @InjectPresenter
    StationPresenter presenter;

    @ProvidePresenter
    StationPresenter provideStationPresenter() {
        return presenter;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.station_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        presenter.onViewCreated();
        MapsInitializer.initialize(view.getContext());
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
        cityEdt = view.findViewById(R.id.station_city);
        cityEdt.setOnEditorActionListener((textView, i, keyEvent) -> {
            if (i == EditorInfo.IME_ACTION_DONE) {
                presenter.onCityEdtDone(cityEdt.getText().toString());
                return true;
            } else {
                return false;
            }
        });

        mapView = view.findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
    }

    public static StationFragment newInstance() {
        return new StationFragment();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        map.setOnMapLongClickListener(mapClickListener);
        clusterManager = new ClusterManager<>(context, map);

        map.setOnCameraIdleListener(clusterManager);
        map.setOnInfoWindowClickListener(clusterManager);
        LatLng belarus = new LatLng(53.9, 27.5);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(belarus, 5.8f));
        ClusterRenderer clusterRenderer = new ClusterRenderer(context, map, clusterManager);
        clusterManager.setRenderer(clusterRenderer);

        presenter.onMapReady();
    }

    private GoogleMap.OnMapLongClickListener mapClickListener = latLng -> {
        this.latLng = latLng;
        StationDialog dialog = StationDialog.newInstance();
        dialog.setTargetFragment(this, 1);
        dialog.show(getFragmentManager(), TAG_DIALOG);
    };

    @Override
    public void onAddButton(String name, String city) {
        presenter.onAddButtonClicked(new StationDto(1L,
                name,
                city,
                String.valueOf(latLng.latitude),
                String.valueOf(latLng.longitude)));
    }

    @Override
    public void setMarker(List<StationItem> stationItems) {
        clusterManager.clearItems();
        clusterManager.addItems(stationItems);
        clusterManager.cluster();
    }

    @Override
    public void setMarker(StationItem stationItem) {
        clusterManager.addItem(stationItem);
        clusterManager.cluster();
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        mapView.onPause();
        super.onPause();
    }

    @Override
    public void onDestroyView() {
        presenter.onViewDestroy();
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        mapView.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }
}
