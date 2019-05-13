package com.clabuyakchai.user.ui.fragment.auth.code;

import com.arellomobile.mvp.InjectViewState;
import com.clabuyakchai.user.data.repository.AuthRepository;
import com.clabuyakchai.user.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

@InjectViewState
public class AuthCodePresenter extends BasePresenter<AuthCodeView> {
    private final AuthRepository authRepository;

    @Inject
    public AuthCodePresenter(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public void verifyCode(String code, String phone) {
        Disposable disposable = authRepository.verifyWithCode(code).subscribe(aBoolean -> {
            if (aBoolean) {
                signIn(phone);
            } else {
                // TODO неверный код, что будем делать
            }
        }, Throwable::printStackTrace);
        compositeDisposable.add(disposable);
    }

    private void signIn(String phone) {
        Disposable disposable = authRepository.signIn(phone)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    if (s != null) {
                        String token = s.string();
                        getViewState().addToken(token);
                        getViewState().navActivity();
//                        getViewState().showSnackBar("NavigationActivity");
                    } else {
                        getViewState().registrationFragment(phone);
                    }
                }, Throwable::printStackTrace);

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
