package com.clabuyakchai.user.data.repository.Impl;

import com.clabuyakchai.user.data.remote.StaffApi;
import com.clabuyakchai.user.data.remote.request.StationDto;
import com.clabuyakchai.user.data.repository.StationRepository;
import com.clabuyakchai.user.ui.fragment.navigation.newroute.adapter.StationItemWithSwitch;
import com.clabuyakchai.user.ui.fragment.navigation.station.map.StationItem;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class StationRepositoryImpl implements StationRepository {
    private final StaffApi staffApi;

    @Inject
    public StationRepositoryImpl(StaffApi staffApi) {
        this.staffApi = staffApi;
    }

    @Override
    public Single<StationItem> addStation(StationDto stationDto) {
        return staffApi.addStation(stationDto)
                .flatMap(station -> Single.just(mapStationDtoToStationItem(station)));
    }

    @Override
    public Single<List<StationItem>> getAllStationByCity(String city) {
        return staffApi.getAllStationByCity(city)
                .flatMap(stationDtos -> Single.just(mapStationDtoToStationItem(stationDtos)));
    }

    @Override
    public Single<List<StationDto>> getAllStationByCityDto(String city) {
        return staffApi.getAllStationByCity(city);
    }

    @Override
    public Single<List<StationItemWithSwitch>> getAllStationByCityDto(String city1, String city2) {
        return staffApi.getAllStationByCity(city1)
                .flatMap(station1 -> staffApi.getAllStationByCity(city2)
                        .flatMap(station2 -> {
                            List<StationItemWithSwitch> list = new ArrayList<>();
                            list.addAll(mapForRecycler(station1));
                            list.addAll(mapForRecycler(station2));
                            return Single.just(list);
                        }));
    }

    @Override
    public Single<List<StationItem>> getAllStation() {
        return staffApi.getAllStation()
                .flatMap(stationDtos -> Single.just(mapStationDtoToStationItem(stationDtos)));
    }

    private List<StationItem> mapStationDtoToStationItem(List<StationDto> stationDtos) {
        List<StationItem> list = new ArrayList<>();
        for (StationDto s : stationDtos) {
            list.add(new StationItem(s.getLat(), s.getLng(), String.valueOf(s.getStationID()), s.getCity() + ", " + s.getName()));
        }

        return list;
    }

    private StationItem mapStationDtoToStationItem(StationDto stationDto) {
        return new StationItem(stationDto.getLat(),
                stationDto.getLng(),
                String.valueOf(stationDto.getStationID()),
                stationDto.getCity() + ", " + stationDto.getName());
    }

    private List<StationItemWithSwitch> mapForRecycler(List<StationDto> list) {
        List<StationItemWithSwitch> stationList = new ArrayList<>();
        for (StationDto s : list) {
            stationList.add(new StationItemWithSwitch(s.getStationID(),
                    s.getName(),
                    s.getCity(),
                    s.getLat(),
                    s.getLng()));
        }
        return stationList;
    }
}
