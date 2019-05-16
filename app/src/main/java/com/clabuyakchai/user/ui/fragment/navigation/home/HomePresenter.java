package com.clabuyakchai.user.ui.fragment.navigation.home;

import com.arellomobile.mvp.InjectViewState;
import com.clabuyakchai.user.data.local.entity.User;
import com.clabuyakchai.user.data.repository.AuthRepository;
import com.clabuyakchai.user.data.repository.HomeRepository;
import com.clabuyakchai.user.ui.base.BasePresenter;
import com.clabuyakchai.user.util.Screens;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import ru.terrakok.cicerone.Router;

@InjectViewState
public class HomePresenter extends BasePresenter<HomeView> {
    private final HomeRepository homeRepository;
    private final AuthRepository authRepository;
    private Router router;

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

    public void setRouter(Router router) {
        this.router = router;
    }

    public void busFragment() {
        router.navigateTo(new Screens.BusScreen());
    }

    public void getInformationAboutMeFromDb() {
        Disposable disposable = homeRepository.getInformationAboutMeFromDb()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(user -> {
                    if (user.getDriver()) {
                        findBusByStaffId();
                    }
                    getViewState().setVisibility(user.getDriver());
                    getViewState().setField(user);
                }, Throwable::printStackTrace);

        compositeDisposable.add(disposable);
    }

    public void signOut() {
        authRepository.signOut();
        deleteStaffFromDb();
        getViewState().signOut();
    }

    public void pressEditUser(Boolean enabled) {
        getViewState().setEnabledEdTxt(enabled);
    }

    public void updateUser(User user) {
        Disposable disposable = homeRepository.updateInformationAboutMe(user)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(staffDto -> {
                    getViewState().setField(staffDto);
                }, Throwable::printStackTrace);

        compositeDisposable.add(disposable);
    }

    private void findBusByStaffId() {
        Disposable disposable = homeRepository.getBusByStaffId()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(busDto -> {
                    getViewState().setFiledBus(busDto);
                }, Throwable::printStackTrace);
        compositeDisposable.add(disposable);
    }

    public void onAddStaffClicked() {
        getViewState().setVisibilityNewStaff(true);
    }

    public void onSaveStaffClicked(String phone) {
        getViewState().setVisibilityNewStaff(false);
        addStaff(phone);
    }

    private void addStaff(String phone) {
        Disposable disposable = homeRepository.addStaff(phone)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> getViewState().showSnackBar(phone + " became a driver"), Throwable::printStackTrace);
        compositeDisposable.add(disposable);
    }

    private void deleteStaffFromDb() {
        homeRepository.deleteStaffFromDb();
    }

    @Override
    public void onViewDestroy() {
        super.onViewDestroy();
    }

    public void onBackPressed() {
        router.exit();
    }
}
