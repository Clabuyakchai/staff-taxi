package com.clabuyakchai.staff.util;

import android.content.Context;
import android.content.Intent;

import com.clabuyakchai.staff.ui.activity.navigation.NavigationActivity;
import com.clabuyakchai.staff.ui.fragment.navigation.bus.BusFragment;
import com.clabuyakchai.staff.ui.fragment.navigation.home.HomeFragment;
import com.clabuyakchai.staff.ui.fragment.navigation.newroute.NewRouteFragment;
import com.clabuyakchai.staff.ui.fragment.navigation.route.RouteFragment;
import com.clabuyakchai.staff.ui.fragment.navigation.routedetail.RouteDetailFragment;
import com.clabuyakchai.staff.ui.fragment.navigation.station.StationFragment;
import com.clabuyakchai.staff.ui.fragment.tab.TabNavigationFragment;

import androidx.fragment.app.Fragment;
import ru.terrakok.cicerone.android.support.SupportAppScreen;

public class Screens {
    public static final class NavigationScreen extends SupportAppScreen{
        @Override
        public Intent getActivityIntent(Context context) {
            return new Intent(context, NavigationActivity.class);
        }
    }

    public static final class HomeScreen extends SupportAppScreen{
        @Override
        public Fragment getFragment() {
            return HomeFragment.newInstance();
        }
    }

    public static final class RouteScreen extends SupportAppScreen{
        private final String name;

        public RouteScreen(String name) {
            this.name = name;
        }

        @Override
        public Fragment getFragment() {
            return RouteFragment.newInstance(name);
        }
    }

    public static final class RouteDetailScreen extends SupportAppScreen{
        private final Long timetableId;

        public RouteDetailScreen(Long timetableId) {
            this.timetableId = timetableId;
        }

        @Override
        public Fragment getFragment() {
            return RouteDetailFragment.newInstance(timetableId);
        }
    }

    public static final class StationScreen extends SupportAppScreen{
        @Override
        public Fragment getFragment() {
            return StationFragment.newInstance();
        }
    }

    public static final class TabScreen extends SupportAppScreen {
        private final String tabName;

        public TabScreen(String tabName) {
            this.tabName = tabName;
        }

        @Override
        public Fragment getFragment() {
            return TabNavigationFragment.newInstance(tabName);
        }
    }

    public static final class BusScreen extends SupportAppScreen{
        @Override
        public Fragment getFragment() {
            return BusFragment.newInstance();
        }
    }

    public static final class NewRouteScreen extends SupportAppScreen{
        @Override
        public Fragment getFragment() {
            return NewRouteFragment.newInstance();
        }
    }
}
