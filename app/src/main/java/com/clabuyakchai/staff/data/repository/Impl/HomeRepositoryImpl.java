package com.clabuyakchai.staff.data.repository.Impl;

import com.clabuyakchai.staff.data.local.AppDatabase;
import com.clabuyakchai.staff.data.local.entity.Staff;
import com.clabuyakchai.staff.data.remote.StaffApi;
import com.clabuyakchai.staff.data.remote.request.StaffDto;
import com.clabuyakchai.staff.data.repository.HomeRepository;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class HomeRepositoryImpl implements HomeRepository {
    private final StaffApi staffApi;
    private final AppDatabase database;

    @Inject
    public HomeRepositoryImpl(StaffApi staffApi, AppDatabase database) {
        this.staffApi = staffApi;
        this.database = database;
    }

    @Override
    public Single<StaffDto> getInformationAboutMeFromServer() {
        return staffApi.getStaff().subscribeOn(Schedulers.io());
    }

    @Override
    public void updateInformationAboutMe(StaffDto staffDto) {

    }

    @Override
    public Single<Staff> getInformationAboutMeFromDb() {
        return null;
    }
}
