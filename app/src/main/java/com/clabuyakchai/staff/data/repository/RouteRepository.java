package com.clabuyakchai.staff.data.repository;

import com.clabuyakchai.staff.data.remote.request.LocalDto;
import com.clabuyakchai.staff.data.remote.request.RouteDto;

import java.util.List;

import io.reactivex.Single;

public interface RouteRepository {
    Single<List<RouteDto>> findRouteByStaffAndTime(String datetime);
    Single<List<LocalDto>> findLocalByRouteId(Long routeId);
}
