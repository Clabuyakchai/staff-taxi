package com.clabuyakchai.staff.ui.activity.navigation;

import android.os.Bundle;

import com.clabuyakchai.staff.R;
import com.clabuyakchai.staff.ui.base.BaseActivity;
import com.clabuyakchai.staff.ui.fragment.navigation.home.HomeFragment;
import com.clabuyakchai.staff.ui.fragment.navigation.route.RouteFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class NavigationActivity extends BaseActivity {


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
}
