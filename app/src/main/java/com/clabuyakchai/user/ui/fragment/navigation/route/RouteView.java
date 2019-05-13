package com.clabuyakchai.user.ui.fragment.navigation.route;

import com.arellomobile.mvp.MvpView;
import com.clabuyakchai.user.data.remote.request.RouteDto;

import java.util.List;

public interface RouteView extends MvpView {
    void setRouteAdapter(List<RouteDto> list);
}
