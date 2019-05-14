package com.clabuyakchai.user.data.repository.Impl;

import com.clabuyakchai.user.data.local.AppDatabase;
import com.clabuyakchai.user.data.remote.StaffApi;
import com.clabuyakchai.user.data.remote.request.LocalDto;
import com.clabuyakchai.user.data.remote.request.RouteDto;
import com.clabuyakchai.user.data.remote.request.StationDto;
import com.clabuyakchai.user.data.repository.RouteRepository;
import com.clabuyakchai.user.ui.fragment.navigation.newroute.adapter.StationItemWithSwitch;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
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
        return database.userDao().getUser().subscribeOn(Schedulers.io())
                .flatMap(staff -> staffApi.findRouteByStaff(datetime, staff.get(0).getName()));
    }

    @Override
    public Single<List<LocalDto>> findLocalByRouteId(Long routeId) {
        return staffApi.findLocalByRouteId(routeId);
    }

    @Override
    public Completable createRoute(RouteDto routeDto, List<StationItemWithSwitch> stations) {
        routeDto.setStations(mapForRequest(stations));
        return database.userDao().getUser().subscribeOn(Schedulers.io())
                .flatMap(staff -> staffApi.findBusByStaffId(staff.get(0).getUserID())
                        .flatMap(busDto -> {
                            routeDto.setBus(busDto);
                            return staffApi.createRoute(routeDto).toSingle(() -> "");
                        })).ignoreElement();
    }

    @Override
    public Single<List<RouteDto>> findRouteByParam(String from, String to, String datetime) {
        return staffApi.findRouteByParam(from, to, datetime);
    }

    private List<StationDto> mapForRequest(List<StationItemWithSwitch> stations){
        List<StationDto> list = new ArrayList<>();
        for (StationItemWithSwitch s: stations) {
            list.add(new StationDto(s.getStationID(),
                    s.getName(),
                    s.getCity(),
                    s.getLat(),
                    s.getLng()));
        }

        return list;
    }
}
