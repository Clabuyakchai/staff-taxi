package com.clabuyakchai.user.ui.fragment.navigation.home;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.clabuyakchai.user.data.local.entity.User;
import com.clabuyakchai.user.data.remote.request.BusDto;
import com.clabuyakchai.user.data.remote.request.StaffDto;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface HomeView extends MvpView {
    void setField(User user);
    void signOut();
    void setEnabledEdTxt(Boolean enabled);
    void setFiledBus(BusDto bus);
    void setVisibility(Boolean isDriver);
    void setVisibilityNewStaff(Boolean visibility);
    @StateStrategyType(SkipStrategy.class)
    void showSnackBar(String text);
}
