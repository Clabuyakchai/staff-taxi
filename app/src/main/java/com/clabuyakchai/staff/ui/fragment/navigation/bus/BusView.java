package com.clabuyakchai.staff.ui.fragment.navigation.bus;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.clabuyakchai.staff.data.remote.request.BusDto;

import java.util.List;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface BusView extends MvpView {
    void setBusAdapter(List<BusDto> list);
    void setItemInBusAdapter(BusDto bus);
    @StateStrategyType(SkipStrategy.class)
    void showSnackBar(String text);
}
