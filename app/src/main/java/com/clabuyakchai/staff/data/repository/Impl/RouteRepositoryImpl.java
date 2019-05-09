package com.clabuyakchai.staff.data.repository.Impl;

import com.clabuyakchai.staff.data.local.AppDatabase;
import com.clabuyakchai.staff.data.remote.StaffApi;
import com.clabuyakchai.staff.data.remote.request.LocalDto;
import com.clabuyakchai.staff.data.remote.request.RouteDto;
import com.clabuyakchai.staff.data.repository.RouteRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class RouteRepositoryImpl implements RouteRepository {
    private final StaffApi staffApi;
    private final AppDatabase database;

    @Inject
    public RouteRepositoryImpl(StaffApi staffApi, AppDatabase database) {
        this.staffApi = staffApi;
        this.database = database;
    }

    @Override
    public Single<List<RouteDto>> findRouteByStaffAndTime(String datetime) {
        return database.staffDao().getStaff().subscribeOn(Schedulers.io())
                .flatMap(staff -> staffApi.findRouteByStaff(datetime, staff.get(0).getName()));
    }

    @Override
    public Single<List<LocalDto>> findLocalByRouteId(Long routeId) {
        return staffApi.findLocalByRouteId(routeId);
    }
}
