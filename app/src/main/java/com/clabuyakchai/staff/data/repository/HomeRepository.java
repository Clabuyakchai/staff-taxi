package com.clabuyakchai.staff.data.repository;

import com.clabuyakchai.staff.data.local.entity.Staff;
import com.clabuyakchai.staff.data.remote.request.BusDto;
import com.clabuyakchai.staff.data.remote.request.StaffDto;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface HomeRepository {
    Single<StaffDto> updateInformationAboutMe(Staff staff);
    Single<StaffDto> getInformationAboutMeFromDb();
    void deleteStaffFromDb();
    Single<List<BusDto>> getAllBus();
    Single<BusDto> getBusByStaffId();
    Single<BusDto> addBus(BusDto busDto);
    Completable driveBus(Long busId);
}
