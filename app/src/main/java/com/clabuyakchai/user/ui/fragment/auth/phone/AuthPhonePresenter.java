package com.clabuyakchai.user.ui.fragment.auth.phone;

import com.arellomobile.mvp.InjectViewState;
import com.clabuyakchai.user.data.repository.AuthRepository;
import com.clabuyakchai.user.ui.base.BasePresenter;

import javax.inject.Inject;

@InjectViewState
public class AuthPhonePresenter extends BasePresenter<AuthPhoneView> {
    private final AuthRepository authRepository;

    @Inject
    public AuthPhonePresenter(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    @Override
    public void onViewCreated() {
        super.onViewCreated();
        getViewState().getToken();
    }

    @Override
    public void onViewDestroy() {
        super.onViewDestroy();
    }

    public void isVerify(String token){
        if (authRepository.isUserSignedIn() && token != null && !token.isEmpty()) {
            getViewState().navActivity();
//            getViewState().showSnackBar("NavigationActivity");
        }
    }

    public void sendVerificationPhone(String phone) {
        authRepository.startVerification(phone);
        getViewState().codeFragment(phone);
    }
}
