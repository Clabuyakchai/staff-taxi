package com.clabuyakchai.user.data.repository.Impl;

import com.clabuyakchai.user.data.local.AppDatabase;
import com.clabuyakchai.user.data.local.entity.User;
import com.clabuyakchai.user.data.remote.StaffApi;
import com.clabuyakchai.user.data.remote.request.BusDto;
import com.clabuyakchai.user.data.remote.request.LocalDto;
import com.clabuyakchai.user.data.remote.request.StaffDto;
import com.clabuyakchai.user.data.repository.HomeRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
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
    public Single<User> updateInformationAboutMe(User user) {
        return database.userDao().getUser().subscribeOn(Schedulers.io())
                .flatMap(st -> {
                    if (st.get(0).getDriver()) {
                        user.setUserID(st.get(0).getUserID());
                        user.setGender(st.get(0).getGender());
                        return staffApi.updateStaff(mapUserToStaffDto(user))
                                .flatMap(staffDto -> {
                                    database.userDao().insert(mapStaffDtoToUser(staffDto));
                                    return Single.just(mapStaffDtoToUser(staffDto));
                                });
                    } else {
                        user.setUserID(st.get(0).getUserID());
                        user.setGender(st.get(0).getGender());
                        return staffApi.updateLocal(mapUserToLocalDto(user))
                                .flatMap(localDto -> {
                                    database.userDao().insert(mapLocalDtoToUser(localDto));
                                    return Single.just(mapLocalDtoToUser(localDto));
                                });
                    }
                });
    }

    @Override
    public Single<User> getInformationAboutMeFromDb() {
        return database.userDao().getUser().subscribeOn(Schedulers.io())
                .flatMap(users -> Single.just(users.get(0)));
    }

    @Override
    public void deleteStaffFromDb() {
        new Thread(() -> database.userDao().delete()).start();
    }

    @Override
    public Single<List<BusDto>> getAllBus() {
        return staffApi.findAllBus();
    }

    @Override
    public Single<BusDto> getBusByStaffId() {
        return database.userDao().getUser().subscribeOn(Schedulers.io())
                .flatMap(staff ->
                        staffApi.findBusByStaffId(staff.get(0).getUserID())
                );
    }

    @Override
    public Single<BusDto> addBus(BusDto busDto) {
        return staffApi.addBus(busDto);
    }

    @Override
    public Completable driveBus(Long busId) {
        return database.userDao().getUser().subscribeOn(Schedulers.io())
                .flatMap(staff -> staffApi.driveBus(staff.get(0).getUserID(), busId).toSingle(() -> "")).ignoreElement();
    }

    @Override
    public Single<User> whoAmI() {
        return staffApi.whoAmIFromLocal()
                .flatMap(localDto -> {
                    if (localDto.getLocalID() == null) {
                        return staffApi.whoAmIFromStaff()
                                .flatMap(staffDto -> {
                                    database.userDao().insert(mapStaffDtoToUser(staffDto));
                                    return Single.just(mapStaffDtoToUser(staffDto));
                                });
                    } else {
                        database.userDao().insert(mapLocalDtoToUser(localDto));
                        return Single.just(mapLocalDtoToUser(localDto));
                    }
                });
    }

    @Override
    public Completable addStaff(String phone) {
        return staffApi.addStaff(phone);
    }

    private User mapStaffDtoToUser(StaffDto staffDto) {
        User user = new User();
        user.setUserID(staffDto.getStaffID());
        user.setName(staffDto.getName());
        user.setPhone(staffDto.getPhone());
        user.setEmail(staffDto.getEmail());
        user.setGender(staffDto.getGender());
        user.setAddress(staffDto.getAddress());
        user.setDriver(true);
        return user;
    }

    private User mapLocalDtoToUser(LocalDto localDto) {
        User user = new User();
        user.setUserID(localDto.getLocalID());
        user.setName(localDto.getName());
        user.setPhone(localDto.getPhone());
        user.setEmail(localDto.getEmail());
        user.setGender(localDto.getGender());
        return user;
    }

    private StaffDto mapStaffToStaffDto(List<User> users) {
        return new StaffDto(users.get(0).getUserID(),
                users.get(0).getPhone(),
                users.get(0).getEmail(),
                users.get(0).getGender(),
                users.get(0).getName(),
                users.get(0).getAddress());
    }

    private StaffDto mapUserToStaffDto(User user) {
        return new StaffDto(user.getUserID(),
                user.getPhone(),
                user.getEmail(),
                user.getGender(),
                user.getName(),
                user.getAddress());
    }

    private LocalDto mapUserToLocalDto(User user) {
        return new LocalDto(user.getUserID(),
                user.getPhone(),
                user.getEmail(),
                user.getGender(),
                user.getName());
    }
}
