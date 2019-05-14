package com.clabuyakchai.user.ui.fragment.navigation.book;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.clabuyakchai.user.data.remote.request.BookingDto;

import java.util.List;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface BookView extends MvpView {
    void setRouteAdapter(List<BookingDto> list);
}
