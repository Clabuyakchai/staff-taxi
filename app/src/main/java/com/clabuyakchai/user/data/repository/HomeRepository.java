package com.clabuyakchai.user.data.repository;

import com.clabuyakchai.user.data.local.entity.User;
import com.clabuyakchai.user.data.remote.request.BusDto;
import com.clabuyakchai.user.data.remote.request.StaffDto;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface HomeRepository {
    Single<User> updateInformationAboutMe(User user);
    Single<User> getInformationAboutMeFromDb();
    void deleteStaffFromDb();
    Single<List<BusDto>> getAllBus();
    Single<BusDto> getBusByStaffId();
    Single<BusDto> addBus(BusDto busDto);
    Completable driveBus(Long busId);
    Single<User> whoAmI();
}
