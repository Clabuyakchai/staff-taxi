package com.clabuyakchai.staff.ui.fragment.auth.registration;

import com.arellomobile.mvp.InjectViewState;
import com.clabuyakchai.staff.data.remote.request.StaffDto;
import com.clabuyakchai.staff.data.repository.AuthRepository;
import com.clabuyakchai.staff.ui.base.BasePresenter;

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

    public void signUp(StaffDto staffDto){
        Disposable disposable = authRepository.signUp(staffDto)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(responseBody -> {
                    if (responseBody != null){
                        getViewState().addToken(responseBody.string());
                        getViewState().navActivity();
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
