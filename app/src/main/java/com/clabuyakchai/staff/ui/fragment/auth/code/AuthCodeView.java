package com.clabuyakchai.staff.ui.fragment.auth.code;

import com.arellomobile.mvp.MvpView;

public interface AuthCodeView extends MvpView {
    void showToast(String text);
    void navActivity();
    void registrationFragment();
}
