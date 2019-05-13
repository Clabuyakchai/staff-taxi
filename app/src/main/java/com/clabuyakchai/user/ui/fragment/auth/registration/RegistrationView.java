package com.clabuyakchai.user.ui.fragment.auth.registration;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface RegistrationView extends MvpView {
    void addToken(String token);
    void navActivity();
    @StateStrategyType(SkipStrategy.class)
    void showSnackBar(String text);
}
