package com.clabuyakchai.staff.ui.fragment.auth.phone;


import com.arellomobile.mvp.MvpView;

public interface AuthPhoneView extends MvpView {
    void codeFragment();
    void showToast(String text);
    void navActivity();
    void addToken(String token);
}
