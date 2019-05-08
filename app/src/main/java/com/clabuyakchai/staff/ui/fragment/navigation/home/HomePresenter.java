package com.clabuyakchai.staff.ui.fragment.navigation.home;

import com.arellomobile.mvp.InjectViewState;
import com.clabuyakchai.staff.data.repository.HomeRepository;
import com.clabuyakchai.staff.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

@InjectViewState
public class HomePresenter extends BasePresenter<HomeView> {
    private final HomeRepository homeRepository;

    @Inject
    public HomePresenter(HomeRepository homeRepository) {
        this.homeRepository = homeRepository;
    }

    @Override
    public void onViewCreated() {
        super.onViewCreated();
        getInformationAboutMeFromServer();
    }

    public void getInformationAboutMeFromServer(){
        Disposable disposable = homeRepository.getInformationAboutMeFromServer()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(staffDto -> getViewState().setField(staffDto), Throwable::printStackTrace);

        compositeDisposable.add(disposable);
    }

    @Override
    public void onViewDestroy() {
        super.onViewDestroy();
    }
}
