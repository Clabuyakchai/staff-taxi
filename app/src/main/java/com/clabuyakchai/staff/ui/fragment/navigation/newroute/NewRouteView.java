package com.clabuyakchai.staff.ui.fragment.navigation.newroute;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.clabuyakchai.staff.data.remote.request.StationDto;
import com.clabuyakchai.staff.ui.fragment.navigation.newroute.adapter.StationItemWithSwitch;

import java.util.List;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface NewRouteView extends MvpView {
    @StateStrategyType(SkipStrategy.class)
    void setAdapter(List<StationItemWithSwitch> stations);
    @StateStrategyType(SkipStrategy.class)
    void showSnackBar(String text);
}
