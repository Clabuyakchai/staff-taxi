package com.clabuyakchai.user.ui.fragment.navigation.book.adapter;

import com.clabuyakchai.user.data.remote.request.BookingDto;

public interface BookListener {
    void onBookItemClicked(BookingDto bookingDto);
}
