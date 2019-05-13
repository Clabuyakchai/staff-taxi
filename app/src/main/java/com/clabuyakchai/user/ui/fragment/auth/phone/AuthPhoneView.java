package com.clabuyakchai.user.ui.fragment.auth.phone;


import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface AuthPhoneView extends MvpView {
    void codeFragment(String phone);
    void navActivity();
    void getToken();
    @StateStrategyType(SkipStrategy.class)
    void showSnackBar(String text);
}
