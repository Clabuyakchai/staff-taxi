package com.clabuyakchai.user.ui.fragment.auth.code;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface AuthCodeView extends MvpView {
    @StateStrategyType(SkipStrategy.class)
    void showSnackBar(String text);
    void navActivity();
    void registrationFragment(String phone);
    void addToken(String token);
}
