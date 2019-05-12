package com.clabuyakchai.staff.data.repository;

import com.clabuyakchai.staff.data.remote.request.StationDto;
import com.clabuyakchai.staff.ui.fragment.navigation.newroute.adapter.StationItemWithSwitch;
import com.clabuyakchai.staff.ui.fragment.navigation.station.map.StationItem;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface StationRepository {
    Single<StationItem> addStation(StationDto stationDto);
    Single<List<StationItem>> getAllStationByCity(String city);
    Single<List<StationDto>> getAllStationByCityDto(String city);
    Single<List<StationItemWithSwitch>> getAllStationByCityDto(String city1, String city2);
    Single<List<StationItem>> getAllStation();
}
