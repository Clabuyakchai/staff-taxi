package com.clabuyakchai.staff.ui.activity.navigation;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.clabuyakchai.staff.util.Screens;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class NavigationActivityPresenter extends MvpPresenter<NavigationView> {
    private final Router router;

    @Inject
    public NavigationActivityPresenter(Router router) {
        this.router = router;
    }

    public void onRouteClicked(){
        router.replaceScreen(new Screens.TabScreen("Route"));
    }

    public void onStationClicked(){
        router.replaceScreen(new Screens.TabScreen("Station"));
    }

    public void onHomeClicked(){
        router.replaceScreen(new Screens.TabScreen("Home"));
    }

    public void onBackPressed() {
        router.exit();
    }
}
