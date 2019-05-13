package com.clabuyakchai.user.ui.activity.navigation;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface NavigationView extends MvpView {
    void showDriverFunction(Boolean isDriver);
    void showSnackBar(String text);
}
