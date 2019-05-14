package com.clabuyakchai.user.ui.fragment.navigation.ticketdetail;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface TicketDetailView extends MvpView {
    @StateStrategyType(SkipStrategy.class)
    void showSnackBar(String text);
}
