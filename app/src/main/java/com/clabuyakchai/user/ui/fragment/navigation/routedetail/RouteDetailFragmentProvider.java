package com.clabuyakchai.user.ui.fragment.navigation.routedetail;

import com.clabuyakchai.user.di.scope.FragmentScope;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface RouteDetailFragmentProvider {
    @FragmentScope
    @ContributesAndroidInjector
    RouteDetailFragment bindRouteDetailFragment();
}
