package com.clabuyakchai.user.data.repository.Impl;

import com.clabuyakchai.user.data.local.AppDatabase;
import com.clabuyakchai.user.data.remote.StaffApi;
import com.clabuyakchai.user.data.remote.request.BookingDto;
import com.clabuyakchai.user.data.repository.BookRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class BookRepositoryImpl implements BookRepository {
    private final StaffApi staffApi;
    private final AppDatabase database;

    @Inject
    public BookRepositoryImpl(StaffApi staffApi, AppDatabase database) {
        this.staffApi = staffApi;
        this.database = database;
    }

    @Override
    public Single<List<BookingDto>> findBookingByLocalIdAndDatetime(String datetime) {
        return database.userDao().getUser().subscribeOn(Schedulers.io())
                .flatMap(users -> staffApi.findBookingByLocalIdAndDatetime(users.get(0).getUserID(), datetime));
    }

    @Override
    public Completable cancelBook(Long bookId) {
        return staffApi.cancelBook(bookId);
    }

    @Override
    public Completable createBook(Long timetableId) {
        return database.userDao().getUser().subscribeOn(Schedulers.io())
                .flatMap(users -> staffApi.createBook(users.get(0).getUserID(), timetableId).toSingle(() -> "")).ignoreElement();
    }
}
