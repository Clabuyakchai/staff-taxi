package com.clabuyakchai.staff.ui.fragment.auth.phone;

import com.arellomobile.mvp.InjectViewState;
import com.clabuyakchai.staff.data.interactor.AuthInteractor;
import com.clabuyakchai.staff.ui.base.BasePresenter;

import javax.inject.Inject;

@InjectViewState
public class AuthPhonePresenterImpl extends BasePresenter<AuthPhoneView> implements AuthPhonePresenter {
    private final AuthInteractor authInteractor;

    @Inject
    public AuthPhonePresenterImpl(AuthInteractor authInteractor) {
        this.authInteractor = authInteractor;
    }

    @Override
    public void onViewCreated() {
        super.onViewCreated();
    }

    @Override
    public void onViewDestroy() {
        super.onViewDestroy();
    }

    @Override
    public void sendVerificationPhone(String phone) {
        authInteractor.startVerification(phone);
    }
}
