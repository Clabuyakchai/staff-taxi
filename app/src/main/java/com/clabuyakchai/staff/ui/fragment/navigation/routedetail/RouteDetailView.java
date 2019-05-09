package com.clabuyakchai.staff.ui.fragment.navigation.routedetail;

import com.arellomobile.mvp.MvpView;
import com.clabuyakchai.staff.data.remote.request.LocalDto;

import java.util.List;

public interface RouteDetailView extends MvpView {
    void setRouteDetailAdapter(List<LocalDto> list);
}
