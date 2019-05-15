package com.clabuyakchai.user.ui.activity.navigation;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.clabuyakchai.user.data.local.entity.User;
import com.clabuyakchai.user.data.repository.HomeRepository;
import com.clabuyakchai.user.util.Screens;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import ru.terrakok.cicerone.Router;

@InjectViewState
public class NavigationActivityPresenter extends MvpPresenter<NavigationView> {
    private final HomeRepository homeRepository;
    private final Router router;
    private CompositeDisposable compositeDisposable;

    @Inject
    public NavigationActivityPresenter(HomeRepository homeRepository, Router router) {
        this.homeRepository = homeRepository;
        this.router = router;
    }

    public void onRouteClicked() {
        router.replaceScreen(new Screens.TabScreen("Route"));
    }

    public void onStationClicked() {
        router.replaceScreen(new Screens.TabScreen("Station"));
    }

    public void onHomeClicked() {
        router.replaceScreen(new Screens.TabScreen("Home"));
    }

    public void onBookClicked() {
        router.replaceScreen(new Screens.TabScreen("Book"));
    }

    public void onTicketClicked() {
        router.replaceScreen(new Screens.TabScreen("Ticket"));
    }

    public void onBackPressed() {
        router.exit();
    }

    private void whoAmI() {
        Disposable disposable = homeRepository.whoAmI()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(user -> {
                    getViewState().showDriverFunction(user.getDriver());
                    getViewState().showSnackBar(user.getDriver().toString());
                }, Throwable::printStackTrace);

    }

    void onCreateActivity() {
        this.compositeDisposable = new CompositeDisposable();
        whoAmI();
    }

    void onDestroyActivity() {
        compositeDisposable.dispose();
    }

}
