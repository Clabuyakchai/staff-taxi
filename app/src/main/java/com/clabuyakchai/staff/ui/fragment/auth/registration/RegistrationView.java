package com.clabuyakchai.staff.ui.fragment.auth.registration;

import com.arellomobile.mvp.MvpView;

public interface RegistrationView extends MvpView {
    void addToken(String token);
    void navActivity();
}
