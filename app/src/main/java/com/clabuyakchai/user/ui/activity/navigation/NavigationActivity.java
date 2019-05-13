package com.clabuyakchai.user.ui.activity.navigation;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.clabuyakchai.user.ui.activity.StartActivity;
import com.clabuyakchai.user.ui.activity.auth.AuthActivity;
import com.clabuyakchai.user.ui.base.BaseActivity;
import com.clabuyakchai.user.R;
import com.clabuyakchai.user.util.Preferences;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.android.support.SupportAppNavigator;

public class NavigationActivity extends BaseActivity implements StartActivity, NavigationView {
    private BottomNavigationView navigation;
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
        presenter.onCreateActivity();
        setContentView(R.layout.activity_navigation);

        navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(listener);

        idConteiner = R.id.navigation_container;

        Toast.makeText(this, Preferences.getTokenSharedPreferences(this), Toast.LENGTH_LONG).show();
        showDriverFunction(true);

        //TODO
//        presenter.onRouteClicked();
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

    @Override
    public void showDriverFunction(Boolean isDriver) {
        if (isDriver) {
            navigation.getMenu().findItem(R.id.navigation_item_route).setVisible(true);
            navigation.getMenu().findItem(R.id.navigation_item_station).setVisible(true);
        } else {
            navigation.getMenu().findItem(R.id.navigation_item_route).setVisible(false);
            navigation.getMenu().findItem(R.id.navigation_item_station).setVisible(false);
        }
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroyActivity();
        super.onDestroy();
    }
}
