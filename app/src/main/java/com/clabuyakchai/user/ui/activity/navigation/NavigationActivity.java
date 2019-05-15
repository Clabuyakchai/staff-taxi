package com.clabuyakchai.user.ui.activity.navigation;

import android.content.Intent;
import android.os.Bundle;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.clabuyakchai.user.ui.activity.StartActivity;
import com.clabuyakchai.user.ui.activity.auth.AuthActivity;
import com.clabuyakchai.user.ui.base.BaseActivity;
import com.clabuyakchai.user.R;
import com.clabuyakchai.user.ui.fragment.tab.BackButtonListener;
import com.clabuyakchai.user.ui.fragment.tab.RouterProvider;
import com.clabuyakchai.user.util.Screens;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.List;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;
import ru.terrakok.cicerone.android.support.SupportAppNavigator;

public class NavigationActivity extends BaseActivity implements StartActivity, NavigationView, RouterProvider {
    private BottomNavigationView navigation;
    @Inject
    NavigatorHolder navigatorHolder;

    @Inject
    @InjectPresenter
    NavigationActivityPresenter presenter;

    @Inject
    Router router;

    @ProvidePresenter
    public NavigationActivityPresenter provideNavigationActivityPresenter() {
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

    }

    private BottomNavigationView.OnNavigationItemSelectedListener listener = item -> {
        switch (item.getItemId()) {
            case R.id.navigation_item_route_staff:
                selectTab("Route");
                return true;
            case R.id.navigation_item_station:
                selectTab("Station");
                return true;
            case R.id.navigation_item_user:
                selectTab("Home");
                return true;
            case R.id.navigation_item_book:
                selectTab("Book");
                return true;
            case R.id.navigation_item_route_user:
                selectTab("Ticket");
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
        navigation.getMenu().findItem(R.id.navigation_item_route_staff).setVisible(isDriver);
        navigation.getMenu().findItem(R.id.navigation_item_station).setVisible(isDriver);
        navigation.getMenu().findItem(R.id.navigation_item_book).setVisible(!isDriver);
        navigation.getMenu().findItem(R.id.navigation_item_route_user).setVisible(!isDriver);
        if (isDriver){
//            navigation.setSelectedItemId(0);
        } else {
//            navigation.setSelectedItemId(0); //TODO поменять id
        }
    }

    @Override
    public void showSnackBar(String text) {
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroyActivity();
        super.onDestroy();
    }

    private void selectTab(String tab) {
        FragmentManager fm = getSupportFragmentManager();
        Fragment currentFragment = null;
        List<Fragment> fragments = fm.getFragments();
        if (fragments != null) {
            for (Fragment f : fragments) {
                if (f.isVisible()) {
                    currentFragment = f;
                    break;
                }
            }
        }
        Fragment newFragment = fm.findFragmentByTag(tab);

        if (currentFragment != null && newFragment != null && currentFragment == newFragment) return;

        FragmentTransaction transaction = fm.beginTransaction();
        if (newFragment == null) {
            transaction.add(R.id.navigation_container, new Screens.TabScreen(tab).getFragment(), tab);
        }

        if (currentFragment != null) {
            transaction.hide(currentFragment);
        }

        if (newFragment != null) {
            transaction.show(newFragment);
        }
        transaction.commitNow();
    }

    @Override
    public void onBackPressed() {
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = null;
        List<Fragment> fragments = fm.getFragments();
        if (fragments != null) {
            for (Fragment f : fragments) {
                if (f.isVisible()) {
                    fragment = f;
                    break;
                }
            }
        }
        if (fragment != null
                && fragment instanceof BackButtonListener
                && ((BackButtonListener) fragment).onBackPressed()) {
            return;
        } else {
            presenter.onBackPressed();
        }
    }

    @Override
    public Router getRouter() {
        return router;
    }
}
