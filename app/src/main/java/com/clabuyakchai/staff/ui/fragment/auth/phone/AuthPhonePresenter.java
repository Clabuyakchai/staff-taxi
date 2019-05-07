package com.clabuyakchai.staff.ui.fragment.auth.phone;

import com.arellomobile.mvp.InjectViewState;
import com.clabuyakchai.staff.data.repository.AuthRepository;
import com.clabuyakchai.staff.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

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
        if (authRepository.isUserSignedIn()) {
            getViewState().navActivity();
        }
    }

    @Override
    public void onViewDestroy() {
        super.onViewDestroy();
    }

    public void sendVerificationPhone(String phone) {
        signIn(phone.substring(1));
        authRepository.startVerification(phone);
    }

    private void signIn(String phone) {
        Disposable disposable = authRepository.signIn(phone)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    if (s != null) {
                        String token = s.string();
                        getViewState().addToken(token);
                        if (authRepository.isUserSignedIn() && !token.isEmpty()) {
                            getViewState().navActivity();
                        } else {
                            getViewState().codeFragment();
                        }
                    }
                }, Throwable::printStackTrace);

        compositeDisposable.add(disposable);
    }
}
