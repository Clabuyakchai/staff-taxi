package com.clabuyakchai.staff.ui.activity.navigation;

import android.content.Intent;
import android.os.Bundle;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.clabuyakchai.staff.R;
import com.clabuyakchai.staff.ui.activity.StartActivity;
import com.clabuyakchai.staff.ui.activity.auth.AuthActivity;
import com.clabuyakchai.staff.ui.base.BaseActivity;
import com.clabuyakchai.staff.ui.fragment.navigation.home.HomeFragment;
import com.clabuyakchai.staff.ui.fragment.navigation.route.RouteFragment;
import com.clabuyakchai.staff.ui.fragment.navigation.station.StationFragment;
import com.clabuyakchai.staff.util.Screens;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;
import ru.terrakok.cicerone.android.support.SupportAppNavigator;

public class NavigationActivity extends BaseActivity implements StartActivity, NavigationView {

    @Inject
    NavigatorHolder navigatorHolder;

    @Inject
    @InjectPresenter
    NavigationActivityPresenter presenter;

    @ProvidePresenter
    public NavigationActivityPresenter provideNavigationActivityPresenter(){
        return presenter;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(listener);

        idConteiner = R.id.navigation_container;

        //TODO
        presenter.onRouteClicked();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener listener = item -> {
        switch (item.getItemId()) {
            case R.id.navigation_item_route:
                    presenter.onRouteClicked();
                return true;
            case R.id.navigation_item_station:
                presenter.onStationClicked();
                return true;
            case R.id.navigation_item_staff:
                presenter.onHomeClicked();
                return true;
            default:
                return false;
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        navigatorHolder.setNavigator(navigator);
    }

    @Override
    protected void onPause() {
        navigatorHolder.removeNavigator();
        super.onPause();
    }

    private Navigator navigator = new SupportAppNavigator(this, R.id.navigation_container);

    @Override
    public void setIdConteiner() {
        idConteiner = R.id.navigation_container;
    }

    @Override
    public void startActivity() {
        Intent intent = new Intent(NavigationActivity.this, AuthActivity.class);
        startActivity(intent);
        finish();
    }
}
