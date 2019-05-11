package com.clabuyakchai.staff.ui.fragment.navigation.station;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.clabuyakchai.staff.ui.fragment.navigation.station.map.StationItem;

import java.util.List;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface StationView extends MvpView {
    void setMarker(List<StationItem> stationItems);
    void setMarker(StationItem stationItem);
}
