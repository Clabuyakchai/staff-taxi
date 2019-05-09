package com.clabuyakchai.staff.data.repository.Impl;

import com.clabuyakchai.staff.data.local.AppDatabase;
import com.clabuyakchai.staff.data.local.entity.Staff;
import com.clabuyakchai.staff.data.remote.StaffApi;
import com.clabuyakchai.staff.data.remote.request.StaffDto;
import com.clabuyakchai.staff.data.repository.HomeRepository;

import java.util.List;

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

    private Single<StaffDto> getInformationAboutMeFromServer() {
        return staffApi.getStaff();
    }

    @Override
    public Single<StaffDto> updateInformationAboutMe(Staff staff) {
        return database.staffDao().getStaff().subscribeOn(Schedulers.io())
                .flatMap(st -> {
                    st.get(0).setName(staff.getName());
                    st.get(0).setPhone(staff.getPhone());
                    st.get(0).setEmail(staff.getEmail());
                    st.get(0).setAddress(staff.getAddress());
                    return staffApi.updateStaff(mapStaffToStaffDto(st))
                            .flatMap(staffDto -> {
                                if(staffDto != null){
                                    database.staffDao().insert(mapStaffDtotoStaff(staffDto));
                                    return Single.just(staffDto);
                                } else {
                                    return Single.just(mapStaffToStaffDto(st));
                                }
                            });
                });
    }

    @Override
    public Single<StaffDto> getInformationAboutMeFromDb() {
        return database.staffDao().getStaff().subscribeOn(Schedulers.io())
                .flatMap(staff -> {
                    if (staff.isEmpty()) {
                        return getInformationAboutMeFromServer()
                                .flatMap(staffDto -> {
                                    Staff s = mapStaffDtotoStaff(staffDto);
                                    database.staffDao().insert(s);
                                    return Single.just(staffDto);
                                });
                    } else {
                        return Single.just(mapStaffToStaffDto(staff));
                    }
                });
    }

    @Override
    public void deleteStaffFromDb() {
        new Thread(() -> database.staffDao().delete()).start();
    }

    private Staff mapStaffDtotoStaff(StaffDto staffDto) {
        Staff staff = new Staff();
        staff.setStaffID(staffDto.getStaffID());
        staff.setName(staffDto.getName());
        staff.setPhone(staffDto.getPhone());
        staff.setEmail(staffDto.getEmail());
        staff.setGender(staffDto.getGender());
        staff.setAddress(staffDto.getAddress());
        return staff;
    }

    private StaffDto mapStaffToStaffDto(List<Staff> staff) {
        return new StaffDto(staff.get(0).getStaffID(),
                staff.get(0).getPhone(),
                staff.get(0).getEmail(),
                staff.get(0).getGender(),
                staff.get(0).getName(),
                staff.get(0).getAddress());
    }
}
