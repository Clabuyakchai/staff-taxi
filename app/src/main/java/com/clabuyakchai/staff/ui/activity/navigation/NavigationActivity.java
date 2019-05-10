package com.clabuyakchai.staff.ui.activity.navigation;

import android.content.Intent;
import android.os.Bundle;

import com.clabuyakchai.staff.R;
import com.clabuyakchai.staff.ui.activity.StartActivity;
import com.clabuyakchai.staff.ui.activity.auth.AuthActivity;
import com.clabuyakchai.staff.ui.base.BaseActivity;
import com.clabuyakchai.staff.ui.fragment.navigation.home.HomeFragment;
import com.clabuyakchai.staff.ui.fragment.navigation.route.RouteFragment;
import com.clabuyakchai.staff.ui.fragment.station.StationFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;
import ru.terrakok.cicerone.Screen;
import ru.terrakok.cicerone.android.support.SupportAppNavigator;
import ru.terrakok.cicerone.commands.Command;

public class NavigationActivity extends BaseActivity implements StartActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(listener);

        idConteiner = R.id.navigation_container;

        Fragment fragment = fm.findFragmentById(R.id.navigation_container);
        if(fragment == null){
            add(RouteFragment.newInstance(), false);
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener listener = item -> {
        switch (item.getItemId()) {
            case R.id.navigation_item_route:
                add(RouteFragment.newInstance(), false);
                return true;
            case R.id.navigation_item_station:
                add(StationFragment.newInstance(), false);
                return true;
            case R.id.navigation_item_staff:
                add(HomeFragment.newInstance(), false);
                return true;
            default:
                return false;
        }
    };

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
