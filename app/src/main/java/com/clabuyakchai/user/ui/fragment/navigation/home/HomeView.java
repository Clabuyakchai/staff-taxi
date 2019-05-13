package com.clabuyakchai.user.ui.fragment.navigation.home;

import com.arellomobile.mvp.MvpView;
import com.clabuyakchai.user.data.local.entity.User;
import com.clabuyakchai.user.data.remote.request.BusDto;
import com.clabuyakchai.user.data.remote.request.StaffDto;

public interface HomeView extends MvpView {
    void setField(User user);
    void signOut();
    void setEnabledEdTxt(Boolean enabled);
    void setFiledBus(BusDto bus);
    void setVisibility(Boolean isDriver);
}
