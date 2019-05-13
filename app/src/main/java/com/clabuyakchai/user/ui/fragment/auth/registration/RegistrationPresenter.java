package com.clabuyakchai.user.ui.fragment.auth.registration;

import com.arellomobile.mvp.InjectViewState;
import com.clabuyakchai.user.data.remote.request.LocalDto;
import com.clabuyakchai.user.data.repository.AuthRepository;
import com.clabuyakchai.user.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

@InjectViewState
public class RegistrationPresenter extends BasePresenter<RegistrationView> {
    private final AuthRepository authRepository;

    @Inject
    public RegistrationPresenter(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public void signUp(LocalDto localDto){
        Disposable disposable = authRepository.signUp(localDto)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(responseBody -> {
                    if (responseBody != null){
                        getViewState().addToken(responseBody.string());
                        getViewState().navActivity();
//                        getViewState().showSnackBar("NavigationActivity");
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
