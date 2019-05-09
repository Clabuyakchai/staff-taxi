package com.clabuyakchai.staff.ui.fragment.navigation.home;

import com.arellomobile.mvp.InjectViewState;
import com.clabuyakchai.staff.data.local.entity.Staff;
import com.clabuyakchai.staff.data.repository.AuthRepository;
import com.clabuyakchai.staff.data.repository.HomeRepository;
import com.clabuyakchai.staff.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

@InjectViewState
public class HomePresenter extends BasePresenter<HomeView> {
    private final HomeRepository homeRepository;
    private final AuthRepository authRepository;

    @Inject
    public HomePresenter(HomeRepository homeRepository, AuthRepository authRepository) {
        this.homeRepository = homeRepository;
        this.authRepository = authRepository;
    }

    @Override
    public void onViewCreated() {
        super.onViewCreated();
        getInformationAboutMeFromDb();
    }

    public void getInformationAboutMeFromDb(){
        Disposable disposable = homeRepository.getInformationAboutMeFromDb()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(staffDto -> getViewState().setField(staffDto), Throwable::printStackTrace);

        compositeDisposable.add(disposable);
    }

    public void signOut(){
        authRepository.signOut();
        deleteStaffFromDb();
        getViewState().signOut();
    }

    public void pressEditUser(Boolean enabled){
        getViewState().setEnabledEdTxt(enabled);
    }

    public void updateUser(Staff staff){
        Disposable disposable = homeRepository.updateInformationAboutMe(staff)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(staffDto -> {
                    getViewState().setField(staffDto);
                }, Throwable::printStackTrace);

        compositeDisposable.add(disposable);
    }

    private void deleteStaffFromDb(){
        homeRepository.deleteStaffFromDb();
    }

    @Override
    public void onViewDestroy() {
        super.onViewDestroy();
    }
}
