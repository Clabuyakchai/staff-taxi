package com.clabuyakchai.user.data.repository;

import com.clabuyakchai.user.data.remote.request.BookingDto;

import java.util.List;

import io.reactivex.Single;

public interface BookRepository {
    Single<List<BookingDto>> findBookingByLocalIdAndDatetime(String datetime);
}
