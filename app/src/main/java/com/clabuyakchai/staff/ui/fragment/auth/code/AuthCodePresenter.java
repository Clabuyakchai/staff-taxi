package com.clabuyakchai.staff.ui.fragment.auth.code;

import com.arellomobile.mvp.InjectViewState;
import com.clabuyakchai.staff.data.repository.AuthRepository;
import com.clabuyakchai.staff.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;

@InjectViewState
public class AuthCodePresenter extends BasePresenter<AuthCodeView> {
    private final AuthRepository authRepository;

    @Inject
    public AuthCodePresenter(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public void verifyCode(String code, String token) {
        Disposable disposable = authRepository.verifyWithCode(code).subscribe(aBoolean -> {
            if (aBoolean && token != null && !token.isEmpty()) {
                getViewState().navActivity();
            } else {
                getViewState().registrationFragment();
            }
        });

        compositeDisposable.add(disposable);
    }

    @Override
    public void onViewCreated() {
        super.onViewCreated();
    }

    @Override
    public void onViewDestroy() {
        super.onViewDestroy();
    }
}
