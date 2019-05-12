package com.clabuyakchai.staff.data.repository;

import com.clabuyakchai.staff.data.remote.request.LocalDto;
import com.clabuyakchai.staff.data.remote.request.RouteDto;
import com.clabuyakchai.staff.ui.fragment.navigation.newroute.adapter.StationItemWithSwitch;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface RouteRepository {
    Single<List<RouteDto>> findRouteByStaffAndTime(String datetime);
    Single<List<LocalDto>> findLocalByRouteId(Long routeId);
    Completable createRoute(RouteDto routeDto, List<StationItemWithSwitch> stations);
}
