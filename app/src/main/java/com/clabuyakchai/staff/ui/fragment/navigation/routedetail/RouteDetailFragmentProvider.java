package com.clabuyakchai.staff.ui.fragment.navigation.routedetail;

import com.clabuyakchai.staff.di.scope.FragmentScope;
import com.clabuyakchai.staff.ui.fragment.navigation.route.RouteFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface RouteDetailFragmentProvider {
    @FragmentScope
    @ContributesAndroidInjector
    RouteDetailFragment bindRouteDetailFragment();
}
