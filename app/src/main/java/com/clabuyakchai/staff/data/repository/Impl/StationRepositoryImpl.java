package com.clabuyakchai.staff.data.repository.Impl;

import com.clabuyakchai.staff.data.remote.StaffApi;
import com.clabuyakchai.staff.data.remote.request.StationDto;
import com.clabuyakchai.staff.data.repository.StationRepository;
import com.clabuyakchai.staff.ui.fragment.navigation.station.map.StationItem;

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
}
