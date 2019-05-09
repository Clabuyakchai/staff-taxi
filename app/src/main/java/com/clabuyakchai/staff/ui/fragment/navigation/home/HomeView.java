package com.clabuyakchai.staff.ui.fragment.navigation.home;

import com.arellomobile.mvp.MvpView;
import com.clabuyakchai.staff.data.remote.request.StaffDto;

public interface HomeView extends MvpView {
    void setField(StaffDto staffDto);
    void signOut();
    void setEnabledEdTxt(Boolean enabled);
}
