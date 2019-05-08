package com.clabuyakchai.staff.data.repository;

import com.clabuyakchai.staff.data.local.entity.Staff;
import com.clabuyakchai.staff.data.remote.request.StaffDto;

import io.reactivex.Single;

public interface HomeRepository {
    Single<StaffDto> getInformationAboutMeFromServer();
    void updateInformationAboutMe(StaffDto staffDto);
    Single<Staff> getInformationAboutMeFromDb();
}
