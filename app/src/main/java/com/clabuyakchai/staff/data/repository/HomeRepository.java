package com.clabuyakchai.staff.data.repository;

import com.clabuyakchai.staff.data.local.entity.Staff;
import com.clabuyakchai.staff.data.remote.request.StaffDto;

import io.reactivex.Single;

public interface HomeRepository {
    void updateInformationAboutMe(StaffDto staffDto);
    Single<StaffDto> getInformationAboutMeFromDb();
    void deleteStaffFromDb();
}
