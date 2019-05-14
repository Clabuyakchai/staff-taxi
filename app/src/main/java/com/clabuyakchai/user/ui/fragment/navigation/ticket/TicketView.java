package com.clabuyakchai.user.ui.fragment.navigation.ticket;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.clabuyakchai.user.data.remote.request.RouteDto;

import java.util.List;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface TicketView extends MvpView {
    void setAdapter(List<RouteDto> list);
}
