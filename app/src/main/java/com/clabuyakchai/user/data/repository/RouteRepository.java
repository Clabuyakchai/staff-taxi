package com.clabuyakchai.user.data.repository;

import com.clabuyakchai.user.data.remote.request.BookingDto;
import com.clabuyakchai.user.data.remote.request.LocalDto;
import com.clabuyakchai.user.data.remote.request.RouteDto;
import com.clabuyakchai.user.ui.fragment.navigation.newroute.adapter.StationItemWithSwitch;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface RouteRepository {
    Single<List<RouteDto>> findRouteByStaffAndTime(String datetime);
    Single<List<LocalDto>> findLocalByRouteId(Long routeId);
    Completable createRoute(RouteDto routeDto, List<StationItemWithSwitch> stations);
}
