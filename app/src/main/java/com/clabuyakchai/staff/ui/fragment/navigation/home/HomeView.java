package com.clabuyakchai.staff.ui.fragment.navigation.home;

import com.arellomobile.mvp.MvpView;
import com.clabuyakchai.staff.data.remote.request.BusDto;
import com.clabuyakchai.staff.data.remote.request.StaffDto;

import java.util.List;

public interface HomeView extends MvpView {
    void setField(StaffDto staffDto);
    void signOut();
    void setEnabledEdTxt(Boolean enabled);
    void setFiledBus(BusDto bus);
}
